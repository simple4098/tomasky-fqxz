package com.tomasky.fqxz.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Create by jame
 * Date: 2016/10/12 9:26
 * Version: 1.0
 * Description: 系统接口调度变量初始化
 */
@Component
public class SysConfig {

    @Value("${oms.interface.getroomtype}")
    private String omsRoomType;

    @Value("${xz.user.code}")
    private String xzUserCode;

    @Value("${xz.user.pwd}")
    private String xzUserPwd;


    public String getXzUserCode() {
        return xzUserCode;
    }

    public void setXzUserCode(String xzUserCode) {
        this.xzUserCode = xzUserCode;
    }

    public String getXzUserPwd() {
        return xzUserPwd;
    }

    public void setXzUserPwd(String xzUserPwd) {
        this.xzUserPwd = xzUserPwd;
    }

    public String getOmsRoomType() {
        return omsRoomType;
    }

    public void setOmsRoomType(String omsRoomType) {
        this.omsRoomType = omsRoomType;
    }
}
