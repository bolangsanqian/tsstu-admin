package com.fastadmin.common.enums;

import lombok.Data;

public enum Status {
    enable(1, "启用"),
    disable(0, "停用");

    private int value;

    private String name;

    Status(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
