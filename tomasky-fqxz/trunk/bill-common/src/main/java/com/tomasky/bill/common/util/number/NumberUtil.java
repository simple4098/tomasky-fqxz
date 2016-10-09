package com.tomasky.bill.common.util.number;

import com.tomasky.bill.common.cons.Constants;

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
