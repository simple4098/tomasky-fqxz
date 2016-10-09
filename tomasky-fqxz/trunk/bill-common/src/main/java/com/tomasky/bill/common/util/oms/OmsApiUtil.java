package com.tomasky.bill.common.util.oms;

import com.alibaba.fastjson.JSON;
import com.tomasky.bill.common.cons.Constants;
import com.tomasky.bill.common.util.HttpClientUtil;
import com.tomasky.bill.common.util.ResourceBundleUtil;
import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Map;


public class OmsApiUtil {
	
	private static String OMS_INN_INFO_URI = ResourceBundleUtil.getString("uri.oms.queryInn");
	private static String OMS_INN_LIST_URI = ResourceBundleUtil.getString("uri.oms.queryProxySaleList");
	private static String OMS_INN_LOWEST_PRICE_URI = ResourceBundleUtil.getString("uri.oms.queryFloorPrice");
	private static String OMS_INN_ROOMTYPE_LIST_URI = ResourceBundleUtil.getString("uri.oms.queryRoomType");
	private static String OMS_INN_ROOM_STATUS_URI = ResourceBundleUtil.getString("uri.oms.queryRoomStatus");
	private static String OMS_ORDER_SAVE_URI = ResourceBundleUtil.getString("uri.oms.order");
	private static String OMS_ORDER_CANCEL_URI = ResourceBundleUtil.getString("uri.oms.cancelOrder");

//	private static void setCommonParam(InnBo param, List<NameValuePair> params) {
//		if(param.getAccountId() != null){
//			for (Integer id : param.getAccountId()) {
//				params.add(new BasicNameValuePair("accountId", String.valueOf(id)));
//			}
//		}
//		if(param.getRoomTypeIds() != null){
//			for (Integer id : param.getRoomTypeIds()) {
//				params.add(new BasicNameValuePair("roomTypeIds", String.valueOf(id)));
//			}
//		}
//		params.add(new BasicNameValuePair("otaId", String.valueOf(param.getOtaId())));
//		params.add(new BasicNameValuePair("timestamp", String.valueOf(param.getTimestamp())));
//		params.add(new BasicNameValuePair("signature", param.getSignature()));
//	}
	
	@SuppressWarnings("unused")
	private static String getResultByPostBody(String url,
			Map<String, String> requestHeader, String json) {
		String content = HttpClientUtil.getResponseInfoByPost(Constants.HTTP_GET_TYPE_STRING, url, json, requestHeader);
		return content;
	}

	private static String getResultByPost(String url,
			List<NameValuePair> params) {
		String content = HttpClientUtil.getResponseInfoByPost(Constants.HTTP_GET_TYPE_STRING, url, params);
		return content;
	}

	@SuppressWarnings("unused")
	private static Map<String, Object> getResultByGet(String url) {
		String content = HttpClientUtil.getResponseInfoByGet(url);
		Map<String, Object> result = JSON.parseObject(content);
		return result;
	}
}
