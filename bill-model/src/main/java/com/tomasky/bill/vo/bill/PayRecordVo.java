package com.tomasky.bill.vo.bill;


import com.tomasky.bill.util.NumberUtil;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by X on 2016/9/8.
 */
public class PayRecordVo implements Serializable {

    private Integer id;
    private Integer pmsInnId;
    private Integer regionId;
    private String innName;
    private String productCode;
    private String orderCode;
    private String tradeNo;
    private String payMode;
    private String payType;
    private String payDesc;
    private BigDecimal deductPrice;
    private BigDecimal poundageRatio;
    private BigDecimal commissionRatio;
    private BigDecimal payPrice;
    private String payAt;
    private String balanceAt;
    private String settleAt;
    private String isBalance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPmsInnId() {
        return pmsInnId;
    }

    public void setPmsInnId(Integer pmsInnId) {
        this.pmsInnId = pmsInnId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getInnName() {
        return innName;
    }

    public void setInnName(String innName) {
        this.innName = innName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayDesc() {
        return payDesc;
    }

    public void setPayDesc(String payDesc) {
        this.payDesc = payDesc;
    }

    public BigDecimal getDeductPrice() {
        deductPrice = NumberUtil.filter(deductPrice);
        return deductPrice;
    }

    public void setDeductPrice(BigDecimal deductPrice) {
        this.deductPrice = deductPrice;
    }

    public BigDecimal getPoundageRatio() {
        poundageRatio = NumberUtil.filter(poundageRatio);
        return poundageRatio;
    }

    public void setPoundageRatio(BigDecimal poundageRatio) {
        this.poundageRatio = poundageRatio;
    }

    public BigDecimal getCommissionRatio() {
        commissionRatio = NumberUtil.filter(commissionRatio);
        return commissionRatio;
    }

    public void setCommissionRatio(BigDecimal commissionRatio) {
        this.commissionRatio = commissionRatio;
    }

    public BigDecimal getPayPrice() {
        payPrice = NumberUtil.filter(payPrice);
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public String getPayAt() {
        return payAt;
    }

    public void setPayAt(String payAt) {
        this.payAt = payAt;
    }

    public String getBalanceAt() {
        return balanceAt;
    }

    public void setBalanceAt(String balanceAt) {
        this.balanceAt = balanceAt;
    }

    public String getSettleAt() {
        return settleAt;
    }

    public void setSettleAt(String settleAt) {
        this.settleAt = settleAt;
    }

    public String getIsBalance() {
        return isBalance;
    }

    public void setIsBalance(String isBalance) {
        this.isBalance = isBalance;
    }
}
