package com.tomasky.fqxz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author simple
 * @data 2016/10/11
 */
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //订单id
    private Long oid;
    //商品id
    private Long proId;
    //单价
    private BigDecimal price;
    //数量
    private Integer num;
    //总价
    private BigDecimal totalPrice;
    //商品名称
    private String proName;

    public OrderDetail() {
    }

    public OrderDetail(Long oid, Long proId, BigDecimal price, Integer num, BigDecimal totalPrice, String proName) {
        this.oid = oid;
        this.proId = proId;
        this.price = price;
        this.num = num;
        this.totalPrice = totalPrice;
        this.proName = proName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
}
