package com.tomasky.fqxz.common.utils;

import com.tomasky.fqxz.common.utils.string.RandomUtil;

import java.util.Date;

/**
 * @author simple
 * @data 2016/10/11
 */
public class OrderUtil {

    private OrderUtil(){}

    public static String obtOrderNo(){
        String orderNo = DateUtil.format(new Date(), DateUtil.FORMAT_DATE_STR_LONG);
        long randomNumber = RandomUtil.getRandomNumberBySpecialLength(4);
        return orderNo+randomNumber;
    }

    public static void main(String[] args) {
        System.out.println(obtOrderNo());
    }
}
