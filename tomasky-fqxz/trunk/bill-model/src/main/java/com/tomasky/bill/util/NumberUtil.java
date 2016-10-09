package com.tomasky.bill.util;


import com.tomasky.bill.config.Constants;

import java.math.BigDecimal;

/**
 * Created by X on 2016/9/9.
 */
public class NumberUtil {

    public static BigDecimal filter(BigDecimal num){
        if(num != null){
            num = num.setScale(Constants.DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
        }
        return num;
    }


}
