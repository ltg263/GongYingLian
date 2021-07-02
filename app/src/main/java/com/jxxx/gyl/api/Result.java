package com.jxxx.gyl.api;

import com.blankj.utilcode.util.ToastUtils;

/**
 * 公共返回格式
 *
 * @param <T>
 */
public class Result<T> {


    private int code;
    private String error;
    private String message;
    private boolean success;
    private T data;

    public int getCode() {
        if(code!=200 || !isSuccess()){
            ToastUtils.showLong(message);
        }
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
