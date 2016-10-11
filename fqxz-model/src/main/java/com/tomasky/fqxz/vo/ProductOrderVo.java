package com.tomasky.fqxz.vo;

import com.tomasky.fqxz.bo.param.product.ProductOrderBo;

/**
 * @author simple
 * 查询商品、以及商品下单
 * @data 2016/10/11
 */
public class ProductOrderVo extends ProductOrderBo {

    //客栈名称
    private String innName;
    //支付过期时间
    private String payExpirationTime;


    public String getInnName() {
        return innName;
    }

    public void setInnName(String innName) {
        this.innName = innName;
    }

    public String getPayExpirationTime() {
        return payExpirationTime;
    }

    public void setPayExpirationTime(String payExpirationTime) {
        this.payExpirationTime = payExpirationTime;
    }
}
