package com.tomasky.fqxz.common;


/**
 * @author momo
 *         系统常量存放位置
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

    // 状态/返回key值
    public final static String SUCCESS = "success";
    public final static String FAILURE = "fail";
    public final static String CLOSED = "closed";
    public final static String COOKIE = "cookie";
    public final static String FLAG = "flag";
    public final static String STATUS = "status";
    public final static String PAGE = "page";
    public final static String MESSAGE = "message";
    public final static String MSG = "msg";
    public final static String ERRORS = "errors";
    public final static String RESULT = "result";
    public final static String NOTHING = "nothing";

    // 非法参数状态码
    public static final int INVALID_PARAM_CODE = -1;

    public static final String ENVIRONMENT_DEVELOPMENT = "dev";
    public static final String ENVIRONMENT_TEST = "test";
    public static final String ENVIRONMENT_STAGING = "staging";
    public static final String ENVIRONMENT_PRODUCTION = "production";

    // cache/session/cooikes最大存储时间：秒（30天）
    public final static int CACHE_MAX_AGE = 2592000;
    public final static int CACHE_HALF_HOUR = 1800;

    //PAGE
    public final static int DEFAULT_PAGE_SIZE = 10;
    public final static int DEFAULT_PAGE_NO = 1;
    public final static int DO_NOT_PAGE = -1;

}