package com.tomasky.fqxz.model;

import javax.persistence.*;

/**
 * Create by jame
 * Date: 2016/10/11 9:25
 * Version: 1.0
 * Description: 阐述
 */
@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "innid")
    private Long innId;
    private String name;
    private String alias;
    @Column(name = "isshow")
    private String isShow;
    private String tip;
    private Integer sort;

    public Module() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getInnId() {
        return innId;
    }

    public void setInnId(Long innId) {
        this.innId = innId;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
