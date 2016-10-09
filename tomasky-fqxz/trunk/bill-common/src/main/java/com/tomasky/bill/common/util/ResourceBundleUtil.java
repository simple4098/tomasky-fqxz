package com.tomasky.bill.common.util;

import com.tomasky.bill.common.cons.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * 获取资源文件
 *
 * @author mowei
 */
public class ResourceBundleUtil {

    protected static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    protected static ResourceBundle bundle = ResourceBundle.getBundle("config");

    public static String getSpringProfilesActive() {
        String path = System.getProperty("spring.profiles.active");
        if (StringUtils.isEmpty(path)) {
            path = Constants.ENVIRONMENT_TEST;
        }
        return path;
    }

    public static int getInt(String key) {
        return Integer.parseInt(getString(key));
    }

    public static String getString(String key) {
        try {
            return bundle.getString(key);
        } catch (Exception e) {
            logger.error("获取config资源文件指定key：" + key + "的值出错", e);
        }
        return null;
    }

    public static int getInt(String key, String resource) {
        return Integer.parseInt(getString(key, resource));
    }

    public static String getString(String key, String resource) {
        ResourceBundle bundle = ResourceBundle.getBundle(resource);
        try {
            return bundle.getString(key);
        } catch (Exception e) {
            logger.error("获取" + resource + "资源文件指定key：" + key + "的值出错", e);
        }
        return null;
    }

    /**
     * @param key    需要获得的key值
     * @param params
     * @return
     */
    public static String getString(String key, Object... params) {
        return getString(bundle, key, params);

    }

    /**
     * @param key      需要获得的key值
     * @param resource 资源文件
     * @param params
     * @return
     */
    public static String getString(String key, String resource, Object... params) {
        ResourceBundle bundle = ResourceBundle.getBundle(resource);
        return getString(bundle, key, params);
    }

    /**
     * @param bundle 指定资源文件对象
     * @param key    需要获得的key值
     * @param params
     * @return
     */
    private static String getString(ResourceBundle bundle, String key, Object... params) {
        try {
            String value = bundle.getString(key);
            MessageFormat form = new MessageFormat(value);
            return form.format(value, params);
        } catch (Exception e) {
            logger.error("获取资源文件指定key：" + key + "的值出错", e);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(ResourceBundleUtil.getString("test"));
    }

}
