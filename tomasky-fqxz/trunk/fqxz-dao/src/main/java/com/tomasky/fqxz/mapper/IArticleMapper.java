package com.tomasky.fqxz.mapper;

import com.tomasky.fqxz.bo.param.ArticleDetailBo;
import com.tomasky.fqxz.bo.param.ArticleListBo;
import com.tomasky.fqxz.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 11:08
 * Version: 1.0
 * Description: 阐述
 */

@Mapper
public interface IArticleMapper {

    List<Article> getList(ArticleListBo articleListBo);

    Integer getListCount(ArticleListBo articleListBo);

    Article getDetail(ArticleDetailBo articleDetailBo);
}
