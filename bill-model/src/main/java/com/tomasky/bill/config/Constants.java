package com.tomasky.bill.config;


/**
 * @author X 
 * 系统常量存放位置
 */
public class Constants {
	
	// 是与否的通用常量标示(0:否/禁用/无效 1:是/启用/有效)
    public final static int COMMON_NO = 0;
    public final static int COMMON_YES = 1;

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