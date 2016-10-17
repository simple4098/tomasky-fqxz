package com.tomasky.fqxz.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.bo.param.product.ProductBo;
import com.tomasky.fqxz.bo.param.product.ProductOrderBo;
import com.tomasky.fqxz.common.SysConfig;
import com.tomasky.fqxz.common.exception.ProductException;
import com.tomasky.fqxz.common.utils.DateUtil;
import com.tomasky.fqxz.common.utils.OrderUtil;
import com.tomasky.fqxz.dao.IProductDao;
import com.tomasky.fqxz.helper.InnHelper;
import com.tomasky.fqxz.mapper.IOrderDetailMapper;
import com.tomasky.fqxz.mapper.IProductMapper;
import com.tomasky.fqxz.mapper.IProductOrderMapper;
import com.tomasky.fqxz.model.OrderDetail;
import com.tomasky.fqxz.model.Product;
import com.tomasky.fqxz.model.ProductOrder;
import com.tomasky.fqxz.service.IProductService;
import com.tomasky.fqxz.vo.PayResultVo;
import com.tomasky.fqxz.vo.PmsInnInfo;
import com.tomasky.fqxz.vo.ProductOrderVo;
import com.tomasky.fqxz.vo.ProductVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author simple
 * @data 2016/10/10
 */
@Service
public class ProductService implements IProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Resource
    private IProductMapper productMapper;
    @Resource
    private IProductDao productDao;
    @Resource
    private IProductOrderMapper productOrderMapper;
    @Resource
    private IOrderDetailMapper orderDetailMapper;
    @Resource
    private  InnHelper innHelper;
    @Resource
    private SysConfig sysConfig;
    @Resource
    private MessageSourceAccessor messageSourceAccessor;

    @Override
    public PageInfo<Product> findProductByInnId(CommParam param) throws ProductException {
        Assert.notNull(param.getInnId(),messageSourceAccessor.getMessage("xz.product.innId.error"));
        PageHelper.startPage(param.getPageNo(), param.getPageSize());
        List<Product> productList = productMapper.selectProductByInnId(param);
        String imgHost =sysConfig.getImgHost();
        for (Product p : productList  ) {
            p.setProPic(imgHost+p.getProPic());
        }
        return new PageInfo(productList);
    }

    @Override
    public ProductVo findProductDetail(ProductBo productBo) throws Exception{
        Assert.notNull(productBo.getInnId(),messageSourceAccessor.getMessage("xz.product.innId.error"));
        Assert.notNull(productBo.getId(),messageSourceAccessor.getMessage("xz.product.productId.error"));
        String imgHost =sysConfig.getImgHost();
        Product product = productMapper.selectProductDetailById(productBo.getId());
        ProductVo productVo = new ProductVo();
        BeanUtils.copyProperties(productVo,product);
        productVo.setProPic(imgHost+product.getProPic());
        try {
            PmsInnInfo pmsInnInfo = innHelper.obtInnInfo(productBo.getInnId());
            productVo.setTel(pmsInnInfo.getReceiveMsgPhone1()+","+pmsInnInfo.getReceiveMsgPhone2());
            productVo.setInnName(pmsInnInfo.getName());
        }catch (Exception e){
            logger.error(messageSourceAccessor.getMessage("xz.innInfo.error"),e);
        }
        return productVo;
    }

    @Transactional
    @Override
    public ProductOrderVo order(ProductOrderBo productBo) throws Exception {
        String orderNo = OrderUtil.obtOrderNo();
        try{
            productBo.assertNotNull();
        }catch (Exception e){
            throw new ProductException( messageSourceAccessor.getMessage("xz.order.param.error"));
        }
        ProductOrder productOrder = productOrderMapper.selectProductOrderByOrderNo(orderNo);
        if (productOrder!=null){
            throw new ProductException( messageSourceAccessor.getMessage("xz.order.repeat"));
        }
        ProductOrderVo productOrderVo = new ProductOrderVo();
        BeanUtils.copyProperties(productOrderVo,productBo);
        PmsInnInfo pmsInnInfo = null;
        try {
            Date date = new Date();
            Date outTime = DateUtil.addMinutes(date, 30);
            pmsInnInfo = innHelper.obtInnInfo(productBo.getInnId());
            productOrderVo.setInnName(pmsInnInfo.getName());
            productOrderVo.setOrderNo(orderNo);
            productOrderVo.setCreateTime(date);
            productOrderVo.setOutTime(outTime);
            productOrderVo.setTotalPrice(productOrderVo.getPrice().multiply(new BigDecimal(productOrderVo.getNum())));
            productOrderVo.setIsFailed("0");
            productOrderVo.setIsPay("0");
            productOrderVo.setPayExpirationTime(DateUtil.format(outTime,DateUtil.FORMAT_DATE_STR_ONE));
            productOrderVo.setCallbackUrl(sysConfig.getOrderCallbackUrl());
            productOrderVo.setBossPhone(pmsInnInfo.getReceiveMsgPhone1()+","+pmsInnInfo.getReceiveMsgPhone2());
            Product product = productDao.findById(productOrderVo.getProductId());
            if (product!=null){
                BigDecimal subtract = product.getPrice().subtract(productOrderVo.getPrice());
                if(subtract.intValue()!=0){
                    throw new ProductException(messageSourceAccessor.getMessage("xz.order.param.price"));
                }
                if (product.getStock()<=0 || productOrderVo.getNum()>product.getStock()){
                    throw new ProductException(messageSourceAccessor.getMessage("xz.order.param.stock"));
                }
            }
            productOrderMapper.saveProductOrder(productOrderVo);
            productOrderVo.setXzOrderId(productOrderVo.getId());
            product.setStock(product.getStock()-productOrderVo.getNum());
            int i = product.getSales()+ productOrderVo.getNum();
            product.setSales(i);
            productMapper.updateStockAndSales(product);
            orderDetailMapper.saveOrderDetail(new OrderDetail(productOrderVo.getId(),productOrderVo.getProductId(),productOrderVo.getPrice(),productOrderVo.getNum(),productOrderVo.getTotalPrice(),product.getProName()));

        } catch (Exception e) {
            String message = messageSourceAccessor.getMessage("xz.order.error");
            logger.error(message,e);
            throw new ProductException(message+e);
        }
        return productOrderVo;
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public void orderCallback(String payResultJson)throws ProductException {
        if (StringUtils.isNotEmpty(payResultJson)){
            PayResultVo payResultVo = JSON.parseObject(payResultJson, PayResultVo.class);
            //成功
            ProductOrder productOrder =  productOrderMapper.selectProductOrderById(payResultVo.getXzOrderId());
            Product product = productMapper.selectProductDetailById(payResultVo.getProductId());
            if ("1".equals(payResultVo.getPayStatus())){
               if (productOrder!=null){
                   productOrder.setPayOrderNo(payResultVo.getOrderNo());
                   productOrder.setIsFailed("1");
                   productOrderMapper.updateProductOrder(productOrder);
                   //String msg = "您已经成功购买 ".$brandName." ".$proName." ".$proNum."件；订单金额：".$totalprice."元，已付金额：".$totalprice."元。客栈联系电话：".$bossPhone."； 订单号：".$payOrderNo."；请自行联系客栈商讨收货等相关事宜。";
                   String msg = messageSourceAccessor.getMessage("xz.order.message",new Object[]{payResultVo.getInnName(), payResultVo.getProName(),new Integer(payResultVo.getNum())
                           ,payResultVo.getTotalPrice(),payResultVo.getTotalPrice(),payResultVo.getBossPhone(),payResultVo.getOrderNo()});
                   OrderUtil.sendMsg(payResultVo.getPhone(),msg);
               }
            //失败
            }else {
                productOrder.setIsFailed("0");
                productOrderMapper.updateProductOrder(productOrder);
                product.setStock(product.getStock()+payResultVo.getNum());
                product.setSales(product.getSales()-payResultVo.getNum());
                productMapper.updateStockAndSales(product);
            }
        }

    }
}
