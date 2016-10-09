package com.tomasky.bill.bo.param.bill;

import com.tomasky.bill.bo.param.CommParam;
import com.tomasky.bill.config.Constants;

import java.util.Date;

/**
 * Created by X on 2016/9/13.
 */
public class BalanceBo extends CommParam {
    private Date now;
    private String timeType;
    private String productCode;
    private String orderNo;
    private String tradeNo;
    private String receiptType = Constants.PAY_RECEIPT_COLLECTION;
    private Integer isBalance = Constants.IS_BALANCE_NO;
    private Integer balance = Constants.IS_BALANCE_YES;

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public Integer getIsBalance() {
        return isBalance;
    }

    public void setIsBalance(Integer isBalance) {
        this.isBalance = isBalance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getNow() {
        if(now == null){
            now = new Date();
        }
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }
}
