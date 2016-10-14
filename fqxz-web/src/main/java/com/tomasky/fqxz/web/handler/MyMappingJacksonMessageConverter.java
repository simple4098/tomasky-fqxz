package com.tomasky.fqxz.web.handler;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by LZQ on 2016/10/13.
 */
public class MyMappingJacksonMessageConverter extends MappingJackson2HttpMessageConverter{
    private Logger log  = LoggerFactory.getLogger(MyMappingJacksonMessageConverter.class);
    @Override
    protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
        super.writePrefix(generator, object);
    }

    @Override
    protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        long startTimeValue = (long) request.getAttribute("startTimeValue");
        long endTimeValue = System.currentTimeMillis();
        long time = endTimeValue-startTimeValue;
        log.info("[<--返回][url={}][totalTime={}ms][[data={}]",request.getServletPath(),time,JSON.toJSONString(object));
        super.writeSuffix(generator, object);
    }
}
