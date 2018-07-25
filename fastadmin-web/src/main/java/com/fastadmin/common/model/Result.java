package com.fastadmin.common.model;

public class Result<T> {

    // 消息
    private String msg;

    // 数据对象
    private T data;

    // 错误码
    private String errorCode;

    // 返回码, 1：成功，-1：失败
    private int code;

    private boolean ok = false;

    // 成功
    public static final int SUCCESS = 1;

    // 失败
    public static final int ERROR = -1;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        if (SUCCESS == this.code) {
            this.ok = true;
        }
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean ok() {
        ok = (SUCCESS == this.code);
        return ok;
    }

    public boolean isOk() {
        return ok();
    }
}