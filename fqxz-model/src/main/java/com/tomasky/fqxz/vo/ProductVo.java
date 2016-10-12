package com.tomasky.fqxz.vo;

import com.tomasky.fqxz.model.Product;

/**
 * @author simple
 * @data 2016/10/11
 */
public class ProductVo extends Product{
    //商家联系电话
    private String tel;
    private String innName;

    public String getInnName() {
        return innName;
    }
    public void setInnName(String innName) {
        this.innName = innName;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
