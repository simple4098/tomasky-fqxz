package com.tomasky.fqxz.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tomasky.fqxz.common.Constants;
import com.tomasky.fqxz.common.SysConfig;
import com.tomasky.fqxz.common.utils.HttpClientUtil;
import com.tomasky.fqxz.common.utils.ListUtil;
import com.tomasky.fqxz.common.utils.PassWordUtil;
import com.tomasky.fqxz.service.IRoomService;
import com.tomasky.fqxz.service.handler.CheckParamHandler;
import com.tomasky.fqxz.service.handler.ReturnHandler;
import com.tomasky.fqxz.vo.*;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 15:59
 * Version: 1.0
 * Description: 阐述
 */
@Service
public class RoomServiceImpl implements IRoomService {

    private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

    @Autowired
    SysConfig sysConfig;

    @Override
    public Map getRecommendRoomList(Long innId) {
        Map result;
        try {
            Map check = CheckParamHandler.checkInnIdNotNull(innId);
            if (MapUtils.isNotEmpty(check)) {
                return check;
            }
            String roomTypeStr = getRoomTypeStrFromOms();
            GetRoomTypeData getRoomTypeData = JSON.parseObject(roomTypeStr, new TypeReference<GetRoomTypeData>() {
            });
            if (getRoomTypeData.getStatus().equals(Constants.HTTP_OK)) {
                result = ReturnHandler.success(convertModel(getRoomTypeData.getList()));
            } else {
                String error = getRoomTypeData.getMessage();
                result = ReturnHandler.systomError(error);
            }
        } catch (Exception e) {
            logger.error("查询精选房型列表异常", e);
            result = ReturnHandler.systomError("查询精选房型列表异常");
        }
        return result;
    }

    /**
     * Create by jame
     * Date: 2016/10/11 17:48
     * Description: 通过innId调用oms查询房型接口getRoomType
     * params : [innId]
     * return : java.lang.String
     */
    private String getRoomTypeStrFromOms() {
        Long time = System.currentTimeMillis();
        String signature = 101 + "" + time + "XZ" + "xz123456";
        logger.info("生成key参数字符串:" + signature);
        signature = PassWordUtil.getMd5Pwd(signature);
        logger.info("生成的key字符串:" + signature);
        String requestUrl = sysConfig.getOmsRoomType() + "?accountId="
                + 3610 + "&otaId=" + 101 + "&signature=" + signature
                + "&timestamp=" + time + "&from=" + "2016-10-11" + "&to=" + "2016-10-11" + "&cached=false";
        logger.info("==================调用获取房态接口=============" + requestUrl);
        String result = HttpClientUtil.getResponseInfoByGet(requestUrl);
        logger.info("==================调用获取房态接口。返回值=============" + result);
        return result;
    }

    /**
     * Create by jame
     * Date: 2016/10/11 17:33
     * Description: 将oms返回的list对象转换成返回前端的vo对象
     * params : [list]
     * return : java.util.List<com.tomasky.fqxz.vo.RecommendRoomVo>
     */
    private List<RecommendRoomVo> convertModel(List<RoomTypeInfo> list) {
        List<RecommendRoomVo> result = new ArrayList<>();
        if (ListUtil.isNotEmpty(list)) {
            for (RoomTypeInfo roomTypeInfo : list) {
                RecommendRoomVo recommendRoomVo = new RecommendRoomVo();
                String facilities = "";
                List<FacilitiesVo> facilitiesVos = roomTypeInfo.getFacilitiesMap();
                if (ListUtil.isNotEmpty(facilitiesVos)) {
                    for (FacilitiesVo facilitiesVo : facilitiesVos) {
                        facilities += facilitiesVo.getName() + ",";
                    }
                }
                recommendRoomVo.setFacilities(facilities);

                Double price = 0d;
                List<RoomDetail> roomDetails = roomTypeInfo.getRoomDetail();
                if (ListUtil.isNotEmpty(roomDetails)) {
                    price = roomDetails.get(0).getRoomPrice();
                }
                recommendRoomVo.setPrice(price);
                recommendRoomVo.setName(roomTypeInfo.getRoomTypeName());
                recommendRoomVo.setRoomId(Long.valueOf(String.valueOf(roomTypeInfo.getRoomTypeId())));
                result.add(recommendRoomVo);
            }
        }
        return result;
    }
}
