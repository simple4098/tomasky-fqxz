package com.tomasky.fqxz.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author simple
 * @data 2016/10/10
 */
@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //客栈id
    @Column(name = "innid")
    private Integer innId;
    //联系人
    private String contacts;
    //联系电话
    private String phone;
    //备注
    private String remark;
    //订单号
    @Column(name = "order_no")
    private String orderNo;
    //支付订单号
    @Column(name = "pay_orderno")
    private String payOrderNo;
    //0 未支付 1已经支付
    @Column(name = "is_pay")
    private String isPay;
    //0为失效 1为生效
    @Column(name = "is_failed")
    private String isFailed;
    //支付时间
    @Column(name = "paytime")
    private Date payTime;
    //创建时间
    @Column(name = "createtime")
    private Date createTime;
    //失效时间
    @Column(name = "outtime")
    private Date outTime;

    public ProductOrder() {
    }

    public ProductOrder(Integer innId, String contacts, String phone, String remark) {
        this.innId = innId;
        this.contacts = contacts;
        this.phone = phone;
        this.remark = remark;
    }

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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayOrderNo() {
        return payOrderNo;
    }

    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public String getIsFailed() {
        return isFailed;
    }

    public void setIsFailed(String isFailed) {
        this.isFailed = isFailed;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
}
