package com.fastadmin.common.model;

public class ApiEntityResponse<T> extends ApiResponse {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
