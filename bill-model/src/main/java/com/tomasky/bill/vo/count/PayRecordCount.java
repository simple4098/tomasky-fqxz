package com.tomasky.bill.vo.count;


import com.tomasky.bill.util.NumberUtil;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by X on 2016/9/13.
 */
public class PayRecordCount implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer totalNum;

    private BigDecimal totalAmount;

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        totalAmount = NumberUtil.filter(totalAmount);
        this.totalAmount = totalAmount;
    }
}
