package com.tomasky.bill.vo.bill;

import java.math.BigDecimal;

/**
 * 联盟结算单VO
 * Created by X on 2016/9/12.
 */
public class UnionStatementVo {

    /** 联盟ID */
    private Integer id;
    /** 联盟名称 */
    private String name;
    /** 客栈数量 */
    private Integer innNum;
    /** 订单数量 */
    private Integer orderNum;
    /** 总金额 */
    private BigDecimal totalFee;
    /** 向代销结算的比例 */
    private BigDecimal commissionRatio;
    /** 手续费比例 */
    private BigDecimal poundageRatio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInnNum() {
        return innNum;
    }

    public void setInnNum(Integer innNum) {
        this.innNum = innNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getCommissionRatio() {
        return commissionRatio;
    }

    public void setCommissionRatio(BigDecimal commissionRatio) {
        this.commissionRatio = commissionRatio;
    }

    public BigDecimal getPoundageRatio() {
        return poundageRatio;
    }

    public void setPoundageRatio(BigDecimal poundageRatio) {
        this.poundageRatio = poundageRatio;
    }
}
