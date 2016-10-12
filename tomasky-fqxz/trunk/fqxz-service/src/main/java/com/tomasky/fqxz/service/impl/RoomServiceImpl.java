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
import com.tomasky.fqxz.service.handler.RoomServiceHandler;
import com.tomasky.fqxz.vo.*;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    RoomServiceHandler roomServiceHandler;

    @Override
    public Map getRecommendRoomList(Long innId) {
        Map result;
        try {
            Map check = CheckParamHandler.checkInnIdNotNull(innId);
            if (MapUtils.isNotEmpty(check)) {
                return check;
            }
            String roomTypeStr = roomServiceHandler.getRoomTypeStrFromOms(innId);
            GetRoomTypeData getRoomTypeData = JSON.parseObject(roomTypeStr, new TypeReference<GetRoomTypeData>() {
            });
            if (getRoomTypeData.getStatus().equals(Constants.HTTP_OK)) {
                result = ReturnHandler.success(roomServiceHandler.convertModel(getRoomTypeData.getList()));
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

}
