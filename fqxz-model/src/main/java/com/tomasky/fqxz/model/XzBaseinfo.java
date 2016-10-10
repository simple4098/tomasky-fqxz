package com.tomasky.fqxz.model;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "xz_baseinfo")
public class XzBaseinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 客栈id
     */
    private Integer innId;

    /**
     * 小站域名
     */
    private String address;

    /**
     * 账号id
     */
    private Integer accountid;

    /**
     * 账号
     */
    private String account;

    /**
     * 邮政编码
     */
    private String addressCode;

    /**
     * 传真
     */
    private String fax;

    /**
     * 样式
     */
    private Integer innShopStyle;

    /**
     * 访问次数
     */
    private Integer visitCount;

    /**
     * 支付宝
     */
    private String alipayAccount;

    /**
     * 支付宝pid
     */
    private String alipayPid;

    /**
     * 支付宝key
     */
    private String alipayKey;

    /**
     * 客栈地址
     */
    private String innPointAddress;

    /**
     * 怎么去
     */
    private String fromTo;

    /**
     * 支付类型
     */
    private Integer payType;

    /**
     * 支付宝账号
     */
    private String alipayAccountAgent;

    /**
     * 是否同意？
     */
    private Integer isAgreeItem;

    /**
     * 推荐
     */
    private String explosionRecommend;

    /**
     *
     */
    private String explosionDesc;

    /**
     * 预定须知
     */
    private String mustKnown;

    /**
     * 推荐权重
     */
    private Integer explosionWeight;

    /**
     * 省份
     */
    private String province;

    /**
     * 市区
     */
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getInnShopStyle() {
        return innShopStyle;
    }

    public void setInnShopStyle(Integer innShopStyle) {
        this.innShopStyle = innShopStyle;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getAlipayPid() {
        return alipayPid;
    }

    public void setAlipayPid(String alipayPid) {
        this.alipayPid = alipayPid;
    }

    public String getAlipayKey() {
        return alipayKey;
    }

    public void setAlipayKey(String alipayKey) {
        this.alipayKey = alipayKey;
    }

    public String getInnPointAddress() {
        return innPointAddress;
    }

    public void setInnPointAddress(String innPointAddress) {
        this.innPointAddress = innPointAddress;
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getAlipayAccountAgent() {
        return alipayAccountAgent;
    }

    public void setAlipayAccountAgent(String alipayAccountAgent) {
        this.alipayAccountAgent = alipayAccountAgent;
    }

    public Integer getIsAgreeItem() {
        return isAgreeItem;
    }

    public void setIsAgreeItem(Integer isAgreeItem) {
        this.isAgreeItem = isAgreeItem;
    }

    public String getExplosionRecommend() {
        return explosionRecommend;
    }

    public void setExplosionRecommend(String explosionRecommend) {
        this.explosionRecommend = explosionRecommend;
    }

    public String getExplosionDesc() {
        return explosionDesc;
    }

    public void setExplosionDesc(String explosionDesc) {
        this.explosionDesc = explosionDesc;
    }

    public String getMustKnown() {
        return mustKnown;
    }

    public void setMustKnown(String mustKnown) {
        this.mustKnown = mustKnown;
    }

    public Integer getExplosionWeight() {
        return explosionWeight;
    }

    public void setExplosionWeight(Integer explosionWeight) {
        this.explosionWeight = explosionWeight;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
