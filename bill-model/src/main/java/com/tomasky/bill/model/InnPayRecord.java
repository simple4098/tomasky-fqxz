package com.tomasky.bill.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by X on 2016/9/7.
 */
@Entity(name = "tomato_pay_record")
public class InnPayRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 订单code
     */
    private String orderCode;

    /**
     * 支付产品code
     */
    private String productCode;

    /**
     * 支付产品名称
     */
    private String productName;

    /**
     * 支付类型（1：支付，2：退款）
     */
    private String payType;

    /**
     * 支付方式（1：支付宝，2：微信支付，3：银联，4：其它）
     */
    private String payMode;

    /**
     * 支付金额
     */
    private Double payPrice;

    /**
     * TOMATO PAY_RECORD 交易状态.
     * <p/>
     * <pre>
     * UNINITIALIZE: -1 - 未初始化，业务状态，非支付状态
     * PAYERROR: 0 - 支付失败(其他原因，如银行返回失败)
     * SUCCESS: 1 - 支付成功
     * CLOSED: 2 - 已关闭
     * REFUND: 3 - 转入退款
     * NOTPAY: 4 - 未支付
     * REVOKED: 5 - 已撤销
     * USERPAYING: 6- 用户支付中
     * NOPAY: 7 - 未支付(输入密码或确认支付超时)
     * CANCEL: 8 - [自定义]-取消
     * </pre>
     */
    private String payStatus;

    /**
     * 支付人
     */
    private String payUser;

    /**
     * 支付时间
     */
    private Date payAt;

    /**
     * 交易流水号
     */
    private String tradeNo;

    /**
     * 所属客栈
     */
    private Integer innId;

    /**
     * 是否结算（0:未结算,1:已结算）
     */
    private int isBalance;

    /**
     * 主订单号：当一笔支付有多个订单时用于标记分拆记录支付记录的主订单标识
     */
    private String mainOrderNo;

    /**
     * 抵扣类型 （1：代金券，2：折扣券，3：优惠券，4：红包，5：其它）
     */
    private String deductType;

    /**
     * 抵扣价格
     */
    private Double deductPrice;

    /**
     * 关于此笔交易的扼要描述
     */
    private String payDesc;

    /**
     * 支付来源（1：pms，2：xz，3：oms，4：bms，5：其它）
     */
    private String origin;

    /**
     * 收益类型（1：收入，2：分佣，3：代收[待平账、转出]，4：其它）
     */
    private String receiptType = "3";

    /**
     * 手续费率
     */
    private Double poundageRatio;

    /**
     * 佣金费率
     */
    private Double commissionRatio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public Double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayUser() {
        return payUser;
    }

    public void setPayUser(String payUser) {
        this.payUser = payUser;
    }

    public Date getPayAt() {
        return payAt;
    }

    public void setPayAt(Date payAt) {
        this.payAt = payAt;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }

    public int getIsBalance() {
        return isBalance;
    }

    public void setIsBalance(int isBalance) {
        this.isBalance = isBalance;
    }

    public String getMainOrderNo() {
        return mainOrderNo;
    }

    public void setMainOrderNo(String mainOrderNo) {
        this.mainOrderNo = mainOrderNo;
    }

    public String getDeductType() {
        return deductType;
    }

    public void setDeductType(String deductType) {
        this.deductType = deductType;
    }

    public Double getDeductPrice() {
        return deductPrice;
    }

    public void setDeductPrice(Double deductPrice) {
        this.deductPrice = deductPrice;
    }

    public String getPayDesc() {
        return payDesc;
    }

    public void setPayDesc(String payDesc) {
        this.payDesc = payDesc;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public Double getPoundageRatio() {
        return poundageRatio;
    }

    public void setPoundageRatio(Double poundageRatio) {
        this.poundageRatio = poundageRatio;
    }

    public Double getCommissionRatio() {
        return commissionRatio;
    }

    public void setCommissionRatio(Double commissionRatio) {
        this.commissionRatio = commissionRatio;
    }
}
