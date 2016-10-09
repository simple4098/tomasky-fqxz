package com.tomasky.bill.common.util.security;

import com.tomasky.bill.common.cons.Constants;
import com.tomasky.bill.common.util.CacheUtil;
import org.apache.commons.lang3.StringUtils;

public class SpringSecurityUtil {

	public static boolean verifyToken(String token, String userId, String origin) {
		boolean flag = false;
		origin = (StringUtils.isBlank(origin))? Constants.LOGIN_ORIGIN_WEB:origin;
		if(StringUtils.isBlank(token) || StringUtils.isBlank(userId)){
			return flag;
		}
		if(token.equals(CacheUtil.get(Constants.CACHE_CONSUMER_TOKEN + userId + origin))){
			flag = true;
//			TomatoConsumer user = JSON.parseObject(CacheUtil.get(Constants.CACHE_CONSUMER_INFO + userId + origin), TomatoConsumer.class);
//			resetToken(token, user, origin); //每次有效操作延长token有效期
		}
		return flag;
	}

//	public static void resetToken(String token, TomatoConsumer user, String origin) {
//		switch (origin) {
//		case Constants.LOGIN_ORIGIN_WEB:
//			CacheUtil.set(Constants.CACHE_CONSUMER_TOKEN + user.getId() + origin, 3600, token); //网页登录有效期 1小时 = 3600秒
//			CacheUtil.set(Constants.CACHE_CONSUMER_INFO + user.getId() + origin, 3600, JSON.toJSONString(user));
//			break;
//		case Constants.LOGIN_ORIGIN_PHE:
//			CacheUtil.set(Constants.CACHE_CONSUMER_TOKEN + user.getId() + origin, token);
//			CacheUtil.set(Constants.CACHE_CONSUMER_INFO + user.getId() + origin, JSON.toJSONString(user));
//			break;
//		default:
//			break;
//		}
//	}

	/**
	 * 验证拥有超级权限的接口  是否是合法用户在调用
	 * @param appId
	 * @param appKey
	 * @return
	 */
	public static boolean verifyApp(String appId, String appKey) {
		if(Constants.SUPER_APPID_YUNYING.equals(appId) && Constants.SUPER_APPKEY_YUNYING.equals(appKey)){
			return true;
		}
		return false;
	}

}
