package com.tomasky.bill.web;

import com.tomasky.bill.bo.param.bill.BalanceBo;
import com.tomasky.bill.bo.param.bill.PayRecordBo;
import com.tomasky.bill.bo.param.bill.UnionBo;
import com.tomasky.bill.common.core.orm.Page;
import com.tomasky.bill.service.InnPayRecordService;
import com.tomasky.bill.vo.bill.InnInfoVo;
import com.tomasky.bill.vo.bill.PayRecordVo;
import com.tomasky.bill.vo.bill.UnionStatementVo;
import com.tomasky.bill.vo.count.CountVo;
import com.tomasky.bill.vo.count.RecordCountVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by X on 2016/9/12.
 */
@RestController
@RequestMapping("/bill")
public class StatementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatementController.class);

    @Autowired
    protected InnPayRecordService innPayRecordService;

    @RequestMapping("/getSettleRecords")
    @ResponseBody
    public Map<String, Object> getSettleRecords(PayRecordBo param) {
        Map<String, Object> result = BaseController.new200Map();
        Page<InnInfoVo> page = innPayRecordService.getPageInn(param);
        result.put("page", page);
        return result;
    }

    @RequestMapping("/getSettleRecordsCount")
    @ResponseBody
    public Map<String, Object> getSettleRecordsCount(PayRecordBo param) {
        Map<String, Object> result = BaseController.new200Map();
        try{
            CountVo count = innPayRecordService.getSettleRecordsCount(param);
            result.put("count", count);
        } catch (Exception e) {
            LOGGER.error("获取番茄代收统计信息出错！", e);
            return BaseController.new500Map("获取番茄代收统计信息出错！");
        }
        return result;
    }

    @RequestMapping("/balanceOrders")
    @ResponseBody
    public Map<String, Object> balanceOrders(BalanceBo param) {
        Map<String, Object> result = BaseController.new200Map();
        Integer num = innPayRecordService.balanceOrders(param);
        result.put("num", num);
        return result;
    }

    @RequestMapping("/getPayRecords")
    @ResponseBody
    public Map<String, Object> getPayRecords(PayRecordBo param) {
        Map<String, Object> result = BaseController.new200Map();
        Page<PayRecordVo> page = innPayRecordService.getPageRecord(param);
        result.put("page", page);
        return result;
    }

    @RequestMapping("/getPayRecordsCount")
    @ResponseBody
    public Map<String, Object> getPayRecordsCount(PayRecordBo param) {
        Map<String, Object> result = BaseController.new200Map();
        RecordCountVo count = innPayRecordService.getPayRecordsCount(param);
        result.put("count", count);
        return result;
    }

    @RequestMapping("/getUnionStatements")
    @ResponseBody
    public Map<String, Object> getUnionStatements(UnionBo param) {
        Map<String, Object> result = BaseController.new200Map();
        Page<UnionStatementVo> page = innPayRecordService.getUnionStatements(param);
        result.put("page", page);
        return result;
    }

    @RequestMapping("/getOrderStatements")
    @ResponseBody
    public Map<String, Object> getOrderStatements(@Valid UnionBo param, BindingResult bindingResult) {
        Map<String, Object> result = BaseController.new200Map();
        if(bindingResult.hasErrors()){
            return BaseController.new400Map(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        Page<UnionStatementVo> page = innPayRecordService.getOrderStatements(param);
        result.put("page", page);
        return result;
    }
}
