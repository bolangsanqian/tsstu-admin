package com.fastadmin.common.util;

import java.util.List;

public class CommonUtils {

    public static boolean isNullOrEmpty(String str) {
        if (null == str || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(List list) {
        if (null == list || list.size() <= 0) {
            return true;
        }
        return false;
    }
}
