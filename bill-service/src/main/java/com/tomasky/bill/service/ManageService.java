package com.tomasky.bill.service;

import com.tomasky.bill.bo.param.bill.PayRecordBo;
import com.tomasky.bill.bo.param.manage.InnBo;
import com.tomasky.bill.common.cons.Constants;
import com.tomasky.bill.common.core.orm.Page;
import com.tomasky.bill.dao.InnConfigRepo;
import com.tomasky.bill.mapper.ManageMapper;
import com.tomasky.bill.mapper.RecordMapper;
import com.tomasky.bill.model.InnConfig;
import com.tomasky.bill.rpc.BillApi;
import com.tomasky.bill.vo.bill.PayRecordVo;
import com.tomasky.bill.vo.count.CountVo;
import com.tomasky.bill.vo.manage.InnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by X on 2016/9/14.
 */
@Service
public class ManageService implements BillApi {

    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private ManageMapper manageMapper;
    @Autowired
    private InnConfigRepo innConfigRepo;

    /**
     * 根据条件查询客栈配置信息并分页
     * @param param
     * @return
     */
    public Page<InnVo> getInnInfos(InnBo param) {
        param.setPageSize(Constants.INN_INFO_PAGE_SIZE);
        Page<InnVo> page = new Page<>(param.getPageSize(), param.getPageNo());
        page.setTotalCount(manageMapper.getInnInfosCount(param));
        if(page.getTotalCount() == 0){  //总记录数为0  无需查询详情
            return page;
        }
        param.setPage(true);
        page.setResult(manageMapper.getInnInfos(param));
        return page;
    }

    public void saveOrUpdate(InnConfig config) {
        Date now = new Date();
        if(config.getId() == null){
            config.setCreatedAt(now);
            config.setUpdatedAt(now);
        }else{
            config.setUpdatedAt(now);
        }
        innConfigRepo.save(config);
    }

    /**
     * 保存或新增 客栈配置信息（番茄代收手续费率）
     * @param innId
     * @param poundageRatio
     */
    public void setPoundage(Long innId, BigDecimal poundageRatio) {
        InnConfig config = innConfigRepo.findByInnId(innId);
        if(config == null){
            config = new InnConfig();
            config.setInnId(innId);
        }
        config.setPoundageRatio(poundageRatio);
        saveOrUpdate(config);
    }

    @Override
    public BigDecimal getPoundageRatio(Long innId) {
        InnConfig config = innConfigRepo.findByInnId(innId);
        if(config == null){
            return null;
        }
        return config.getPoundageRatio();
    }

    @Override
    public List<PayRecordVo> getPayRecordVos(Integer innId, int pageNo, Integer balance, Date from, Date to,
                                             String timeType, String productCode) {
        PayRecordBo param = getPayRecordBo(innId, pageNo, balance, from, to, timeType, productCode);
        return recordMapper.getPayRecords(param);
    }

    @Override
    public CountVo getPayRecordCount(Integer innId, int pageNo, Integer balance, Date from, Date to,
                                     String timeType, String productCode) {
        PayRecordBo param = getPayRecordBo(innId, pageNo, balance, from, to, timeType, productCode);
        return recordMapper.countSettlementRecords(param);
    }

    private PayRecordBo getPayRecordBo(Integer innId, int pageNo, Integer balance, Date from, Date to,
                                       String timeType, String productCode) {
        PayRecordBo param = new PayRecordBo();
        param.setInnId(innId);
        param.setPageNo(pageNo);
        param.setIsBalance(balance);
        param.setTimeType(timeType);
        param.setProductCode(productCode);
        param.setFrom(from);
        param.setTo(to);
        param.setReceiptType(Constants.PAY_RECEIPT_COLLECTION);
        param.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        param.setPayType(Constants.PAY_TYPE_INCOME);
        param.setStatus(Constants.IS_BALANCE_NO);
        return param;
    }
}
