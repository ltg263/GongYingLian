package com.jxxx.gyl.api;

/**
 * 公共返回格式
 *
 * @param <T>
 */
public class Result<T> {


    private int status;
    private String error;

    private T data;

    public String getError() {
        return error == null ? "" : error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
