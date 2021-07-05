package com.jxxx.gyl.bean;

import java.io.Serializable;

public class AddressModel implements Serializable {

    /**
     * address : 
     * contact : 林嘉
     * defaulted : 0
     * houseNo : 
     * id : 0
     * landmark : 
     * latitude : 100.11
     * longitude : 198
     * phone : 18099991234
     * tag : 家
     * userId : 0
     */
    private String addressId;
    private String address;
    private String contact;
    private String defaulted;
    private String houseNo;
    private String id;
    private String landmark;
    private String latitude;
    private String longitude;
    private String phone;
    private String tag;
    private String userId;

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDefaulted() {
        return defaulted;
    }

    public void setDefaulted(String defaulted) {
        this.defaulted = defaulted;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
