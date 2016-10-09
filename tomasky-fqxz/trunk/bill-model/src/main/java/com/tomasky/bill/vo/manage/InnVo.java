package com.tomasky.bill.vo.manage;

import java.math.BigDecimal;

/**
 * Created by X on 2016/9/14.
 */
public class InnVo {
    /** PMS客栈ID */
    private Integer id;
    /** PMS客栈名称 */
    private String name;
    /** 目的地ID */
    private Integer regionId;
    /** 目的地名称 */
    private Integer regionName;
    /** 代收手续费率 */
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

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getRegionName() {
        return regionName;
    }

    public void setRegionName(Integer regionName) {
        this.regionName = regionName;
    }

    public BigDecimal getPoundageRatio() {
        return poundageRatio;
    }

    public void setPoundageRatio(BigDecimal poundageRatio) {
        this.poundageRatio = poundageRatio;
    }
}
