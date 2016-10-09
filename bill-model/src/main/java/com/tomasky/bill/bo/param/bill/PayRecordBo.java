package com.tomasky.bill.bo.param.bill;

import com.google.common.collect.Lists;
import com.tomasky.bill.bo.param.CommParam;

import java.util.List;

/**
 * Created by X on 2016/9/8.
 */
public class PayRecordBo extends CommParam {

    private String productCode;
    private String payType;
    private String timeType;
    private List<Integer> innIds = Lists.newArrayList();
    private String receiptType;
    private String innName;
    private String orderNo;
    private String tradeNo;
    private Integer status;
    private Integer isBalance;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public List<Integer> getInnIds() {
        return innIds;
    }

    public void setInnIds(List<Integer> innIds) {
        this.innIds = innIds;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public String getInnName() {
        return innName;
    }

    public void setInnName(String innName) {
        this.innName = innName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsBalance() {
        return isBalance;
    }

    public void setIsBalance(Integer isBalance) {
        this.isBalance = isBalance;
    }
}
