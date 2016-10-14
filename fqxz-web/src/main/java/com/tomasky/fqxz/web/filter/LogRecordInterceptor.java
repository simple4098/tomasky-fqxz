package com.tomasky.fqxz.web.filter;

/**
 * 请求日志记录拦截器
 * Created by LZQ on 2016/10/12.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 日志拦截器，记录请求参数
 */
public class LogRecordInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LogRecordInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//response.setHeader("Access-Control-Allow-Origin", "*");
		long startTimeValue = System.currentTimeMillis();
		request.setAttribute("startTimeValue",startTimeValue);
		try {
			if(logger.isInfoEnabled()) {
				request.getParameterMap();
				Map map = request.getParameterMap();
				Set keSet = map.entrySet();
				StringBuffer logOut = new StringBuffer("[--> 请求]["+request.getMethod()+" URL:" + request.getServletPath() + " ] [参数]:|");
				for (Iterator itr = keSet.iterator(); itr.hasNext(); ) {
					Map.Entry me = (Map.Entry) itr.next();
					Object ok = me.getKey();
					Object ov = me.getValue();
					String[] value = new String[1];
					if (ov instanceof String[]) {
						value = (String[]) ov;
					} else {
						value[0] = ov.toString();
					}

					for (int k = 0; k < value.length; k++) {
						logOut.append(ok + "=" + value[k] + "|");
					}
				}
				logger.info(logOut.toString());
			}
		} catch (Exception e) {
			logger.error("[请求出错]", e);
		}
		return true;
	}

}