package com.tomasky.fqxz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author simple
 * @data 2016/10/10
 */
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //客栈id
    @Column(name = "innid")
    private Integer innId;
    //商品来源
    @Column(name = "prosource")
    private int proSource;
    //产品类型 0为产品 1为线路
    @Column(name ="protype" )
    private int proType;
    //产品名称
    @Column(name = "proname")
    private String proName;
    //产品封面
    @Column(name = "propic")
    private String proPic;
    //价格
    @Column(name = "price")
    private BigDecimal price;
    //产品简介
    @Column(name = "description")
    private String description;
    //产品内容
    @Column(name = "content")
    private String content;
    //库存
    @Column(name = "stock")
    private int stock;
    //销量
    @Column(name = "sales")
    private int sales;
    //返点
    @Column(name = "rebate")
    private BigDecimal rebate;
    @Column(name = "ratio")
    private BigDecimal ratio;
    //排序
    @Column(name = "sort")
    private int sort;
    //是否显示
    @Column(name = "isshow")
    private int isShow;
    //创建时间
    @Column(name = "createtime")
    private Date createTime;

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

    public int getProSource() {
        return proSource;
    }

    public void setProSource(int proSource) {
        this.proSource = proSource;
    }

    public int getProType() {
        return proType;
    }

    public void setProType(int proType) {
        this.proType = proType;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPic() {
        return proPic;
    }

    public void setProPic(String proPic) {
        this.proPic = proPic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
