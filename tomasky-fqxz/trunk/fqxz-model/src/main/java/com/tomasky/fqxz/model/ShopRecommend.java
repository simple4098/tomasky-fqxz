package com.tomasky.fqxz.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Create by jame
 * Date: 2016/10/11 14:58
 * Version: 1.0
 * Description: 阐述
 */
@Entity
public class ShopRecommend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "innid")
    private Long innId; //小站id
    @Column(name = "shopname")
    private String shopName;    //分店名称
    private String tel;    //分店电话
    private String address;//分店地址
    private String website;//分店网址
    @Column(name = "createtime")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInnId() {
        return innId;
    }

    public void setInnId(Long innId) {
        this.innId = innId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
