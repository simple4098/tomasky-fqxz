package com.tomasky.fqxz.vo;

import java.math.BigDecimal;

/**
 * <p>支付回调 返回数据</p>
 * @author simple
 * @data 2016/10/12
 */
public class PayResultVo {
    //订单id
    private Integer xzOrderId;
    //支付状态
    private String payStatus;
    //订单号
    private String orderNo;
    //商品名称
    private String proName;
    //联系电话
    private String phone;
    //数量
    private int num;
    //总价
    private BigDecimal totalPrice;
    //联系人
    private String contacts;
    //客栈名称
    private String innName;
    //商品id
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getXzOrderId() {
        return xzOrderId;
    }

    public void setXzOrderId(Integer xzOrderId) {
        this.xzOrderId = xzOrderId;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getInnName() {
        return innName;
    }

    public void setInnName(String innName) {
        this.innName = innName;
    }
}
