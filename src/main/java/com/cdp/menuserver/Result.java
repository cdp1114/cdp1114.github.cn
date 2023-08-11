package com.cdp.menuserver;

import lombok.Getter;

/**
 * @author cdp
 * @date 2023-8-11 10:24
 */
@Getter
public class Result<T> {

    private final Integer code;

    private final String msg;

    private final T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> result(Integer code, String msg, T data) {
        return new Result<T>(code, msg, data);
    }

    public static <T> Result<T> success(Integer code, String msg, T data) {
        return result(code, msg, data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return success(200, msg, data);
    }

    public static <T> Result<T> success(T data) {
        return success(200, "请求成功", data);
    }

    public static <T> Result<T> success() {
        return success(200, "请求成功", null);
    }

    public static <T> Result<T> error() {
        return error(500, "请求失败", null);
    }

    public static <T> Result<T> error(T data) {
        return error(500, "请求失败", data);
    }

    public static <T> Result<T> error(String msg, T data) {
        return error(500, msg, data);
    }

    public static <T> Result<T> error(Integer code, String msg, T data) {
        return result(code, msg, data);
    }
}
