package com.tomasky.bill.vo.count;


import com.tomasky.bill.util.NumberUtil;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by X on 2016/9/13.
 */
public class CountVo implements Serializable {

    /** 总订单数 */
    private Integer totalOrderNum;
    /** 总金额 */
    private BigDecimal totalAmount;
    /** 实付总金额 */
    private BigDecimal paidAmount;
    /** 手续费总金额 */
    private BigDecimal poundageAmount;
    /** 未结算订单数 */
    private Integer unliqOrderNum;
    /** 未结算总金额 */
    private BigDecimal unliqAmount;
    /** 未结算实付总金额 */
    private BigDecimal unliqPaidAmount;
    /** 未结算手续费总金额 */
    private BigDecimal unliqPoundageAmount;

    public Integer getTotalOrderNum() {
        return totalOrderNum;
    }

    public void setTotalOrderNum(Integer totalOrderNum) {
        this.totalOrderNum = totalOrderNum;
    }

    public BigDecimal getTotalAmount() {
        totalAmount = NumberUtil.filter(totalAmount);
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPaidAmount() {
        paidAmount = NumberUtil.filter(paidAmount);
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getPoundageAmount() {
        poundageAmount = NumberUtil.filter(poundageAmount);
        return poundageAmount;
    }

    public void setPoundageAmount(BigDecimal poundageAmount) {
        this.poundageAmount = poundageAmount;
    }

    public Integer getUnliqOrderNum() {
        return unliqOrderNum;
    }

    public void setUnliqOrderNum(Integer unliqOrderNum) {
        this.unliqOrderNum = unliqOrderNum;
    }

    public BigDecimal getUnliqAmount() {
        unliqAmount = NumberUtil.filter(unliqAmount);
        return unliqAmount;
    }

    public void setUnliqAmount(BigDecimal unliqAmount) {
        this.unliqAmount = unliqAmount;
    }

    public BigDecimal getUnliqPaidAmount() {
        unliqPaidAmount = NumberUtil.filter(unliqPaidAmount);
        return unliqPaidAmount;
    }

    public void setUnliqPaidAmount(BigDecimal unliqPaidAmount) {
        this.unliqPaidAmount = unliqPaidAmount;
    }

    public BigDecimal getUnliqPoundageAmount() {
        unliqPoundageAmount = NumberUtil.filter(unliqPoundageAmount);
        return unliqPoundageAmount;
    }

    public void setUnliqPoundageAmount(BigDecimal unliqPoundageAmount) {
        this.unliqPoundageAmount = unliqPoundageAmount;
    }
}
