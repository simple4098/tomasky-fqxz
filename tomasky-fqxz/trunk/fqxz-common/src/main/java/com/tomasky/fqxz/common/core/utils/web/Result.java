package com.tomasky.fqxz.common.core.utils.web;

import com.tomasky.fqxz.common.em.ResultCode;

import java.io.Serializable;

/**
 * AJAX 统一 返回标准
 * Created by LZQ on 2016/10/12.
 */
public class Result implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 结果状态码
     */
    private String status;

    /**
     * 成功标志
     */
    protected boolean success;

    /**
     * 业务处理返回数据
     */
    protected Object data;

    /**
     * 返回消息
     */
    protected String message;

    public Result() {

    }

    public Result(ResultCode resultCode) {
        this.status = resultCode.getStatus();
        this.message = resultCode.getMessage();
        this.success = true;
    }

    public Result(ResultCode resultCode, boolean isSuccess) {
        this.status = resultCode.getStatus();
        this.message = resultCode.getMessage();
        this.success = isSuccess;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean isSuccess) {
        this.success = isSuccess;
    }

}
