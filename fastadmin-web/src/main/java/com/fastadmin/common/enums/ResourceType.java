package com.fastadmin.common.enums;

import lombok.Data;

public enum ResourceType {
    menu(0, "菜单"),
    page(1, "页面"),
    other(2, "其他资源");

    private int value;

    private String name;

    ResourceType(int value, String name) {
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
