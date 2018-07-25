package com.fastadmin.common.model;

public class ApiResponse {
    // 消息
    private String msg;

    // 错误码
    private String errorCode;

    // 返回码, 1：成功，-1：失败
    private int code;

    // 成功
    public static final int SUCCESS = 1;

    // 失败
    public static final int ERROR = -1;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean ok() {
        return SUCCESS == this.code;
    }
}
