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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @ApiOperation(value = "查询文章攻略列表", notes = "查询文章攻略列表", httpMethod = "GET")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map getList(@ApiParam(value = "客栈id",required = true) @RequestParam(value = "innId", name = "innId",required = true) Integer innId,
                       @ApiParam(value = "页码",required = true) @RequestParam(value = "pageNo", name = "pageNo",required = true) Integer pageNo,
                       @ApiParam(value = "条数",required = true) @RequestParam(value = "pageSize", name = "pageSize",required = true) Integer pageSize) {
        ArticleListBo articleListBo=new ArticleListBo();
        articleListBo.setInnId(innId);
        articleListBo.setPageNo(pageNo);
        articleListBo.setPageSize(pageSize);
        logger.info("查询文章攻略列表，参数" + JSON.toJSONString(articleListBo));
        return articleService.getList(articleListBo);
    }


    @ApiOperation(value = "查询文章攻略详细", notes = "查询文章攻略详细", httpMethod = "GET")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Map getDetail(@ApiParam(value = "客栈id",required = true) @RequestParam(value = "innId", name = "innId",required = true) Long innId,
                         @ApiParam(value = "文章id",required = true) @RequestParam(value = "articleId", name = "articleId",required = true) Long articleId) {
        ArticleDetailBo param=new ArticleDetailBo();
        param.setArticleId(articleId);
        param.setInnId(innId);
        logger.info("查询文章攻略详细，参数" + JSON.toJSONString(param));
        return articleService.getDetail(param);
    }
}
