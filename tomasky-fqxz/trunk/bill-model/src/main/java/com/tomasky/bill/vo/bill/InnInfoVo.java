package com.tomasky.bill.vo.bill;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by X on 2016/9/9.
 */
public class InnInfoVo {
    private Integer id;
    private String name;
    private String alipayCode;
    private String alipayUser;
    private String tenpayCode;
    private String tenpayUser;
    /** 1:个人账户/2:公司账户 */
    private Integer bankType;
    private String bankAccount;
    private String bankCode;
    private String bankName;
    private String bankRegion;
    private String bankProvince;
    private String bankCity;
    private List<PayRecordVo> payRecords = Lists.newArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlipayCode() {
        return alipayCode;
    }

    public void setAlipayCode(String alipayCode) {
        this.alipayCode = alipayCode;
    }

    public String getAlipayUser() {
        return alipayUser;
    }

    public void setAlipayUser(String alipayUser) {
        this.alipayUser = alipayUser;
    }

    public String getTenpayCode() {
        return tenpayCode;
    }

    public void setTenpayCode(String tenpayCode) {
        this.tenpayCode = tenpayCode;
    }

    public String getTenpayUser() {
        return tenpayUser;
    }

    public void setTenpayUser(String tenpayUser) {
        this.tenpayUser = tenpayUser;
    }

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankRegion() {
        return bankRegion;
    }

    public void setBankRegion(String bankRegion) {
        this.bankRegion = bankRegion;
    }

    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public List<PayRecordVo> getPayRecords() {
        return payRecords;
    }

    public void setPayRecords(List<PayRecordVo> payRecords) {
        this.payRecords = payRecords;
    }
}
