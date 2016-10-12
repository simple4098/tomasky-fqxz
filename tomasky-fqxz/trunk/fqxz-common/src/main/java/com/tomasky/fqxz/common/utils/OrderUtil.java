package com.tomasky.fqxz.common.utils;

import com.tomasky.fqxz.common.utils.string.RandomUtil;
import com.tomasky.msp.client.service.impl.MessageManageServiceImpl;
import com.tomasky.msp.client.support.MessageBuilder;
import com.tomasky.msp.enumeration.SmsChannel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public static void sendMsg(String phone, String s) {
        List<String> receivers = new ArrayList<>();
        receivers.add(phone);
        new MessageManageServiceImpl().sendMessage(MessageBuilder.buildSmsMessage(receivers, SmsChannel.SEND_TYPE_AUTO, s));
    }
}
