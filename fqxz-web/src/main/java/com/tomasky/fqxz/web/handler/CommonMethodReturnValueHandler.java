package com.tomasky.fqxz.web.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tomasky.fqxz.common.core.utils.web.Result;
import com.tomasky.fqxz.common.core.utils.web.URLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 统一方法处理器
 * 对Controller层
 * @author LZQ
 */
public class CommonMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

	private static final Logger log = LoggerFactory.getLogger(CommonMethodReturnValueHandler.class);

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		boolean flag = false;
		if(Result.class.isAssignableFrom(returnType.getParameterType())){
			flag = true;
		}
		return flag;
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest)
			throws Exception {
		if (returnValue != null) {
			if(returnValue instanceof Result){
				Result result = (Result) returnValue;
				HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
				response.setCharacterEncoding("UTF-8");
				HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
				String cmd = request.getServletPath();
				response.setContentType("application/json;charset=UTF-8");

				StringBuilder responseSb = new StringBuilder();

				if (URLUtils.isJsonp(request)) {
					String callback = webRequest.getParameter("callback");
					responseSb.append("(").append(callback).append(toJSONString(result)).append(")");
				} else {
					responseSb.append(toJSONString(result));
				}
				if (log.isInfoEnabled()) {
					long startTimeValue = (long) request.getAttribute("startTimeValue");
					long endTimeValue = System.currentTimeMillis();
					long time = endTimeValue-startTimeValue;
					log.info("[<--返回][url={}][totalTime={}ms][status={}][msg={}][data={}]",cmd,time,result.getStatus(),result.getMessage(),JSON.toJSONString(result.getData()));
				}
				response.getWriter().println(responseSb.toString());

				// 表明该请求已经处理，后面spring不会再处理
				mavContainer.setRequestHandled(true);
			}
		}
	}
	
	private String toJSONString(Result result) {
		return JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
	}
}
