package com.tomasky.fqxz.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tomasky.fqxz.common.utils.ConfigUtil;
import com.tomasky.fqxz.common.utils.HttpClientUtil;
import com.tomasky.fqxz.vo.PmsInnInfo;

/**
 * 获取pms客栈基本信息
 * @author simple
 * @data 2016/10/11
 */
public class InnHelper {


    public static PmsInnInfo obtInnInfo(Integer innId)throws Exception{
        String pmsInnUrl = ConfigUtil.obtPmsInnUrl("pms.host");
        String innStr = HttpClientUtil.getResponseInfoByGet(pmsInnUrl.concat(innId.toString()));
        JSONObject jsonObject = JSON.parseObject(innStr);
        String result = jsonObject.getString("result");
        PmsInnInfo pmsInnInfo = JSON.parseObject(result, PmsInnInfo.class);
        return pmsInnInfo;
    }

}
