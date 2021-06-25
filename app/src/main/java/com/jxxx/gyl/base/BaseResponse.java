package com.jxxx.gyl.base;

/**
 * 请求返回基类
 */
public class BaseResponse<T> {

    /**
     * data : {"avatar":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLBQKY6ngricibhX28nej0u7TD7hrXxdSosia6SpXrJ38QN7vSicR7X7FMfAooqWO96lXo4UyeQhicdXQlcJX2GGdDnTxWZTYkhfkBk0/132","nickName":"","tokenId":"5b429427-0782-4717-a370-838a8d82c781","userNo":"13918121225"}
     * status : 0
     */

    private T data;
    private int status;
    private String mesg;
    private String code;
    private String sub_code;
    private String sub_mesg;

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getSub_mesg() {
        return sub_mesg;
    }

    public void setSub_mesg(String sub_mesg) {
        this.sub_mesg = sub_mesg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }
}
