/**
 * <h3>Class description</h3>
 * <h4>日期处理类</h4>
 * <h4>Special Notes</h4>
 *
 * @ver 0.1
 * @author mowei
 */
package com.tomasky.fqxz.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	
	protected static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    /**
     * 一天的毫秒数
     */
    public static final long MILLION_SECONDS_OF_DAY = 86400000;
    /**
     * 一小时的毫秒数
     */
    public static final long MILLION_SECONDS_OF_HOUR = 3600000;
    /**
     * 一分钟的毫秒数
     */
    public static final long MILLION_SECONDS_OF_MINUTE = 60000;
    /**
     * 一秒钟的毫秒数
     */
    public static final long MILLION_SECONDS_OF_SECOND = 1000;
    /**
     * 日期格式化格式
     */
    public static final String FORMAT_DATE_STR = "yyyy-MM-dd";
    /**
     * 日期格式化格式
     */
    public static final String FORMAT_DATE_MON = "yyyy-MM";
    public static final String FORMAT_MON_DAY = "MM-dd";
    /**
     * 日期格式化格式
     */
    public static final String FORMAT_DATE_STR_NO_SEP = "yyyyMMdd";

    /**
     * 时间格式化格式
     */
    public static final String FORMAT_DATE_STR_ONE = "yyyy-MM-dd HH:mm";
    /**
     * 时间格式化格式：显示秒
     */
    public static final String FORMAT_DATE_STR_SECOND = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE_STR_MILLISECOND = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * 年月日时分秒毫秒(无下划线) yyyyMMddHHmmssSSS
     */
    public static final String FORMAT_DATE_STR_LONG = "yyyyMMddHHmmssSSS";
    /**
     * 年月日时分秒,以横线分隔，类似于文件命名形式
     */
    public static final String FORMAT_DATE_STR_SECOND_FILE_NAME = "yyyy-MM-dd-HH-mm-ss";

    public static DateFormat getDateFormat(String... format) {
        String fmt;
        if (VerifyUtil.isEmpty(format) || VerifyUtil.isEmpty(format[0])) {
            fmt = FORMAT_DATE_STR;
        } else {
            fmt = format[0];
        }
        return new SimpleDateFormat(fmt);
    }

    /**
     * 得到两个日期之间相差的年数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDifferYear(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        return c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
    }

    /**
     * 得到两个日期之间相差的年数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDifferYear(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, FORMAT_DATE_STR);
        Date dateTime2_tmp = parse(date2, FORMAT_DATE_STR);
        return getDifferYear(dateTime1_tmp, dateTime2_tmp);
    }

    /**
     * 得到两个日期之间相差的月数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDifferMonth(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        int year = getDifferYear(date1, date2);
        int months = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) + year * 12;
        if (c2.get(Calendar.DATE) < c1.get(Calendar.DATE)) {
            months = months - 1;
        }
        return months;
    }

    /**
     * 得到两个日期之间相差的月数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDifferMonth(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, FORMAT_DATE_STR);
        Date dateTime2_tmp = parse(date2, FORMAT_DATE_STR);
        return getDifferMonth(dateTime1_tmp, dateTime2_tmp);
    }

    /**
     * 得到两个日期之间相差的天数,两头不算,取出数据后，可以根据需要再加 此方法在计算相邻两天的日期时结果为0,弃用！！
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDifferDay(Date date1, Date date2) {
        String d1 = format(date1);
        String d2 = format(date2);
        return getDifferDay(d1, d2);
    }

    /**
     * 得到两个日期之间相差的天数,两头不算,取出数据后，可以根据需要再加
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDifferDay(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, FORMAT_DATE_STR);
        Date dateTime2_tmp = parse(date2, FORMAT_DATE_STR);
        Long d1 = dateTime1_tmp.getTime();
        Long d2 = dateTime2_tmp.getTime();
        return (int) ((d2 - d1) / MILLION_SECONDS_OF_DAY);
    }
    
    /**
     * 得到两个日期之间相差的毫秒,两头不算,取出数据后，可以根据需要再加
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDifferMilliSec(String date1, String date2) {
    	Date dateTime1_tmp = parse(date1, FORMAT_DATE_STR_SECOND);
    	Date dateTime2_tmp = parse(date2, FORMAT_DATE_STR_SECOND);
    	return getDifferMilliSec(dateTime1_tmp, dateTime2_tmp);
    }
    
    public static long getDifferMilliSec(Date date1, Date date2) {
    	Long d1 = date1.getTime();
    	Long d2 = date2.getTime();
    	return d2 - d1;
    }

    public static int getDifferDay(Date date1, Date date2, DateFormat format) {
        String d1 = format.format(date1);
        String d2 = format.format(date2);
        return getDifferDay(d1, d2, format);
    }

    public static int getDifferDay(String date1, String date2, DateFormat format) {
        try {
            Date dateTime1_tmp = format.parse(date1);
            Date dateTime2_tmp = format.parse(date2);
            Long d1 = dateTime1_tmp.getTime();
            Long d2 = dateTime2_tmp.getTime();
            return (int) ((d2 - d1) / MILLION_SECONDS_OF_DAY);
        } catch (ParseException e) {
        	logger.error("格式化指定日期为Date类型出错", e);
        }
        return 0;
    }

    /**
     * 计算2个时间之间的相差的小时和分钟数，返回XX小时XX分 注意date1格式为yyyy-MM-dd 注意date2格式为yyyy-MM-dd 注意time1格式为HH:mm 注意time2格式为HH:mm date1<date2
     *
     * @param date1
     * @param time1
     * @param date2
     * @param time2
     * @return resultHM[hours, mins]
     */
    public static int[] getDifferHourAndMinute(String date1, String time1, String date2, String time2) {
        Date dateTime1_tmp = parse(date1 + " " + time1, FORMAT_DATE_STR_ONE);
        Date dateTime2_tmp = parse(date2 + " " + time2, FORMAT_DATE_STR_ONE);
        Long d2 = dateTime2_tmp.getTime();
        Long d1 = dateTime1_tmp.getTime();
        int hours = (int) ((d2 - d1) / MILLION_SECONDS_OF_HOUR);
        int mins = (int) ((d2 - d1) % MILLION_SECONDS_OF_HOUR);
        mins = (int) (mins / MILLION_SECONDS_OF_MINUTE);
        int[] resultHM = new int[2];
        resultHM[0] = hours;
        resultHM[1] = mins;
        return resultHM;
    }

    /**
     * 计算2个时间之间的相差的小时和分钟数，返回XX小时XX分 注意date1格式为yyyy-MM-dd HH:mm 注意date2格式为yyyy-MM-dd HH:mm date1<date2
     *
     * @param date1
     * @param date2
     * @return resultHM[hours, mins]
     */
    public static int[] getDifferHourAndMinute(Date date1, Date date2) {
        Long d2 = date2.getTime();
        Long d1 = date1.getTime();
        int hours = (int) ((d2 - d1) / MILLION_SECONDS_OF_HOUR);
        int mins = (int) ((d2 - d1) % MILLION_SECONDS_OF_HOUR);
        mins = mins / 60000;
        int[] resultHM = new int[2];
        resultHM[0] = hours;
        resultHM[1] = mins;
        return resultHM;
    }

    /**
     * 计算2个时间之间的相差的小时和分钟数，返回XX小时XX分 注意date1格式为yyyy-MM-dd HH:mm 注意date2格式为yyyy-MM-dd HH:mm date1<date2
     *
     * @param date1
     * @param date2
     * @return resultHM[hours, mins]
     */
    public static int[] getDifferHourAndMinute(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, FORMAT_DATE_STR_ONE);
        Date dateTime2_tmp = parse(date2, FORMAT_DATE_STR_ONE);
        Long d2 = dateTime2_tmp.getTime();
        Long d1 = dateTime1_tmp.getTime();
        int hours = (int) ((d2 - d1) / MILLION_SECONDS_OF_HOUR);
        int mins = (int) ((d2 - d1) % MILLION_SECONDS_OF_HOUR);
        mins = mins / 60000;
        int[] resultHM = new int[2];
        resultHM[0] = hours;
        resultHM[1] = mins;
        return resultHM;
    }

    /**
     * 计算2个时间之间的相差的小时数(Date,Date) date1<date2
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDifferHour(Date date1, Date date2) {
        Long d1 = date1.getTime();
        Long d2 = date2.getTime();
        int hours = (int) ((d2 - d1) / MILLION_SECONDS_OF_HOUR);
        return hours;
    }

    /**
     * 计算2个时间之间的相差的小时(String,String) date1<date2
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDifferHour(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, FORMAT_DATE_STR_ONE);
        Date dateTime2_tmp = parse(date2, FORMAT_DATE_STR_ONE);
        Long d2 = dateTime2_tmp.getTime();
        Long d1 = dateTime1_tmp.getTime();
        int hours = (int) ((d2 - d1) / MILLION_SECONDS_OF_HOUR);
        return hours;
    }

    /**
     * 返回两日期相差的分钟数[date1、date2格式为: "yyyy-MM-dd"; time1、time2格式为: "HH:mm"]
     *
     * @param date1
     * @param time1
     * @param date2
     * @param time2
     * @return
     * @author hai
     * @date 2014年1月7日下午2:01:28
     */
    public static int getDifferMinute(String date1, String time1, String date2, String time2) {
        Date dateTime1_tmp = parse(date1 + " " + time1, FORMAT_DATE_STR_ONE);
        Date dateTime2_tmp = parse(date2 + " " + time2, FORMAT_DATE_STR_ONE);
        return getDifferMinute(dateTime1_tmp, dateTime2_tmp);
    }

    /**
     * 返回两日期相差的分钟数[日期格式为: "yyyy-MM-dd HH:mm"]
     *
     * @param date1
     * @param date2
     * @return
     * @author hai
     * @date 2014年1月7日下午1:58:10
     */
    public static int getDifferMinute(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, FORMAT_DATE_STR_ONE);
        Date dateTime2_tmp = parse(date2, FORMAT_DATE_STR_ONE);
        return getDifferMinute(dateTime1_tmp, dateTime2_tmp);
    }

    /**
     * 返回两日期相差的分钟数[日期格式为: "yyyy-MM-dd HH:mm"]
     *
     * @param date1
     * @param date2
     * @return
     * @author hai
     * @date 2014年1月7日下午1:58:10
     */
    public static int getDifferMinute(Date date1, Date date2) {
        Long d2 = date2.getTime();
        Long d1 = date1.getTime();
        int hours = (int) ((d2 - d1) / MILLION_SECONDS_OF_MINUTE);
        return hours;
    }
    /**
     * 返回两日期相差的分钟数[日期格式为: "yyyy-MM-dd HH:mm"]
     *
     * @param date1
     * @param date2
     * @return
     * @author hai
     * @date 2014年1月7日下午1:58:10
     */
    public static int getDifferSec(Date date1, Date date2) {
    	Long d2 = date2.getTime();
    	Long d1 = date1.getTime();
    	int hours = (int) ((d2 - d1) / MILLION_SECONDS_OF_SECOND);
    	return hours;
    }

    // ///////////////////////////////////////////// 以下为加减时间操作：addXXX() - 加时间; subXXX() - 减时间 ///////////////////////////////////////////////
    public static Date addMinutes(Date date, int minutes) {
        return afterDate(date, Calendar.MINUTE, minutes);
    }

    public static Date subMinutes(Date date, int minutes) {
        return beforeDate(date, Calendar.MINUTE, minutes);
    }

    public static Date addHours(Date date, int hours) {
        return afterDate(date, Calendar.HOUR, hours);
    }

    public static Date subHours(Date date, int hours) {
        return beforeDate(date, Calendar.HOUR, hours);
    }

    public static Date addDays(Date date, int days) {
        return afterDate(date, Calendar.DAY_OF_MONTH, days);
    }

    public static Date subDays(Date date, int days) {
        return beforeDate(date, Calendar.DAY_OF_MONTH, days);
    }

    public static Date addMonths(Date date, int months) {
        return afterDate(date, Calendar.MONTH, months);
    }

    public static Date subMonths(Date date, int months) {
        return beforeDate(date, Calendar.MONTH, months);
    }

    public static Date addYears(Date date, int years) {
        return afterDate(date, Calendar.YEAR, years);
    }

    public static Date subYears(Date date, int years) {
        return beforeDate(date, Calendar.YEAR, years);
    }

    public static Date beforeDate(int timeUnit, int amount) {
        return beforeDate(new Date(), timeUnit, amount);
    }

    public static Date beforeDate(Date date, int timeUnit, int amount) {
        return dynamicDate(date, timeUnit, amount, true);
    }

    public static Date afterDate(int timeUnit, int amount) {
        return afterDate(new Date(), timeUnit, amount);
    }

    public static Date afterDate(Date date, int timeUnit, int amount) {
        return dynamicDate(date, timeUnit, amount, false);
    }

    /**
     * 获取指定时间
     *
     * @param date      操作的时间
     * @param timeUnit  时间单位，取自Calendar常量，如Calendar.YEAR：年；Calendar.MONTH：月等
     * @param amount    更改时间量，大小与timeUnit相关
     * @param is2before 是否为减时间操作
     * @return
     * @author hai
     * @date 2015年6月18日下午4:40:02
     */
    public static Date dynamicDate(Date date, int timeUnit, int amount, boolean is2before) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.add(timeUnit, is2before ? -amount : amount);
        return c.getTime();
    }

    /**
     * 格式化日期为String型(yyyy-MM-dd)
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, FORMAT_DATE_STR);
    }

    /**
     * 格式化日期为String型(yyyy-MM-dd HH:mm)
     *
     * @param date
     * @return
     */
    public static String formatHour(Date date) {
        if (date != null) {
            return format(date, FORMAT_DATE_STR_ONE);
        } else {
            return "";
        }

    }

    /**
     * 根据指定日期格式格式化日期为String型
     *
     * @param date
     * @param formater
     * @return
     */
    public static String format(Date date, String formater) {
        return getDateFormat(formater).format(date);
    }

    /**
     * 格式化日期为Date型(yyyy-MM-dd)
     *
     * @param date
     * @return
     */
    public static Date parse(String date) {
        return parse(date, FORMAT_DATE_STR);
    }

    /**
     * 根据指定日期格式格式化日期为Date型
     *
     * @param date
     * @param formater
     * @return
     */
    public static Date parse(String date, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        Date result = null;
        try {
            result = sdf.parse(date);
        } catch (Exception e) {
        	logger.error("格式化指定日期为Date类型出错", e);
        }
        return result;
    }

    /**
     * 根据日期取出是星期几,数字
     *
     * @param date
     * @return int 返回1-7
     */
    public static int getWeekOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return dayOfWeek == 0 ? 7 : dayOfWeek;
    }

    /**
     * 根据日期取出是星期几,中文
     *
     * @param date
     * @return int 返回1-7
     */
    public static String getWeekTextOfDate(Date date) {
        String dayNames[] = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int t = getWeekOfDate(date);
        if (t == 7)
            t = 0;
        return dayNames[t];
    }

    /**
     * 得到当前的日期，格式为：yyyy-MM-dd
     *
     * @return 为一个字符串
     */
    public static String getCurrenDate() {
        return format(new Date(), FORMAT_DATE_STR);
    }

    /**
     * 得到当前的时间，精确到分钟，格式为：yyyy-MM-dd hh:mm
     *
     * @return 为一个字符串
     */
    public static String getCurrentSimpleTime() {
        return format(new Date(), FORMAT_DATE_STR_ONE);
    }

    /**
     * 得到当前的时间，精确到毫秒，格式为：yyyy-MM-dd hh:mm:ss
     *
     * @return 为一个字符串
     */
    public static String getCurrentTime() {
        return format(new Date(), FORMAT_DATE_STR_SECOND);
    }

    /**
     * 得到昨天的日期，格式为：yyyy-MM-dd
     *
     * @return 为一个字符串
     */
    public static String getYesterDate() {
        return getDateFormat().format(beforeDate(Calendar.DAY_OF_MONTH, 1)).toString();
    }

    /**
     * 得到昨天的日期，格式为：yyyy-MM-dd
     *
     * @return 为一个字符串
     */
    public static String getTomarowDate() {
        return getDateFormat().format(afterDate(Calendar.DAY_OF_MONTH, 1)).toString();
    }

    /**
     * 将java时间转为sql时间
     *
     * @param date
     * @return
     */
    public static java.sql.Date convertUtilDateToSQLDate(Date date) {
        if (date == null)
            return null;
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        java.sql.Date jd = new java.sql.Date(cl.getTimeInMillis());
        return jd;
    }

    public static Timestamp convertUtilDateToTimestamp(Date date) {
        if (date == null)
            return null;
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        Timestamp t = new Timestamp(cl.getTimeInMillis());
        return t;
    }

    /**
     * 将sql时间转为java时间
     *
     * @param date
     * @return
     */
    public static Date convertSQLDateToUtilDate(java.sql.Date date) {
        if (date == null)
            return null;
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        Date jd = new Date(cl.getTimeInMillis());
        return jd;
    }

    public static Timestamp convertSQLDateToTimestamp(java.sql.Date date) {
        if (date == null)
            return null;
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        Timestamp t = new Timestamp(cl.getTimeInMillis());
        return t;
    }

    /**
     * 是否为闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        if ((year % 400) == 0)
            return true;
        else if ((year % 4) == 0) {
            return (year % 100) != 0;
        } else
            return false;
    }

    /**
     * 是否为当天
     *
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        return today.get(Calendar.YEAR) == day.get(Calendar.YEAR) && today.get(Calendar.MONTH) == day.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) == day.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前时间的时间戳
     *
     * @return
     */
    public static long getTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 取Java虚拟机系统时间, 返回当前时间戳
     *
     * @return Timestamp类型的时间
     */
    public static Timestamp getSysTimestamp() {
        return new Timestamp(getTimestamp());
    }

    /**
     * 取Java虚拟机系统时间, 返回当前Date
     *
     * @return Date类型的时间
     */
    public static Date getSysDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 取start日期所属月份的 最后一天
     *
     * @param start
     * @return
     */
    public static Date getNowMonthsEndDay(Date start) {
        String now = format(start, "yyyy-MM");
        now += "-01";
        start = parse(now);
        Date end = start;
        for (int i = 1; i <= 30; i++) {
            if (getDifferMonth(start, addDays(end, 1)) == 1) {
                break;
            } else {
                end = addDays(end, 1);
            }
        }
        return end;
    }

    /**
     * 当前日期是否在指定区间日期范围内-- 闭区间
     *
     * @param from
     *            Date类型
     * @param to
     *            Date类型
     * @return
     */
    public static boolean isBetweenDateByClosedInterval(Date from, Date to) {
        String fromStr = format(from, FORMAT_DATE_STR);
        String toStr = format(to, FORMAT_DATE_STR);
        return isBetweenDateByClosedInterval(fromStr, toStr);
    }

    /**
     * 当前日期是否在指定区间日期范围内-- 开区间
     *
     * @param from
     *            Date类型
     * @param to
     *            Date类型
     * @return
     */
    public static boolean isBetweenDateByOpenInterval(Date from, Date to) {
        String fromStr = format(from, FORMAT_DATE_STR);
        String toStr = format(to, FORMAT_DATE_STR);
        return isBetweenDateByOpenInterval(fromStr, toStr);
    }

    /**
     * 当前日期是否在指定区间日期范围内-- 闭区间
     *
     * @param sDate1
     *            String类型（格式为：yyyy-MM-dd）
     * @param date2
     *            String类型（格式为：yyyy-MM-dd）
     * @return
     */
    public static boolean isBetweenDateByClosedInterval(String sDate1, String date2) {
        String nowDate = DateUtil.format(new Date(), FORMAT_DATE_STR);
        if (java.sql.Date.valueOf(sDate1).before(java.sql.Date.valueOf(date2)) || java.sql.Date.valueOf(sDate1).equals(java.sql.Date.valueOf(date2))) {
            return (java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(sDate1)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(sDate1)))
                    && (java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(date2)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(date2)));
        } else {
            return (java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(date2)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(date2)))
                    && (java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(sDate1))) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(sDate1));
        }
    }

    /**
     * 当前日期是否在指定区间日期范围内-- 开区间
     *
     * @param sDate1
     *            String类型（格式为：yyyy-MM-dd）
     * @param date2
     *            String类型（格式为：yyyy-MM-dd）
     * @return
     */
    public static boolean isBetweenDateByOpenInterval(String sDate1, String date2) {
        String nowDate = DateUtil.format(new Date(), FORMAT_DATE_STR);
        if (java.sql.Date.valueOf(sDate1).before(java.sql.Date.valueOf(date2))) {
            return java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(sDate1)) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(date2));
        } else if (java.sql.Date.valueOf(sDate1).after(java.sql.Date.valueOf(date2))) {
            return java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(date2)) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(sDate1));
        } else {
            return false;
        }
    }

    /**
     * 获取指定时间段内的详细时间项，已yyyy-MM-dd的日期格式及“,”分隔日期项返回一个字符串
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getDateEntryStringsByDifferenceDate(String startDate, String endDate) {
        return getDateEntryStringsByDifferenceDate(parse(startDate), parse(endDate));
    }

    /**
     * 获取指定时间段内的详细时间项，已yyyy-MM-dd的日期格式及“,”分隔日期项返回一个字符串
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getDateEntryStringsByDifferenceDate(Date startDate, Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        String dateStrings = format(startDate);
        int diffDays = getDifferDay(startDate, endDate);
        if (diffDays == 0) {
            return dateStrings;
        }

        dateStrings += ",";
        for (int i = 0; i < diffDays; i++) {
            startCalendar.add(Calendar.DATE, 1);
            dateStrings += format(startCalendar.getTime()) + ",";
        }

        return dateStrings.substring(0, dateStrings.length() - 1);
    }

    /**
     * 获取指定时间段内的详细时间项，返回List<Date>集合
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<Date> getDateEntrysByDifferenceDate(String startDate, String endDate) {
        return getDateEntrysByDifferenceDate(parse(startDate), parse(endDate));
    }

    /**
     * 获取指定时间段内的详细时间项，返回List<Date>集合
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<Date> getDateEntrysByDifferenceDate(Date startDate, Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        List<Date> dateEntrys = new ArrayList<Date>();
        dateEntrys.add(startDate);

        int diffDays = getDifferDay(startDate, endDate);
        if (diffDays == 0) {
            return dateEntrys;
        }

        for (int i = 0; i < diffDays; i++) {
            startCalendar.add(Calendar.DATE, 1);
            dateEntrys.add(startCalendar.getTime());
        }

        return dateEntrys;
    }

    /**
     *
     * @Description : 判断指定日期是否在某个日期区间内（闭区间）
     * @author : xiang
     *
     * @param date
     *            指定日期
     * @param from
     *            开始时间
     * @param to
     *            结束时间
     * @return
     */
    public static boolean isBetween(Date date, Date from, Date to) {
        String dateStr = format(date, FORMAT_DATE_STR);
        String fromStr = format(from, FORMAT_DATE_STR);
        String toStr = format(to, FORMAT_DATE_STR);
        return isBetween(dateStr, fromStr, toStr);
    }

    /**
     *
     * @Description : 判断指定日期是否在某个日期区间内（闭区间）
     * @author : xiang
     *
     * @param dateStr
     *            指定日期
     * @param fromStr
     *            开始时间
     * @param toStr
     *            结束时间
     * @return
     */
    public static boolean isBetween(String dateStr, String fromStr, String toStr) {
        if (java.sql.Date.valueOf(fromStr).before(java.sql.Date.valueOf(toStr)) || java.sql.Date.valueOf(fromStr).equals(java.sql.Date.valueOf(toStr))) {
            return (java.sql.Date.valueOf(dateStr).after(java.sql.Date.valueOf(fromStr)) || java.sql.Date.valueOf(dateStr).equals(java.sql.Date.valueOf(fromStr)))
                    && (java.sql.Date.valueOf(dateStr).before(java.sql.Date.valueOf(toStr)) || java.sql.Date.valueOf(dateStr).equals(java.sql.Date.valueOf(toStr)));
        } else {
            return (java.sql.Date.valueOf(dateStr).after(java.sql.Date.valueOf(toStr)) || java.sql.Date.valueOf(dateStr).equals(java.sql.Date.valueOf(toStr)))
                    && (java.sql.Date.valueOf(dateStr).before(java.sql.Date.valueOf(fromStr))) || java.sql.Date.valueOf(dateStr).equals(java.sql.Date.valueOf(toStr));
        }
    }

    /**
     * 返回指定时间段内包含的星期数。1-7分别代表周一至周日
     *
     * @param start
     * @param end
     * @return
     * @author hai
     * @date 2014年12月30日下午5:39:21
     */
    public static String getWeeksBySpecailDateInterval(Date start, Date end) {
        String weeks = null;
        if (null != start && null != end) {
            Calendar c = Calendar.getInstance();
            if (start.equals(end)) {
                c.setTime(start);
                Integer week = c.get(Calendar.DAY_OF_WEEK) - 1;
                weeks = week.toString();
            } else {
                int diffDays = getDifferDay(start, end);
                if (diffDays >= 6) {
                    weeks = "1,2,3,4,5,6,7";
                } else {
                    c.setTime(start);
                    StringBuffer str = new StringBuffer();
                    do {
                        int week = c.get(Calendar.DAY_OF_WEEK) - 1;
                        if (week == 0) {
                            week = 7;
                        }
                        str.append(week).append(",");
                        c.add(Calendar.DAY_OF_MONTH, 1);
                    } while (c.getTime().before(end) || c.getTime().equals(end));
                    weeks = str.deleteCharAt(str.length() - 1).toString();
                    String[] arr = weeks.split(",");
                    Arrays.sort(arr);
                    weeks = StringUtils.join(arr, ",");
                }
            }
        }
        return weeks;
    }

    public static void main(String[] args) {
        System.out.println(getSysTimestamp());
        System.out.println(getDifferMinute("2014-04-16 17:00", "2014-04-16 18:30"));
    }

}
