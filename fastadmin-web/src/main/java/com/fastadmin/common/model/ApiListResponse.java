package com.fastadmin.common.model;

import java.util.List;

public class ApiListResponse<T> extends ApiResponse {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
