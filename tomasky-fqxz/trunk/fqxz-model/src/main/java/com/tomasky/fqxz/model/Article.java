package com.tomasky.fqxz.model;

import com.tomasky.fqxz.common.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Create by jame
 * Date: 2016/10/11 11:13
 * Version: 1.0
 * Description: 阐述
 */
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long innid; //小站id
    private String title; //文章标题
    private String keyword; //关键词
    private String coverpict; //封面图片
    private String description; //文章描述
    private String content; //文章内容

    @Column(name = "createtime")
    private Date createTime;     //创建时间
    private Integer category;    //文章分类 0为攻略 1为小站故事
    @Column(name = "isshow")
    private Integer isShow;    //是否显示 0为隐藏 1为显示
    private Integer sort;    //排序


    public Article() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInnid() {
        return innid;
    }

    public void setInnid(Long innid) {
        this.innid = innid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCoverpict() {
        return coverpict;
    }

    public void setCoverpict(String coverpict) {
        this.coverpict = coverpict;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
