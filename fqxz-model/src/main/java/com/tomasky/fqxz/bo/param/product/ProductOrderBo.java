package com.tomasky.fqxz.bo.param.product;

import com.tomasky.fqxz.bo.param.CommParam;
import com.tomasky.fqxz.model.Product;
import com.tomasky.fqxz.model.ProductOrder;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * @author simple
 * 查询商品、以及商品下单
 * @data 2016/10/11
 */
public class ProductOrderBo extends ProductOrder{
    private Integer num;
    private BigDecimal price;
    private String proName;
    private BigDecimal totalPrice;
    private Long productId;

    public ProductOrderBo(Integer innId, String contacts, String phone, String remark, Integer num, BigDecimal price, String proName, BigDecimal totalPrice, Long productId) {
        super(innId, contacts, phone, remark);
        this.num = num;
        this.price = price;
        this.proName = proName;
        this.totalPrice = totalPrice;
        this.productId = productId;
    }

    public ProductOrderBo() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProName() {
        return proName;
    }
    public void setProName(String proName) {
        this.proName = proName;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void assertNotNull(){
        Assert.notNull(this);
        Assert.notNull(getContacts());
        Assert.notNull(getNum());
        Assert.notNull(getProductId());
        Assert.notNull(getProName());
        Assert.notNull(getPrice());
        Assert.notNull(getTotalPrice());
        Assert.notNull(getInnId());
        Assert.notNull(getPhone());
    }
}
