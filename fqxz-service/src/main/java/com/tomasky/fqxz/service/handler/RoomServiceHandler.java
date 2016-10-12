package com.tomasky.fqxz.service.handler;

import com.tomasky.fqxz.common.SysConfig;
import com.tomasky.fqxz.common.enums.EnumOta;
import com.tomasky.fqxz.common.utils.DateUtil;
import com.tomasky.fqxz.common.utils.HttpClientUtil;
import com.tomasky.fqxz.common.utils.ListUtil;
import com.tomasky.fqxz.common.utils.PassWordUtil;
import com.tomasky.fqxz.mapper.XzBaseInfoMapper;
import com.tomasky.fqxz.model.XzBaseinfo;
import com.tomasky.fqxz.vo.FacilitiesVo;
import com.tomasky.fqxz.vo.RecommendRoomVo;
import com.tomasky.fqxz.vo.RoomDetail;
import com.tomasky.fqxz.vo.RoomTypeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by jame
 * Date: 2016/10/12 9:35
 * Version: 1.0
 * Description: 阐述
 */
@Component
public class RoomServiceHandler {

    private static final Logger logger = LoggerFactory.getLogger(RoomServiceHandler.class);

    @Autowired
    SysConfig sysConfig;

    @Autowired
    XzBaseInfoMapper xzBaseInfoMapper;

    /**
     * Create by jame
     * Date: 2016/10/11 17:48
     * Description: 通过innId调用oms查询房型接口getRoomType
     * params : [innId]
     * return : java.lang.String
     */
    public String getRoomTypeStrFromOms(Long innId) {
        XzBaseinfo xzBaseinfo = xzBaseInfoMapper.getInnPayTypeAndKnowsAndAccount(innId);
        Long time = System.currentTimeMillis();
        String signature = EnumOta.xz.getValue() + "" + time + sysConfig.getXzUserCode() + sysConfig.getXzUserPwd();
        logger.info("生成key参数字符串:" + signature);
        signature = PassWordUtil.getMd5Pwd(signature);
        logger.info("生成的key字符串:" + signature);
        String requestUrl = sysConfig.getOmsRoomType() + "?accountId="
                + xzBaseinfo.getAccountid() + "&otaId=" + EnumOta.xz.getValue() + "&signature=" + signature
                + "&timestamp=" + time + "&from=" + DateUtil.getCurrenDate() + "&to=" + DateUtil.getCurrenDate() + "&cached=false";
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
    public List<RecommendRoomVo> convertModel(List<RoomTypeInfo> list) {
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
