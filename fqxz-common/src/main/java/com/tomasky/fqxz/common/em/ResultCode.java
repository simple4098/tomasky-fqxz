package com.tomasky.fqxz.common.em;

/**
 * 返回状态码
 * 定义公用的返回状态码，具体应用业务如需自行定义
 * Created by LZQ on 2016/10/12.
 */
public enum ResultCode {
    SUCCESS("200", "成功"),
    PARAM_ERROR("400", "缺少必要参数或参数无效"),
    TIME_OUT("401", "请求超时"),
    SIFNATURE_ERROR("402", "签名有误"),
    LOGIN_ERROR("403", "用户信息有误，请重新登录"),

    COMMEN_BUSINESS_EXCEPTION("500", "业务异常"),
    COMMON_SYSTEM_RPC_EXCEPTION("501", "系统RPC异常"),
    COMMEN_SYSTEM_EXCEPTION("502", "系统错误"),
    OTHER_EXCEPTION("503", "其他错误");

    /**
     * 状态码
     */
    private String status;

    /**
     * 状态码描述
     */
    private String message;

    private ResultCode(String status, String message) {
        this.message = message;
        this.status = status;
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
}
