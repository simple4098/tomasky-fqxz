package com.tomasky.fqxz;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonGenerator;
import com.tomasky.fqxz.web.filter.LogRecordInterceptor;
import com.tomasky.fqxz.web.handler.CommonExceptionHandler;
import com.tomasky.fqxz.web.handler.CommonMethodReturnValueHandler;
import com.tomasky.fqxz.web.handler.MyMappingJacksonMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.util.List;

/**
 * spring初始化入口
 * Created by LZQ on 2016/10/12.
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogRecordInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        CommonMethodReturnValueHandler handler = new CommonMethodReturnValueHandler();
        returnValueHandlers.add(handler);
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        CommonExceptionHandler commonExceptionHandler = new  CommonExceptionHandler();
        exceptionResolvers.add(commonExceptionHandler);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MyMappingJacksonMessageConverter myMappingJacksonMessageConverter = new MyMappingJacksonMessageConverter();
        converters.add(myMappingJacksonMessageConverter);
    }
}
