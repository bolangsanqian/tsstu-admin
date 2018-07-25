package com.fastadmin.common.util;

import com.fastadmin.common.model.Result;

public class ResultUtils {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(Result.SUCCESS);
        result.setMsg("操作成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String errorCode, String msg) {
        Result result = new Result();
        result.setErrorCode(errorCode);
        result.setCode(Result.ERROR);
        result.setMsg(msg);
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(Result.ERROR);
        result.setErrorCode("00000");
        result.setMsg(msg);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(Result.ERROR);
        result.setErrorCode("00000");
        result.setMsg("操作失败");
        return result;
    }
}