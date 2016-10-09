package com.tomasky.bill.mapper;

import com.tomasky.bill.bo.param.bill.BalanceBo;
import com.tomasky.bill.bo.param.bill.PayRecordBo;
import com.tomasky.bill.bo.param.bill.UnionBo;
import com.tomasky.bill.vo.bill.InnInfoVo;
import com.tomasky.bill.vo.bill.MainOrderVo;
import com.tomasky.bill.vo.bill.PayRecordVo;
import com.tomasky.bill.vo.bill.UnionStatementVo;
import com.tomasky.bill.vo.count.CountVo;
import com.tomasky.bill.vo.count.PayRecordCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * Created by X on 2016/9/7.
 */
@Mapper
public interface RecordMapper {

    List<PayRecordVo> getPayRecords(PayRecordBo param);

    List<PayRecordVo> getSettlementRecords(PayRecordBo param);

    List<InnInfoVo> getSettlementInns(PayRecordBo param);

    List<UnionStatementVo> getUnionStatements(UnionBo param);

    List<MainOrderVo> getOrderStatements(UnionBo param);

    CountVo countSettlementRecords(PayRecordBo param);

    PayRecordCount countPayRecords(PayRecordBo param);

    Integer balanceOrders(BalanceBo param);

    Long getOrderStatementsCount(UnionBo param);

    Long getSettlementRecordsCount(PayRecordBo param);

    Long getSettlementInnsCount(PayRecordBo param);

    Long getPayRecordsCount(PayRecordBo param);

}
