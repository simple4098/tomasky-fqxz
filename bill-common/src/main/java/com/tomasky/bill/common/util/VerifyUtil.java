package com.tomasky.bill.common.util;


import com.tomasky.bill.common.cons.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * 数据校验工具类
 *
 * @author hai
 */
public class VerifyUtil {

    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).trim().length() == 0;
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static boolean isEmpty(String str) {
        return isEmpty(str, true);
    }

    /**
     * 字符串验空
     *
     * @param str    被验证的字符串
     * @param isTrim 是否去除空格，默认去除
     * @return 返回该字符串是否为空
     */
    public static boolean isEmpty(String str, boolean isTrim) {
        return null == str || (isTrim ? str.trim().length() == 0 : str.length() == 0);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str, true);
    }

    /**
     * 字符串非空验证
     *
     * @param str    被验证的字符串
     * @param isTrim 是否去除空格 ，默认去除
     * @return 返回该字符串是否不为空
     */
    public static boolean isNotEmpty(String str, boolean isTrim) {
        return !isEmpty(str, isTrim);
    }

    public static <E> boolean isEmpty(Collection<E> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 校验集合是否为空，且根据参数指示校验集合项是否全为null
     *
     * @param collection 校验的集合
     * @param checkItem  是否校验集合的每一项都为null，true：校验、false：不校验
     * @return
     * @author hai
     * @date 2014年1月7日上午11:38:56
     */
    public static <E> boolean isEmpty(Collection<E> collection, boolean checkItem) {
        boolean result = null == collection || collection.isEmpty();
        if (!result && checkItem) {
            int count = 0;
            for (E e : collection) {
                if (null == e) {
                    count++;
                }
            }
            result = count == collection.size() ? !result : result;
        }
        return result;
    }

    public static <E> boolean isNotEmpty(Collection<E> collection) {
        return !isEmpty(collection);
    }

    /**
     * 校验集合是否不为空，且根据参数指示校验集合项是否全为null
     *
     * @param collection 校验的集合
     * @param checkItem  是否校验集合的每一项都为null，true：校验、false：不校验
     * @return
     * @author hai
     * @date 2014年1月7日上午11:38:56
     */
    public static <E> boolean isNotEmpty(Collection<E> collection, boolean checkItem) {
        return !isEmpty(collection, checkItem);
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return null == map || map.isEmpty();
    }

    /**
     * 校验map是否为空，且根据参数指示校验map项的值[value]是否全为null
     *
     * @param map       校验的map
     * @param checkItem 是否校验map的每一项的value都为null，true：校验、false：不校验
     * @return
     * @author hai
     * @date 2014年1月7日上午11:54:43
     */
    public static <K, V> boolean isEmpty(Map<K, V> map, boolean checkItem) {
        boolean result = null == map || map.isEmpty();
        if (!result && checkItem) {
            int count = 0;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (null == entry.getValue()) {
                    count++;
                }
            }
            result = count == map.size() ? !result : result;
        }
        return result;
    }

    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }

    /**
     * 校验map是否不为空，且根据参数指示校验map项是否全为null
     *
     * @param map       校验map
     * @param checkItem 是否校验map的每一项的value都为null，true：校验、false：不校验
     * @return
     * @author hai
     * @date 2014年1月7日上午11:54:43
     */
    public static <K, V> boolean isNotEmpty(Map<K, V> map, boolean checkItem) {
        return !isEmpty(map, checkItem);
    }

    public static boolean isEmpty(Object[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * 校验数组是否为空，且根据参数指示校验数组项是否全为null
     *
     * @param arr       校验的数组
     * @param checkItem 是否校验数组的每一项都为null，true：校验、false：不校验
     * @return
     * @author hai
     * @date 2014年1月7日上午11:29:06
     */
    public static boolean isEmpty(boolean checkItem, Object... arr) {
        boolean result = null == arr || arr.length == 0;
        if (!result && checkItem) {
            int count = 0;
            for (Object object : arr) {
                if (null == object) {
                    count++;
                } else {
                    if (object instanceof String) {
                        if (((String) object).trim().length() == 0) {
                            count++;
                        }
                    }
                }
            }
            result = count == arr.length ? !result : result;
        }
        return result;
    }

    public static boolean isNotEmpty(Object[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 校验数组是否不为空，且根据参数指示校验数组项是否全为null
     *
     * @param arr       校验的数组
     * @param checkItem 是否校验数组的每一项都为null，true：校验、false：不校验
     * @return
     * @author hai
     * @date 2014年1月7日上午11:33:18
     */
    public static boolean isNotEmpty(boolean checkItem, Object... arr) {
        return !isEmpty(checkItem, arr);
    }

    /**
     * 二维数组的空校验
     *
     * @param arr 要验证的二维数组
     * @return 返回该二维数组是否为空
     */
    public static boolean isEmpty(Object[][] arr) {
        if (null == arr || arr.length == 0) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNotEmpty(Object[][] arr) {
        return !isEmpty(arr);
    }

    /**
     * 检查参数是否非法，并且校验结束时间要大于开始时间<br/>
     * [注：此方法不校验数值参数的合法性]
     *
     * @param objParams   校验参数
     * @param dateStrings 校验时间[此为二维数组，每个数组两元素：arr[0] - 开始时间，arr[1]结束时间]
     * @return 非法返回true，合法返回false
     */
    public static boolean checkParamsAndCompareDate(Object[] objParams, String[][] dateStrings) {
        return checkParamsAndCompareDate(objParams, dateStrings, false);
    }

    /**
     * 检查参数是否非法，并且校验结束时间要大于开始时间，且指定是否要校验参数中的数值是否非法<br/>
     * [注：此方法校验参数中的数值是否合法时，默认-1为非法值]
     *
     * @param objParams   校验参数
     * @param dateStrings 校验时间[此为二维数组，每个数组两元素：arr[0] - 开始时间，arr[1]结束时间]
     * @param isCheckNum  是否校验objParams中的数值参数是否非法[如果传有数值型参数]，默认数值型参数的非法值为-1
     * @return 非法返回true，合法返回false
     */
    public static boolean checkParamsAndCompareDate(Object[] objParams, String[][] dateStrings, boolean isCheckNum) {
        return checkParamsAndCompareDate(objParams, dateStrings, isCheckNum, Constants.INVALID_PARAM_CODE);
    }

    /**
     * 检查参数是否非法，并且校验结束时间要大于开始时间，且指定是否要校验参数中的数值是否等于指定的非法数值
     *
     * @param objParams   校验参数
     * @param dateStrings 校验时间[此为二维数组，每个数组两元素：arr[0] - 开始时间，arr[1]结束时间]
     * @param isCheckNum  是否校验数值参数是否非法
     * @param illegalNum  当要校验数值参数是否合法时，用以对比的非法参数值
     * @return 非法返回true，合法返回false
     */
    public static boolean checkParamsAndCompareDate(Object[] objParams, String[][] dateStrings, boolean isCheckNum, Number illegalNum) {

        if (null == objParams) {
            return false;
        }
        if (isCheckNum) {
            if (checkNumberIsIllegal(objParams, illegalNum)) {
                return true;
            }
        } else {
            for (Object objParam : objParams) {
                if (isEmpty(objParam)) {
                    return true;
                }
            }
        }

        if (null == dateStrings) {
            return false;
        }
        SimpleDateFormat sf = new SimpleDateFormat(DateUtil.FORMAT_DATE_STR);
        for (String[] dateStrArr : dateStrings) {
            if (checkDateIsIllegal(dateStrArr, sf)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 校验时间字符串是否非法
     *
     * @param dateStr 时间字符串
     * @param sf      时间格式化器
     * @return 时间非法返回true，合法返回false
     */
    public static boolean checkDateIsIllegal(String dateStr, SimpleDateFormat sf) {
        if (isEmpty(dateStr)) {
            return true;
        }
        try {
            sf.parse(dateStr);
        } catch (ParseException e) {
            return true;
        }
        return false;
    }

    /**
     * 校验时间是否非法且结束时间是否小于开始时间
     *
     * @param dateStrArr
     * @param sf
     * @return 时间字符串为空或结束时间小于开始时间返回true[非法]，否则返回false[合法]
     */
    public static boolean checkDateIsIllegal(String[] dateStrArr, SimpleDateFormat sf) {
        if (isEmpty(dateStrArr) || isEmpty(dateStrArr[0]) || isEmpty(dateStrArr[1])) {
            return true;
        }
        try {
            Date start = sf.parse(dateStrArr[0]);
            Date end = sf.parse(dateStrArr[1]);
            if (end.before(start)) {
                return true;
            }
        } catch (ParseException e) {
            return true;
        }
        return false;
    }

    /**
     * 判断参数是否为空，并且判断根据指定的非法值判断传入的数值是否非法
     *
     * @param objParams  校验的参数
     * @param illegalNum
     * @return 非法返回true，合法返回false
     */
    public static boolean checkNumberIsIllegal(Object[] objParams, Number illegalNum) {
        if (null == objParams) {
            return false;
        }
        for (Object objParam : objParams) {
            if (checkNumberIsIllegal(objParam, illegalNum, true)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断参数是否为空，并且判断根据指定的非法值判断传入的数值是否非法
     *
     * @param objParam     校验的参数
     * @param illegalNum   当要校验数值参数是否合法时，用以对比的非法参数值
     * @param isCheckEmpty 是否检查参数为空
     * @return 非法返回true，合法返回false
     */
    public static boolean checkNumberIsIllegal(Object objParam, Number illegalNum, boolean isCheckEmpty) {
        if (isCheckEmpty) {
            if (isEmpty(objParam)) {
                return true;
            }
        }
        if (objParam instanceof Number) {
            if (objParam.equals(illegalNum)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验参数，默认校验数值参数是否非法，默认非法数值为-1
     *
     * @param objParams 待校验的参数
     * @return boolean
     * @author hai
     * @date 2014年4月3日 上午10:03:07
     */
    public static boolean checkParams(Object[] objParams) {
        return checkParams(objParams, false);
    }

    /**
     * 校验输入参数[当校验数值时，非法数值对比值为-1]
     *
     * @param objParams  待校验的参数
     * @param isCheckNum 是否校验数值是否非法
     * @return boolean
     * @author hai
     * @date 2014年4月3日 上午10:01:01
     */
    public static boolean checkParams(Object[] objParams, boolean isCheckNum) {
        return checkParams(objParams, isCheckNum, Constants.INVALID_PARAM_CODE);
    }

    /**
     * 检查参数合法性
     *
     * @param objParams  校验的参数
     * @param isCheckNum 是否校验数值参数是否非法
     * @param illegalNum 当要校验数值参数是否合法时，用以对比的非法参数值
     * @return 非法返回true，合法返回false
     */
    public static boolean checkParams(Object[] objParams, boolean isCheckNum, Number illegalNum) {

        if (isEmpty(objParams)) {
            return false;
        }

        if (isCheckNum) {
            checkNumberIsIllegal(objParams, illegalNum);
        } else {
            for (Object objParam : objParams) {
                if (isEmpty(objParam)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 校验参数中是否有空值
     *
     * @param objParams
     * @return boolean
     * @author hai
     * @date 2014年4月3日 上午10:04:17
     */
    public static boolean checkParamsExsitEmptyValue(Object[] objParams) {

        if (isEmpty(objParams)) {
            return false;
        }

        for (Object objParam : objParams) {
            if (null == objParam) {
                return true;
            }
            if (objParam instanceof String) {
                if (((String) objParam).trim().length() == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 校验数值参数是否非法[默认非法值为-1]
     *
     * @param params 要校验的数值型字符
     * @return 非法返回true，合法返回false
     */
    public static boolean checkNumberIsIllegal(Object[] params) {
        return checkNumberIsIllegal(params, Constants.INVALID_PARAM_CODE);
    }

    public static boolean checkIntegerIsIllegal(Integer param) {
        return checkIntegerIsIllegal(param, null);
    }

    public static boolean checkIntegerIsIllegal(Integer param, Integer illegalValue) {
        if (null == param) {
            return true;
        }
        if (null == illegalValue) {
            return param.intValue() <= 0;
        }
        return param.equals(illegalValue);
    }

    /**
     * 校验int参数是否非法[默认非法值为-1]
     *
     * @param params 校验参数
     * @return 非法返回true，合法返回false
     */
    public static boolean checkIntegerIsIllegal(Integer[] params) {
        return checkIntegerIsIllegal(params, Constants.INVALID_PARAM_CODE);
    }

    /**
     * 根据指定的非法int值校验int参数是否非法
     *
     * @param params       校验参数
     * @param illegalValue 非法参数值
     * @return 非法返回true，合法返回false
     */
    public static boolean checkIntegerIsIllegal(Integer[] params, int illegalValue) {
        if (isEmpty(params)) {
            return false;
        }
        for (Integer i : params) {
            if (null == i || i.intValue() == illegalValue) {
                return true;
            }
        }
        return false;
    }

    public static boolean baseValidateNumber(Number[] params) {
        for (Number item : params) {
            if (baseValidateNumber(item)) {
                return true;
            }
        }
        return false;
    }

    public static boolean baseValidateNumber(Number item) {
        return null == item || item.doubleValue() <= 0;
    }

    public static boolean in(Object obj, Object[] contains) {
        return in(obj, contains, true, true);
    }

    /**
     * 校验数值中是否存在某值
     *
     * @param obj
     * @param contains
     * @param checkObj
     * @param checkArr
     * @return boolean
     * @author hai
     * @date 2014年4月3日 上午10:04:56
     */
    public static boolean in(Object obj, Object[] contains, boolean checkObj, boolean checkArr) {
        if (checkObj) {
            if (isEmpty(obj)) {
                return false;
            }
        }
        if (checkArr) {
            if (isEmpty(contains)) {
                return false;
            }
        }
        if (obj instanceof Number) {
            for (Object object : contains) {
                if (object instanceof Number) {
                    if (obj.equals(object)) {
                        return true;
                    }
                }
            }
        } else if (obj instanceof String) {
            for (Object object : contains) {
                if (object instanceof String) {
                    if (obj.toString().equals(object.toString())) {
                        return true;
                    }
                }
            }
        } else {
            for (Object object : contains) {
                if (obj == object) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 校验数值中是否不存在某值
     *
     * @param obj
     * @param contains
     * @return boolean
     * @author hai
     * @date 2014年4月3日 上午10:04:56
     */
    public static boolean notIn(Object obj, Object[] contains) {
        return !notIn(obj, contains, true, true);
    }

    public static boolean notIn(Object obj, Object[] contains, boolean checkObj, boolean checkArr) {
        return !in(obj, contains, checkObj, checkArr);
    }

    public static boolean isEmptyFromMultArr(Object[]... arr) {
        return isEmptyFromMultArr(false, arr);
    }

    public static boolean isEmptyFromMultArr(boolean checkItem, Object[]... arr) {

        if (checkItem) {
            for (Object[] objects : arr) {
                if (null == objects || objects.length == 0) {
                    return true;
                }
                for (Object object : objects) {
                    if (null == object) {
                        return true;
                    }
                    if (object instanceof String) {
                        if ("".equals(((String) object).trim())) {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (Object[] objects : arr) {
                if (null == objects || objects.length == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isNotEmptyFromMultArr(Object[]... arr) {
        return !isEmptyFromMultArr(false, arr);
    }

    public static boolean isNotEmptyFromMultArr(boolean checkItem, Object[]... arr) {
        return !isEmptyFromMultArr(checkItem, arr);
    }

    public static void main(String[] args) {
        System.out.println(isEmpty(true, new Object[]{null, ""}));
        CheckObject checkObject = CheckObject.newInstance();
        System.out.println(in(/* 10.123 *//* CheckObject.newInstance(), *//* checkObject */"a", new Object[]{10.1, 10.12, CheckObject.newInstance(), checkObject, null, "a", 10, 10.123, "0", "1", "2",
                "3", "4"}));
        System.out.println(baseValidateNumber(1));
        System.out.println(isEmpty("  "));
        Number n = 1;
        System.out.println(n.doubleValue());
    }

    static class CheckObject {
        private int num;
        private String str;

        public static CheckObject newInstance() {
            return new CheckObject();
        }

        /**
         * @return the num
         */
        public int getNum() {
            return num;
        }

        /**
         * @param num the num to set
         */
        public void setNum(int num) {
            this.num = num;
        }

        /**
         * @return the str
         */
        public String getStr() {
            return str;
        }

        /**
         * @param str the str to set
         */
        public void setStr(String str) {
            this.str = str;
        }
    }
}
