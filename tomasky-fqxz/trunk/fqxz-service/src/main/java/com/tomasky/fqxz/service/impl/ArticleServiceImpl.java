package com.tomasky.fqxz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tomasky.fqxz.bo.param.ArticleDetailBo;
import com.tomasky.fqxz.bo.param.ArticleListBo;
import com.tomasky.fqxz.mapper.IArticleMapper;
import com.tomasky.fqxz.model.Article;
import com.tomasky.fqxz.service.IArticleService;
import com.tomasky.fqxz.service.handler.CheckParamHandler;
import com.tomasky.fqxz.service.handler.ReturnHandler;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 11:08
 * Version: 1.0
 * Description: 阐述
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    IArticleMapper articleMapper;

    @Override
    public Map getList(ArticleListBo articleListBo) {
        Map result;
        try {
            Map check = CheckParamHandler.checkInnIdNotNull(Long.valueOf(articleListBo.getInnId().toString()));
            if (MapUtils.isNotEmpty(check)) {
                return check;
            }
            PageHelper.startPage(articleListBo.getPageNo(), articleListBo.getPageSize());
            List<Article> list = articleMapper.getList(articleListBo);
            PageInfo pageInfo = new PageInfo(list);
            result = ReturnHandler.success(pageInfo);

        } catch (Exception e) {
            logger.error("查询文章攻略列表异常", e);
            result = ReturnHandler.systomError("查询文章攻略列表异常");
        }
        return result;
    }

    @Override
    public Map getDetail(ArticleDetailBo articleDetailBo) {
        Map result;
        try {
            Map checkArtcleId = CheckParamHandler.checkArticleIdNotNull(articleDetailBo.getArticleId());
            Map checkInnId = CheckParamHandler.checkInnIdNotNull(articleDetailBo.getInnId());
            if (MapUtils.isNotEmpty(checkArtcleId)) {
                return checkArtcleId;
            }
            if (MapUtils.isNotEmpty(checkInnId)) {
                return checkInnId;
            }
            Article article = articleMapper.getDetail(articleDetailBo);
            result = ReturnHandler.success(article);
        } catch (Exception e) {
            logger.error("查询文章攻略详细异常", e);
            result = ReturnHandler.systomError("查询文章攻略详细异常");
        }
        return result;
    }
}
