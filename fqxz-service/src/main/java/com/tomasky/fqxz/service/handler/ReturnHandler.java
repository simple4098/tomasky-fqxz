package com.tomasky.fqxz.service.handler;

import com.tomasky.fqxz.common.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by jame
 * Date: 2016/10/11 9:57
 * Version: 1.0
 * Description: service 层 return handler
 */
public class ReturnHandler {

    public static Map success() {
        Map result = new HashMap<>();
        result.put(Constants.MSG, "");
        result.put(Constants.STATUS, Constants.HTTP_OK);
        return result;
    }

    public static Map success(Object obj) {
        Map result = new HashMap<>();
        result.put(Constants.MSG, "");
        result.put(Constants.STATUS, Constants.HTTP_OK);
        result.put("data", obj);
        return result;
    }

    public static Map systomError(String msg) {
        Map result = new HashMap<>();
        result.put(Constants.MSG, msg);
        result.put(Constants.STATUS, Constants.HTTP_500);
        return result;
    }


    public static Map paramError(String msg) {
        Map result = new HashMap<>();
        result.put(Constants.MSG, msg);
        result.put(Constants.STATUS, Constants.HTTP_400);
        return result;
    }

}
