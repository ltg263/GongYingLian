package com.jxxx.gyl.bean;

import java.io.Serializable;

public class DedicatedReceiptInfoBean implements Serializable {
    /**
     * account : 1
     * address : 1
     * bank : 1
     * email : 1
     * phone : 1
     * ratepayerNo : 1
     * receiptAmount : 1
     * receiptContent : 1
     * receiptTitle : 1
     * type : 1
     */

    private String account;
    private String address;
    private String bank;
    private String email;
    private String phone;
    private String ratepayerNo;
    private String receiptAmount;
    private String receiptContent;
    private String receiptTitle;
    private String type;
    private String bankPhone;
    private String contact;
    private String detailsAddress;
    private String region;

    public DedicatedReceiptInfoBean() {
    }
    //普通发票
    public DedicatedReceiptInfoBean(String account, String address, String bank, String email, String phone, String ratepayerNo, String receiptAmount, String receiptContent, String receiptTitle, String type) {
        this.account = account;
        this.address = address;
        this.bank = bank;
        this.email = email;
        this.phone = phone;
        this.ratepayerNo = ratepayerNo;
        this.receiptAmount = receiptAmount;
        this.receiptContent = receiptContent;
        this.receiptTitle = receiptTitle;
        this.type = type;
    }
    //专用发票
    public DedicatedReceiptInfoBean(String account, String address, String bank, String phone, String ratepayerNo, String receiptAmount, String receiptTitle, String bankPhone, String contact, String detailsAddress, String region) {
        this.account = account;
        this.address = address;
        this.bank = bank;
        this.phone = phone;
        this.ratepayerNo = ratepayerNo;
        this.receiptAmount = receiptAmount;
        this.receiptTitle = receiptTitle;
        this.bankPhone = bankPhone;
        this.contact = contact;
        this.detailsAddress = detailsAddress;
        this.region = region;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setDetailsAddress(String detailsAddress) {
        this.detailsAddress = detailsAddress;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public String getContact() {
        return contact;
    }

    public String getDetailsAddress() {
        return detailsAddress;
    }

    public String getRegion() {
        return region;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRatepayerNo() {
        return ratepayerNo;
    }

    public void setRatepayerNo(String ratepayerNo) {
        this.ratepayerNo = ratepayerNo;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getReceiptContent() {
        return receiptContent;
    }

    public void setReceiptContent(String receiptContent) {
        this.receiptContent = receiptContent;
    }

    public String getReceiptTitle() {
        return receiptTitle;
    }

    public void setReceiptTitle(String receiptTitle) {
        this.receiptTitle = receiptTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DedicatedReceiptInfoBean{" +
                "account='" + account + '\'' +
                ", address='" + address + '\'' +
                ", bank='" + bank + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", ratepayerNo='" + ratepayerNo + '\'' +
                ", receiptAmount='" + receiptAmount + '\'' +
                ", receiptContent='" + receiptContent + '\'' +
                ", receiptTitle='" + receiptTitle + '\'' +
                ", type='" + type + '\'' +
                ", bankPhone='" + bankPhone + '\'' +
                ", contact='" + contact + '\'' +
                ", detailsAddress='" + detailsAddress + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
