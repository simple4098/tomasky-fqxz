package com.tomasky.bill.common.core.filter;

import com.google.common.collect.Lists;
import com.tomasky.bill.common.cons.Constants;
import com.tomasky.bill.common.util.security.SpringSecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SecurityFilter implements Filter {
	
	protected Logger logger = LoggerFactory.getLogger(SecurityFilter.class);
	
	private String loginUri;
	private List<String> noFiltUris;

	@Override
	public void init(FilterConfig config) throws ServletException {
		try {
			noFiltUris = Lists.newArrayList();
			loginUri = config.getInitParameter("auth_url");
			noFiltUris.add(loginUri);
			noFiltUris.add(config.getInitParameter("paid_callback_url"));
			noFiltUris.add(config.getInitParameter("super_cancel_url"));
			noFiltUris.add(config.getInitParameter("code_url"));
			noFiltUris.add(config.getInitParameter("order_url"));
			noFiltUris.add(config.getInitParameter("login_url"));
		} catch (Exception e) {
			logger.info("拦截器初始化参数出错!"+e.getMessage());
		}
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
						 FilterChain filter) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        request.setCharacterEncoding("UTF-8");
        //需要过滤的代码         
        String consumerId = request.getParameter("consumerId");
        String token = request.getParameter("token");
        String origin = request.getParameter("loginOrigin");
        request.getServerName();
        request.getContextPath();
        if(noFiltUris.contains(request.getRequestURI())){
        	filter.doFilter(servletRequest, servletResponse); 
        	return;
        }
        
        if(SpringSecurityUtil.verifyToken(token, consumerId, origin)){
        	filter.doFilter(servletRequest, servletResponse); 
        	return;
        }
        
        if(request.getRequestURI().equals(Constants.DEFAULT_WRONG_URI)){
        	filter.doFilter(servletRequest, servletResponse); 
        	return;
        }else{
//        	response.sendRedirect(Constants.DEFAULT_WRONG_URI);
        	request.getRequestDispatcher(Constants.DEFAULT_WRONG_URI).forward(request, response);
        }
	}

	@Override
	public void destroy() {
	}

}
