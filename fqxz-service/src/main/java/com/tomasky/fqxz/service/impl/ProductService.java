package com.tomasky.fqxz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.bo.param.product.ProductBo;
import com.tomasky.fqxz.bo.param.product.ProductOrderBo;
import com.tomasky.fqxz.common.exception.ProductException;
import com.tomasky.fqxz.common.utils.ConfigUtil;
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
import com.tomasky.fqxz.vo.PmsInnInfo;
import com.tomasky.fqxz.vo.ProductOrderVo;
import com.tomasky.fqxz.vo.ProductVo;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
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

    @Override
    public PageInfo<Product> findProductByInnId(CommParam param) throws ProductException {
        Assert.notNull(param.getInnId());
        PageHelper.startPage(param.getPageNo(), param.getPageSize());
        List<Product> productList = productMapper.selectProductByInnId(param);
        String imgHost = ConfigUtil.obtHost("img.host");
        for (Product p : productList  ) {
            p.setProPic(imgHost+p.getProPic());
        }
        return new PageInfo(productList);
    }

    @Override
    public ProductVo findProductDetail(ProductBo productBo) throws Exception{
        Assert.notNull(productBo.getInnId());
        Assert.notNull(productBo.getId());
        String imgHost = ConfigUtil.obtHost("img.host");
        Product product = productMapper.selectProductDetail(productBo);
        ProductVo productVo = new ProductVo();
        BeanUtils.copyProperties(productVo,product);
        productVo.setProPic(imgHost+product.getProPic());
        try {
            PmsInnInfo pmsInnInfo = InnHelper.obtInnInfo(productBo.getInnId());
            productVo.setTel(pmsInnInfo.getReceiveMsgPhone1()+","+pmsInnInfo.getReceiveMsgPhone2());
        }catch (Exception e){
            logger.error("请求pms客栈基本信息出错",e);
        }
        return productVo;
    }

    @Override
    public ProductOrderVo order(ProductOrderBo productBo) throws Exception {
        String orderNo = OrderUtil.obtOrderNo();
        ProductOrder productOrder = productOrderMapper.selectProductOrderByOrderNo(orderNo);
        if (productOrder!=null){
            throw new ProductException("请不要重复提交订单");
        }
        ProductOrderVo productOrderVo = new ProductOrderVo();
        BeanUtils.copyProperties(productOrderVo,productBo);
        PmsInnInfo pmsInnInfo = null;
        try {
            Date date = new Date();
            pmsInnInfo = InnHelper.obtInnInfo(productBo.getInnId());
            productOrderVo.setInnName(pmsInnInfo.getName());
            productOrderVo.setOrderNo(orderNo);
            productOrderVo.setCreateTime(date);
            productOrderVo.setPayTime(date);
            productOrderVo.setOutTime(DateUtil.addMinutes(date,30));
            productOrderVo.setTotalPrice(productOrderVo.getPrice().multiply(new BigDecimal(productOrderVo.getNum())));
            productOrderVo.setIsFailed("0");
            productOrderVo.setIsPay("0");
            Integer productOrderId = productOrderMapper.saveProductOrder(productOrderVo);
            if (productOrderId!=null){
                Product product = productDao.findById(productOrderVo.getProductId());
                product.setStock(product.getStock()-productOrderVo.getNum());
                int i = product.getSales()+ productOrderVo.getNum();
                product.setSales(i);
                productMapper.updateStockAndSales(product);
                orderDetailMapper.saveOrderDetail(new OrderDetail(productOrderVo.getId(),productOrderVo.getProductId(),productOrderVo.getPrice(),productOrderVo.getNum(),productOrderVo.getTotalPrice(),product.getProName()));
            }
        } catch (Exception e) {
            logger.error("请求pms客栈基本信息出错",e);
            throw new ProductException("请求pms客栈基本信息出错"+e.getMessage());
        }
        return productOrderVo;
    }
}
