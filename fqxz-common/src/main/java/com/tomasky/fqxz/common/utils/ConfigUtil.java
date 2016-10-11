package com.tomasky.fqxz.common.utils;

/**
 * @author simple
 * @data 2016/10/11
 */
public class ConfigUtil {

    private ConfigUtil(){

    }
    public static String obtHost(String key){
        String property = System.getProperty("spring.profiles.active");
        StringBuilder stringBuilder = new StringBuilder(key);
        stringBuilder.append(".").append(property);
        return ResourceBundleUtil.getString(stringBuilder.toString());
    }

    public static String obtPmsInnUrl(String key){
        String host = obtHost(key);
        return host.concat("api/baseInfo/");
    }
}
