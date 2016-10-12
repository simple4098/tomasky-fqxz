package com.tomasky.fqxz.web;

import com.tomasky.fqxz.service.IShopRecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 14:56
 * Version: 1.0
 * Description: 分店推荐controller
 */
@RestController
@RequestMapping("/shop/")
public class ShopRecommendController {

    private static final Logger logger = LoggerFactory.getLogger(ShopRecommendController.class);

    @Autowired
    IShopRecommendService shopRecommendService;

    @RequestMapping("/recommend")
    public Map shopRecommendList(Long innId) {
        logger.info("查询分店推荐，参数：" + innId);
        return shopRecommendService.getShopRecommendList(innId);
    }
}
