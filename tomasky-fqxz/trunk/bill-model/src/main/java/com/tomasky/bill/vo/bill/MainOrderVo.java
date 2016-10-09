package com.tomasky.bill.vo.bill;

import java.math.BigDecimal;

/**
 * Created by X on 2016/9/12.
 */
public class MainOrderVo {
    /** 订单ID */
    private Integer id;
    /** 客栈目的地ID */
    private Integer regionId;
    /** 客栈名称 */
    private String innName;
    /** PMS客栈ID */
    private Integer pmsInnId;
    /** 分销订单编号 */
    private String tradeNo;
    /** 支付流水交易号 */
    private String orderNo;
    /** 下单联系人手机号 */
    private String contact;
    /** 下单联系人姓名 */
    private String name;
    /** 房型名称 */
    private String roomTypeName;
    /** 预定房间数量 */
    private Integer roomTypeNum;
    /** 入住时间 */
    private String checkInAt;
    /** 离店时间 */
    private String checkOutAt;
    /** 订单总金额 */
    private BigDecimal totalAmount;
    /** 支付总金额 */
    private BigDecimal paidAmount;
    /** 分销结算比例 */
    private BigDecimal commissionRatio;
    /** 结算手续费比例 */
    private BigDecimal poundageRatio;
    /** 下单时间 */
    private String createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPmsInnId() {
        return pmsInnId;
    }

    public void setPmsInnId(Integer pmsInnId) {
        this.pmsInnId = pmsInnId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getRoomTypeNum() {
        return roomTypeNum;
    }

    public void setRoomTypeNum(Integer roomTypeNum) {
        this.roomTypeNum = roomTypeNum;
    }

    public String getCheckInAt() {
        return checkInAt;
    }

    public void setCheckInAt(String checkInAt) {
        this.checkInAt = checkInAt;
    }

    public String getCheckOutAt() {
        return checkOutAt;
    }

    public void setCheckOutAt(String checkOutAt) {
        this.checkOutAt = checkOutAt;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getCommissionRatio() {
        return commissionRatio;
    }

    public void setCommissionRatio(BigDecimal commissionRatio) {
        this.commissionRatio = commissionRatio;
    }

    public BigDecimal getPoundageRatio() {
        return poundageRatio;
    }

    public void setPoundageRatio(BigDecimal poundageRatio) {
        this.poundageRatio = poundageRatio;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
