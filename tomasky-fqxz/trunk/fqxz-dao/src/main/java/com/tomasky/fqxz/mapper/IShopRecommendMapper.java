package com.tomasky.fqxz.mapper;

import com.tomasky.fqxz.model.ShopRecommend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by jame
 * Date: 2016/10/11 15:02
 * Version: 1.0
 * Description: 阐述
 */
@Mapper
public interface IShopRecommendMapper {

    List<ShopRecommend> selectByModel(ShopRecommend shopRecommend);
}
