package com.tomasky.fqxz.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
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
    private  String omsRoomType;

    @Value("${oms.img.host}")
    private  String imgHost;

    @Value("${pms.interface.innUrl}")
    private  String pmsInnUrl;

    @Value("${xz.user.code}")
    private String xzUserCode;

    @Value("${xz.user.pwd}")
    private String xzUserPwd;

    @Value("${xz.order.orderCallbackUrl}")
    private String orderCallbackUrl;


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

    public String getImgHost() {
        return imgHost;
    }

    public void setImgHost(String imgHost) {
        this.imgHost = imgHost;
    }

    public String getPmsInnUrl() {
        return pmsInnUrl;
    }

    public void setPmsInnUrl(String pmsInnUrl) {
        this.pmsInnUrl = pmsInnUrl;
    }

    public String getOrderCallbackUrl() {
        return orderCallbackUrl;
    }

    public void setOrderCallbackUrl(String orderCallbackUrl) {
        this.orderCallbackUrl = orderCallbackUrl;
    }
}
