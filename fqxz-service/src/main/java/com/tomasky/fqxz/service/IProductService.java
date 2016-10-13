package com.tomasky.fqxz.service;

import com.github.pagehelper.PageInfo;
import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.bo.param.product.ProductBo;
import com.tomasky.fqxz.bo.param.product.ProductOrderBo;
import com.tomasky.fqxz.common.exception.ProductException;
import com.tomasky.fqxz.model.Product;
import com.tomasky.fqxz.vo.ProductOrderVo;
import com.tomasky.fqxz.vo.ProductVo;

/**
 * @author simple
 * @data 2016/10/10
 */
public interface IProductService {
    /**
     * 查询客栈商品集合
     * @param commParam 查询参数
     * @throws ProductException
     */
    PageInfo<Product> findProductByInnId(CommParam commParam)throws ProductException;

    /**
     * 商品详情
     * @param productBo
     * @return
     */
    ProductVo findProductDetail(ProductBo productBo) throws Exception;

    /**
     * 商品下单
     * @param productBo 下单信息
     * @throws ProductException
     */
    ProductOrderVo order(ProductOrderBo productBo) throws Exception;

    /**
     * 商品支付回调
     * @param payResultJson 支付系统回调的json字符串
     */
    void orderCallback(String payResultJson)throws ProductException;
}
