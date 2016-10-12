package com.tomasky.fqxz.web;

import com.alibaba.fastjson.JSON;
import com.tomasky.fqxz.bo.param.ArticleDetailBo;
import com.tomasky.fqxz.bo.param.ArticleListBo;
import com.tomasky.fqxz.service.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 11:02
 * Version: 1.0
 * Description: 文章攻略controller
 */
@RestController
@RequestMapping("/article/")
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    IArticleService articleService;

    @RequestMapping("/list")
    public Map getList(ArticleListBo param) {
        logger.info("查询文章攻略列表，参数" + JSON.toJSONString(param));
        return articleService.getList(param);
    }


    @RequestMapping("/detail")
    public Map getDetail(ArticleDetailBo param) {
        logger.info("查询文章攻略详细，参数" +  JSON.toJSONString(param));
        return articleService.getDetail(param);
    }
}
