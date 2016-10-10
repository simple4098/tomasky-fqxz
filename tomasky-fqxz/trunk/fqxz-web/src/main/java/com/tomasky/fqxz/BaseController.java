package com.tomasky.fqxz;

import com.google.common.collect.Maps;
import com.tomasky.cache.api.Cache;
import com.tomasky.fqxz.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author X
 */
@RestController
public class BaseController {

    private final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private Cache cache;

    @RequestMapping("/")
    String home() {
        LOGGER.debug(String.valueOf(cache.put("test-fqxz", "momo", 10000)));
        LOGGER.debug(String.valueOf(cache.get("test-fqxz")));
        return "hello world!";
    }

    public Map<String, Object> new200() {
        return newResult(Constants.HTTP_OK, null, null);
    }

    public Map<String, Object> new200(Object value) {
        return newResult(Constants.HTTP_OK, Constants.RESULT, value);
    }

    public Map<String, Object> new400(Object errorValue) {
        return newResult(Constants.HTTP_400, Constants.MESSAGE, errorValue);
    }

    public Map<String, Object> new400(String errorKey, Object errorValue) {
        return newResult(Constants.HTTP_400, errorKey, errorValue);
    }

    public Map<String, Object> new500(Object errorValue) {
        return newResult(Constants.HTTP_500, Constants.MESSAGE, errorValue);
    }

    public Map<String, Object> new500(String errorKey, Object errorValue) {
        return newResult(Constants.HTTP_500, errorKey, errorValue);
    }

    public Map<String, Object> newResult(int statusValue, String key, Object value) {
        Map<String, Object> result = Maps.newHashMap();
        if (StringUtils.isNotBlank(key) && null != value) {
            result.put(key, value);
        }
        result.put(Constants.STATUS, statusValue);
        return result;
    }

}