package com.tomasky.fqxz.web.handler;

import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.fastjson.JSON;
import com.tomasky.fqxz.common.core.utils.web.Result;
import com.tomasky.fqxz.common.core.utils.web.URLUtils;
import com.tomasky.fqxz.common.em.ResultCode;
import com.tomasky.fqxz.common.exception.BusinessException;
import com.tomasky.fqxz.common.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常
 * 公用异常处理记录及返回
 * @author LZQ
 */
public class CommonExceptionHandler implements HandlerExceptionResolver {
	/**
	 * 日志
	 */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	//private static final String ERROR_VIEW = "error";

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		response.setContentType("application/json;charset=UTF-8");
		Result result = null;
		if (BusinessException.class.isAssignableFrom(ex.getClass())) {
			// 业务异常
			BusinessException bex = (BusinessException) ex;
			result = new Result(ResultCode.COMMEN_BUSINESS_EXCEPTION, false);
			result.setMessage(bex.getMsg());
			//当有返回Code值时候
			if (bex.getStatus() != null) {
				result.setStatus(bex.getStatus());
			}
			log.info("CommonExceptionHandler catche the BusinessException : ", bex.getMsg());
		}else if (RpcException.class.isAssignableFrom(ex.getClass())) {
			// dubbo远程调用异常
			result = new Result(ResultCode.COMMON_SYSTEM_RPC_EXCEPTION, false);
			log.error("CommonExceptionHandler catche the RPCException, ", ex);
		} else if(SystemException.class.isAssignableFrom(ex.getClass())){
			// 系统错误
			result = new Result(ResultCode.COMMEN_SYSTEM_EXCEPTION, false);
			log.error("CommonExceptionHandler catche the System Error, ", ex);
		}else {
			// 其他系统错误
			result = new Result(ResultCode.OTHER_EXCEPTION, false);
			log.error("CommonExceptionHandler catche the Other Error, ", ex);
		}

		String requestHeader = request.getHeader("Accept");
		response.setCharacterEncoding("UTF-8");
		boolean isAjaxUrl = request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString());
		if (requestHeader == null || isAjaxUrl) {
			// 返回json格式的数据
			returnRes(request, response, result);
			return new ModelAndView();
		} else {
			//非ajax请求 赞当ajax请求处理
			//response.setContentType("text/html;charset=UTF-8");
			returnRes(request, response, result);
			return new ModelAndView();
		}
	}

	private String toJSONString(Result result) {
		return JSON.toJSONString(result);
	}

	private void returnRes(HttpServletRequest request, HttpServletResponse response, Result result) {
		try {
			StringBuffer responseSb = new StringBuffer();
			log.info("[<--返回][url=" + request.getServletPath() + "][status=" + result.getStatus() + "][msg=" + result.getMessage() + "][data=:" + JSON.toJSONString(result.getData()) + "]");
			if (URLUtils.isJsonp(request)) {
				String callback = request.getParameter("callback");
				responseSb.append("(").append(callback).append(toJSONString(result)).append(")");
			} else {
				responseSb.append(toJSONString(result));
			}

			response.getWriter().println(responseSb.toString());
		} catch (Exception e) {
			log.error("Response write exception", e);
		}
	}

}
