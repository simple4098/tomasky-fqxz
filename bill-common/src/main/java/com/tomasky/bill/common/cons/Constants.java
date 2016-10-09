package com.tomasky.bill.common.cons;


/**
 * @author X 
 * 系统常量存放位置
 */
public class Constants {
	
	// 是与否的通用常量标示(0:否/禁用/无效 1:是/启用/有效)
    public final static int COMMON_NO = 0;
    public final static int COMMON_YES = 1;
	
	public final static String HTTP_REQUEST_TYPE_GET = "GET";
    public final static String HTTP_REQUEST_TYPE_POST = "POST";

    // http 相关
    public final static int HTTP_OK = 200;
    public final static int HTTP_400 = 400;
    public final static int HTTP_401 = 401;
    public final static int HTTP_404 = 404;
    public final static int HTTP_500 = 500;
    public final static int HTTP_800 = 800;

    // 状态/返回key值
    public final static String SUCCESS = "success";
    public final static String FAILURE = "fail";
    public final static String CLOSED = "closed";
    public final static String COOKIE = "cookie";
    public final static String FLAG = "flag";
    public final static String STATUS = "status";
    public final static String PAGE = "page";
    public final static String MESSAGE = "message";
    public final static String ERRORS = "errors";
    public final static String RESULT = "result";
    public final static String NOTHING = "nothing";
    
    //支付系统 CODE
    public final static String FQPAY_RESULT_SUCCESS = "SUCCESS";

    // 非法参数状态码
    public static final int INVALID_PARAM_CODE = -1;

	public static final String ENVIRONMENT_DEVELOPMENT = "dev";
	public static final String ENVIRONMENT_TEST = "test";
	public static final String ENVIRONMENT_STAGING = "staging";
	public static final String ENVIRONMENT_PRODUCTION = "production";
	
	// http获取响应类型(all:所有，responseStr:网页字符串，cookies：网页cookies)
    public final static String HTTP_GET_TYPE_ALL = "all";
    public final static String HTTP_GET_TYPE_STRING = "responseStr";
    public final static String HTTP_GET_TYPE_COOKIES = "cookies";
    
    //登录 origin值
    public final static String LOGIN_ORIGIN_WEB = "_web_";

    //sessionKEY值
    public static final String SESSION_TOKEN = "_session_token_";
    public static final String SESSION_USER = "_session_user_";
    
    //appId&appKey
    public static final String SUPER_APPID_YUNYING = "fxadddf1f97bc31bf9";
    public static final String SUPER_APPKEY_YUNYING = "3cd642c8b789b67bd6f5fb5ba256a335";
    
    //缓存KEY值
    public static final String CACHE_SYS_TAG = "_sys_dis_";
    public static final String CACHE_COMMON_UNION = "_union_info_";
    public static final String CACHE_CONSUMER_TOKEN = "_consumer_token_";
	public static final String CACHE_CONSUMER_INFO = "_consumer_info_";
	public static final String CACHE_CONSUMER_MEMBER = "_consumer_member_";
	public static final String CACHE_WEIXIN_TOKEN = "_weixin_token_";
	public static final String CACHE_WEIXIN_QRCODE = "_weixin_qrcode_";
	public static final String CACHE_FLAG_FX_ORDER_KEY = "_flag_fx_order_key_";
    public static final String CACHE_FLAG_VALID_CODE = "_flag_valid_code_key_";
	
    // cache/session/cooikes最大存储时间：秒（30天）
    public final static int CACHE_MAX_AGE = 2592000;

    //PAGE
    public final static int DEFAULT_PAGE_SIZE = 10;
    public final static int DEFAULT_PAGE_NO = 1;
    public final static int DO_NOT_PAGE = -1;

    //number
    public final static int DEFAULT_SCALE = 2;

	public static final String DEFAULT_WRONG_URI = "/user/problems";

    //支付记录——分账类型
    public static final String PAY_RECEIPT_IN_COME = "1";
    public static final String PAY_RECEIPT_SUB_COMMISSION = "2";
    public static final String PAY_RECEIPT_COLLECTION = "3";
    public static final String PAY_RECEIPT_OTHER = "4";
    public static final int INN_INFO_PAGE_SIZE = 5;

    public static final int PAY_STATUS_PAID = 2;

    /** 联盟类型 1:大联盟   2:小站连锁 */
    public static final Integer UNION_TYPE_LARGE = 1;
    public static final Integer UNION_TYPE_SMALL = 2;
    public static final String REGEX_SIMPLE_DATE = "\\\\d{4}-\\\\d{2}-\\\\d{2}";

    /** 1:支付   2:退款 */
    public static final String PAY_TYPE_INCOME = "1";
    public static final String PAY_TYPE_PAYOUT = "2";

    // 是否已经平账： 0：否 1：是 -1：无需
    public static final int IS_BALANCE_NO = 0;
    public static final int IS_BALANCE_YES = 1;
    public static final int IS_BALANCE_NOT = -1;
}