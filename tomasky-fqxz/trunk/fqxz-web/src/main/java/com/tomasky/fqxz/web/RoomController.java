package com.tomasky.fqxz.web;

import com.tomasky.fqxz.service.IRoomService;
import com.tomasky.fqxz.service.XzBaseInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @ApiOperation(value = "查询付款方式", notes = "查询付款方式", httpMethod = "GET")
    @RequestMapping(value = "/inn/payType", method = RequestMethod.GET)
    public Map innPayType(@ApiParam(required = true, value = "客栈id") @RequestParam(name = "innId", value = "innId") Long innId) {
        logger.info("查询付款方式，参数：" + innId);
        return xzBaseInfoService.getInnPayType(innId);
    }


    @ApiOperation(value = "查询精选房型列表", notes = "查询精选房型列表", httpMethod = "GET")
    @RequestMapping(value = "/recommend/room", method = RequestMethod.GET)
    public Map recommendRoomList(@ApiParam(required = true, value = "客栈id") @RequestParam(name = "innId", value = "innId") Long innId) {
        logger.info("查询精选房型列表,参数:" + innId);
        return roomService.getRecommendRoomList(innId);
    }
}
