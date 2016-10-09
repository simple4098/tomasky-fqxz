package com.tomasky.fqxz.bo.param.baseInfo;

import com.tomasky.fqxz.bo.param.CommParam;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by X on 2016/9/8.
 */
public class XzBaseInfoBo extends CommParam {

    private Integer payType;

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
