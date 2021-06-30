package com.jxxx.gyl.bean;

/**
 * author : LiuJie
 * date   : 2020/6/1510:37
 */
public class ParamData {

    private String param;
    /**
     * package : Sign=WXPay
     * appid : wx68c7d6a5fd1bd95a
     * wxorderno : 200623090455001364
     * sign : DCADD77B32E543C5EA9B8EB6A41C5EEE
     * partnerid : 1517475341
     * prepayid : wx23090456478575976768f2071774904900
     * noncestr : BcuhZ0Hrv9OKwKwmwSMXJg6fLWuCtKpu
     * timestamp : 1592874296
     */


    private String packages = "Sign=WXPay";
    private String appid;
    private String wxorderno;
    private String sign;
    private String partnerid;
    private String prepayid;
    private String noncestr;
    private String timestamp;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getPackageX() {
        return packages;
    }

    public void setPackageX(String packageX) {
        this.packages = packageX;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getWxorderno() {
        return wxorderno;
    }

    public void setWxorderno(String wxorderno) {
        this.wxorderno = wxorderno;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
