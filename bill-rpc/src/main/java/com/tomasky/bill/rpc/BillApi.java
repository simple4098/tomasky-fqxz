package com.tomasky.bill.rpc;

import com.tomasky.bill.vo.bill.PayRecordVo;
import com.tomasky.bill.vo.count.CountVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by X on 2016/9/14.
 */
public interface BillApi {
    BigDecimal getPoundageRatio(Long innId);

    List<PayRecordVo> getPayRecordVos(Integer innId, int pageNo, Integer balance, Date from, Date to, String timeType, String productCode);

    CountVo getPayRecordCount(Integer innId, int pageNo, Integer balance, Date from, Date to, String timeType, String productCode);
}
