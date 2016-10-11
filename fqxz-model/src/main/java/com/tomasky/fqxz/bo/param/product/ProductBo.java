package com.tomasky.fqxz.bo.param.product;

import com.tomasky.fqxz.bo.param.CommParam;

import java.math.BigDecimal;

/**
 * @author simple
 * 查询商品、以及商品下单
 * @data 2016/10/11
 */
public class ProductBo extends CommParam {

    //商品id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
