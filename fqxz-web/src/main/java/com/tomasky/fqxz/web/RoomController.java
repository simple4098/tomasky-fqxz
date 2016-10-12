package com.tomasky.fqxz.web;

import com.tomasky.fqxz.service.IRoomService;
import com.tomasky.fqxz.service.XzBaseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 15:30
 * Version: 1.0
 * Description: 房型相关controller
 */
@RestController
@RequestMapping("/")
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    XzBaseInfoService xzBaseInfoService;

    @Autowired
    IRoomService roomService;

    @RequestMapping("/inn/payType")
    public Map innPayType(Long innId) {
        logger.info("查询付款方式，参数：" + innId);
        return xzBaseInfoService.getInnPayType(innId);
    }


    @RequestMapping("/recommend/room")
    public Map recommendRoomList(Long innId) {
        return roomService.getRecommendRoomList(innId);
    }
}
