package com.tomasky.fqxz.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author simple
 * @data 2016/10/10
 *
 */
@Configuration
public class MessageConfiguration {

    @Resource
    private MessageSource messageSource;

    @Bean
    MessageSourceAccessor messageSourceAccessor() {
        return new MessageSourceAccessor(messageSource, Locale.CHINESE);
    }
}
