package com.tomasky.fqxz;

import com.tomasky.fqxz.web.filter.LogRecordInterceptor;
import com.tomasky.fqxz.web.handler.CommonExceptionHandler;
import com.tomasky.fqxz.web.handler.CommonMethodReturnValueHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
}
