package com.tomasky.fqxz.service;

import com.tomasky.fqxz.bo.param.ArticleDetailBo;
import com.tomasky.fqxz.bo.param.ArticleListBo;

import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 11:03
 * Version: 1.0
 * Description: 阐述
 */
public interface IArticleService {

    Map getList(ArticleListBo articleListBo);

    Map getDetail(ArticleDetailBo articleDetailBo);
}
