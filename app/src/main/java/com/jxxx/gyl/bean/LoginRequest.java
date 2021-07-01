package com.jxxx.gyl.bean;


import com.jxxx.gyl.base.BaseResponse;

/**
 * Create by Sxl on 2020/11/20.
 */
public class LoginRequest extends BaseResponse {
//    {
//        "captchaKey": "1234-1234-1234-1234",
//            "clientType": "APP",
//            "password": "123456",
//            "phone": "18058525327",
//            "pictureVerificationCode": "1234"

//    smsVerificationCode
//    }
    private String captchaKey;
    private String clientType = "Android-APP";
    private String password;
    private String newPassword;
    private String phone;
    private String pictureVerificationCode;
    private String smsVerificationCode;
    private String scene;//场景枚举 1注册 2登录 3找回密码

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getScene() {
        return scene;
    }

    public void setSmsVerificationCode(String smsVerificationCode) {
        this.smsVerificationCode = smsVerificationCode;
    }

    public String getSmsVerificationCode() {
        return smsVerificationCode;
    }

    public String getCaptchaKey() {
        return captchaKey;
    }

    public void setCaptchaKey(String captchaKey) {
        this.captchaKey = captchaKey;
    }

    public String getClientType() {
        return clientType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPictureVerificationCode() {
        return pictureVerificationCode;
    }

    public void setPictureVerificationCode(String pictureVerificationCode) {
        this.pictureVerificationCode = pictureVerificationCode;
    }
}
