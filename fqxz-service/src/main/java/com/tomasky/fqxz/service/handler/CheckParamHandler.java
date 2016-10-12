package com.tomasky.fqxz.service.handler;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 11:30
 * Version: 1.0
 * Description: 阐述
 */
public class CheckParamHandler {


    public static Map checkInnIdNotNull(Long innId) {
        Map map = new HashMap<>();
        if (innId == null || innId <= 0l) {
            return ReturnHandler.paramError("传入innId参数错误,innId:" + innId);
        }
        return map;
    }

    public static Map checkArticleIdNotNull(Long articleId) {
        Map map = new HashMap<>();
        if (articleId == null || articleId <= 0l) {
            return ReturnHandler.paramError("传入articleId参数错误,articleId:" + articleId);
        }
        return map;
    }
}
