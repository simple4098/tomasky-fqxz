package com.tomasky.fqxz.web;

import com.alibaba.fastjson.JSON;
import com.tomasky.fqxz.bo.param.ArticleDetailBo;
import com.tomasky.fqxz.bo.param.ArticleListBo;
import com.tomasky.fqxz.service.IArticleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "查询文章攻略列表", notes = "查询文章攻略列表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "param", value = "接收参数实体ArticleListBo", required = true, dataType = "ArticleListBo")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Map getList(
            @RequestBody  ArticleListBo param) {
        logger.info("查询文章攻略列表，参数" + JSON.toJSONString(param));
        return articleService.getList(param);
    }


    @ApiOperation(value = "查询文章攻略详细", notes = "查询文章攻略详细", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "param", value = "接收参数实体ArticleDetailBo", required = true, dataType = "ArticleDetailBo")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Map getDetail(@RequestBody  ArticleDetailBo param) {
        logger.info("查询文章攻略详细，参数" + JSON.toJSONString(param));
        return articleService.getDetail(param);
    }
}
