package com.tomasky.bill.vo.count;

/**
 * 支付流水总览
 * Created by X on 2016/9/13.
 */
public class RecordCountVo {

    /** 收入情况 */
    private PayRecordCount income;
    /** 支出情况 */
    private PayRecordCount payout;

    public PayRecordCount getIncome() {
        return income;
    }

    public void setIncome(PayRecordCount income) {
        this.income = income;
    }

    public PayRecordCount getPayout() {
        return payout;
    }

    public void setPayout(PayRecordCount payout) {
        this.payout = payout;
    }
}
