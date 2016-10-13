package com.tomasky.fqxz.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by jame
 * Date: 2016/10/12 10:34
 * Version: 1.0
 * Description: swagger拦截器，拦截正式的swagger请求
 */
@WebFilter(filterName = "swaggerFileter", urlPatterns = "/*")
public class SwaggerFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(SwaggerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("SwaggerFilter过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        String sys = System.getProperty("spring.profiles.active");
        String uri = request.getRequestURI();
        if (sys.contains("pro") && uri.contains("swagger")) {
            servletResponse.setContentType("application/json;charset=UTF-8");
            servletResponse.getWriter().print("连接已失效");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
    }

    @Override
    public void destroy() {
        logger.info("SwaggerFilter过滤器销毁");
    }
}
