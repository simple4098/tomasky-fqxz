package com.tomasky.bill.common.util;

import com.tomasky.bill.common.cons.Constants;
import com.tomasky.bill.common.core.utils.spring.SpringContextHolder;
import com.tomasky.cache.api.Cache;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;


public class CacheUtil {

    protected static Logger logger = LoggerFactory.getLogger(CacheUtil.class);

    /**
     * 置入缓存 expire (单位：秒)
     *
     * @param key
     * @param obj
     * @param expire
     * @return
     */
    public static boolean set(String key, int expire, Serializable obj) {
        boolean result = false;
        if (VerifyUtil.isNotEmpty(obj)) {
            try {
                Cache redisCache = SpringContextHolder.getBean("redisCache");
                if (null != redisCache) {
                    result = redisCache.put(Constants.CACHE_SYS_TAG + key, obj, expire);
                }
            } catch (Exception e) {
                logger.error("缓存 " + key + " 对象出错：" + ToStringBuilder.reflectionToString(obj), e);
            }
        }
        return result;
    }

    /**
     * 根据KEY 清空缓存
     * @param key
     * @return
     */
    public static boolean del(String key) {
        boolean result = false;
        if(StringUtils.isBlank(key)){
            return result;
        }
        try {
            Cache redisCache = SpringContextHolder.getBean("redisCache");
            if (null != redisCache) {
                result = redisCache.del(Constants.CACHE_SYS_TAG + key);
            }
        } catch (Exception e) {
            logger.error("清空缓存 " + key + " 对象出错：", e);
        }
        return result;
    }

    /**
     * 置入缓存,默认有效时间为7天
     *
     * @param key
     * @param obj
     * @return
     */
    public static boolean set(String key, Serializable obj) {
        return set(key, Constants.CACHE_MAX_AGE, obj);
    }

    @SuppressWarnings("unchecked")
    public static String get(String key) {
        if (VerifyUtil.isEmpty(key)) {
            return null;
        }
        try {
            Cache redisCache = SpringContextHolder.getBean("redisCache");
            if (null != redisCache) {
                String obj = (String) redisCache.get(Constants.CACHE_SYS_TAG + key);
                if (null != obj) {
                    return obj;
                }
            }
        } catch (Exception e) {
            logger.error("获取缓存对象出错:" + key + "", e);
        }
        return null;
    }

}
