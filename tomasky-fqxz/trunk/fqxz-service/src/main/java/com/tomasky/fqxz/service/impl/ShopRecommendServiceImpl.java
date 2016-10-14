package com.tomasky.fqxz.service.impl;

import com.tomasky.fqxz.mapper.IShopRecommendMapper;
import com.tomasky.fqxz.model.ShopRecommend;
import com.tomasky.fqxz.service.IShopRecommendService;
import com.tomasky.fqxz.service.handler.CheckParamHandler;
import com.tomasky.fqxz.service.handler.ReturnHandler;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 15:07
 * Version: 1.0
 * Description: 阐述
 */
@Service
public class ShopRecommendServiceImpl implements IShopRecommendService {

    private static final Logger logger = LoggerFactory.getLogger(ShopRecommendServiceImpl.class);

    @Autowired
    IShopRecommendMapper shopRecommendMapper;

    @Autowired


    @Override
    public Map getShopRecommendList(Long innId) {
        ShopRecommend shopRecommend = new ShopRecommend();
        Map check=CheckParamHandler.checkInnIdNotNull(innId);
        if(MapUtils.isNotEmpty(check)){
            return check;
        }
        shopRecommend.setInnId(innId);
        List<ShopRecommend> list = shopRecommendMapper.selectByModel(shopRecommend);
        return ReturnHandler.success(list);
    }
}
