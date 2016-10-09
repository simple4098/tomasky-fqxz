package com.tomasky.bill.service;

import com.google.common.collect.Maps;
import com.tomasky.bill.bo.param.CommParam;
import com.tomasky.bill.bo.param.bill.BalanceBo;
import com.tomasky.bill.bo.param.bill.PayRecordBo;
import com.tomasky.bill.bo.param.bill.UnionBo;
import com.tomasky.bill.common.cons.Constants;
import com.tomasky.bill.common.core.orm.Page;
import com.tomasky.bill.common.util.DateUtil;
import com.tomasky.bill.mapper.RecordMapper;
import com.tomasky.bill.vo.bill.InnInfoVo;
import com.tomasky.bill.vo.bill.PayRecordVo;
import com.tomasky.bill.vo.bill.UnionStatementVo;
import com.tomasky.bill.vo.count.CountVo;
import com.tomasky.bill.vo.count.RecordCountVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by X on 2016/9/7.
 */
@Service
public class InnPayRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InnPayRecordService.class);

    @Autowired
    private RecordMapper recordMapper;

    /**
     * 按条件查询支付流水记录
     * @param param
     * @return
     */
    public List<PayRecordVo> findList(PayRecordBo param){
        return recordMapper.getPayRecords(param);
    }

    /**
     * 按条件查询支付流水记录并分页
     * @param param
     * @return
     */
    public Page<PayRecordVo> getPageRecord(PayRecordBo param) {
        commDealDate(param);
        Page<PayRecordVo> page = new Page<>(param.getPageSize(), param.getPageNo());
        LOGGER.debug("查询开始*********************************************");
        page.setTotalCount(recordMapper.getPayRecordsCount(param));
        if(page.getTotalCount() == 0){  //总数为0 无需继续查询详情
            return page;
        }
        param.setPage(true);
        page.setResult(findList(param));
        LOGGER.debug("查询结束*********************************************");
        return page;
    }

    /**
     * 按条件查询番茄代收对账列表并分页
     * @param param
     * @return
     */
    public Page<InnInfoVo> getPageInn(PayRecordBo param) {
        Page<InnInfoVo> page = new Page<>(param.getPageSize(), param.getPageNo());
        param.setReceiptType(Constants.PAY_RECEIPT_COLLECTION);
        param.setPageSize(Constants.INN_INFO_PAGE_SIZE);
        param.setPayType(Constants.PAY_TYPE_INCOME);
        param.setStatus(Constants.IS_BALANCE_NO);
        page.setTotalCount(recordMapper.getSettlementInnsCount(param));
        if(page.getTotalCount() == 0){  //总数为0 无需继续查询详情
            return page;
        }
        param.setPage(true);
        List<InnInfoVo> list = recordMapper.getSettlementInns(param);
        getPayRecords(list, param);
        page.setResult(list);
        return page;
    }

    private void getPayRecords(List<InnInfoVo> list, PayRecordBo param) {
        PayRecordBo payParam = new PayRecordBo();
        payParam.setFrom(param.getFrom());
        payParam.setTo(param.getTo());
        payParam.setInnId(param.getInnId());
        payParam.setReceiptType(param.getReceiptType());
        payParam.setPayType(param.getPayType());
        payParam.setStatus(param.getStatus());
        payParam.setOrderNo(param.getOrderNo());
        payParam.setTradeNo(param.getTradeNo());
        payParam.setInnName(param.getInnName());
        payParam.setIsBalance(param.getIsBalance());
        payParam.setPageNo(Constants.DO_NOT_PAGE);
        Map<Integer, InnInfoVo> map = Maps.newHashMap();
        for (InnInfoVo inn: list) {
            payParam.getInnIds().add(inn.getId());
            map.put(inn.getId(), inn);
        }
        List<PayRecordVo> payRecords = recordMapper.getSettlementRecords(payParam);
        for (PayRecordVo r: payRecords) {
            InnInfoVo inn = map.get(r.getPmsInnId());
            inn.getPayRecords().add(r);
        }
    }

    /**
     * 根据条件查询联盟结算单列表（不分页）
     * @param param
     * @return
     */
    public Page<UnionStatementVo> getUnionStatements(UnionBo param) {
        commDealDate(param);
        param.setPayStatus(Constants.PAY_STATUS_PAID);
        Page<UnionStatementVo> page = new Page<>();
        param.setPageNo(Constants.DO_NOT_PAGE);
        param.setUnionType(Constants.UNION_TYPE_LARGE);
        page.setResult(recordMapper.getUnionStatements(param));
        return page;
    }

    /**
     * 根据条件查询分销对账单详情并分页
     * @param param
     * @return
     */
    public Page<UnionStatementVo> getOrderStatements(UnionBo param) {
        commDealDate(param);
        param.setPayStatus(Constants.PAY_STATUS_PAID);
        Page<UnionStatementVo> page = new Page<>(param.getPageSize(), param.getPageNo());
        page.setTotalCount(recordMapper.getOrderStatementsCount(param));
        if(page.getTotalCount() == 0){  //总数为0 无需继续查询详情
            return page;
        }
        param.setPage(true);
        page.setResult(recordMapper.getOrderStatements(param));
        return page;
    }

    /**
     * 查询番茄代收对账总体信息
     * @param param
     * @return
     */
    public CountVo getSettleRecordsCount(PayRecordBo param) {
        commDealDate(param);
        param.setReceiptType(Constants.PAY_RECEIPT_COLLECTION);
        param.setPayType(Constants.PAY_TYPE_INCOME);
        param.setStatus(Constants.IS_BALANCE_NO);
        return  recordMapper.countSettlementRecords(param);
    }

    private void commDealDate(CommParam param){
        if(param.getFrom() == null){
            param.setFrom(new Date());
        }
        if(param.getTo() == null){
            param.setTo(new Date());
        }
        if(DateUtil.getDifferMilliSec(param.getTo(), param.getFrom()) > 0){
            Date tmp = param.getFrom();
            param.setFrom(param.getTo());
            param.setTo(tmp);
        }
        String to = DateUtil.format(param.getTo());
        param.setTo(DateUtil.parse(to + " 23:59:59", DateUtil.FORMAT_DATE_STR_SECOND));
    }

    /**
     * 查询支付流水总览
     * @param param
     * @return
     */
    public RecordCountVo getPayRecordsCount(PayRecordBo param) {
        commDealDate(param);
        RecordCountVo count = new RecordCountVo();
        param.setPayType(Constants.PAY_TYPE_INCOME);
        count.setIncome(recordMapper.countPayRecords(param));
        param.setPayType(Constants.PAY_TYPE_PAYOUT);
        count.setPayout(recordMapper.countPayRecords(param));
        return count;
    }

    /**
     * 根据条件平账（代收）
     * @param param
     * @return
     */
    public Integer balanceOrders(BalanceBo param) {
        param.setReceiptType(Constants.PAY_RECEIPT_COLLECTION);
        param.setIsBalance(Constants.IS_BALANCE_NO);
        Integer updatedNum = recordMapper.balanceOrders(param);
        return updatedNum;
    }
}
