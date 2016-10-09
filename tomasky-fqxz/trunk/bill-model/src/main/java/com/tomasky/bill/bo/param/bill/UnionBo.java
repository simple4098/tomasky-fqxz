package com.tomasky.bill.bo.param.bill;

import com.tomasky.bill.bo.param.CommParam;

/**
 * Created by X on 2016/9/12.
 */
public class UnionBo extends CommParam {

    private Integer unionType;
    private Integer unionId;
    private Integer payStatus;
    private String innName;
    private String orderNo;

    public Integer getUnionType() {
        return unionType;
    }

    public void setUnionType(Integer unionType) {
        this.unionType = unionType;
    }

    public Integer getUnionId() {
        return unionId;
    }

    public void setUnionId(Integer unionId) {
        this.unionId = unionId;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
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
}
