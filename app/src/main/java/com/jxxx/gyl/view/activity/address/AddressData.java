package com.jxxx.gyl.view.activity.address;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * id : 42
 * userId : 89
 * provinceId : 330000
 * cityId : 330200
 * districtId : 330212
 * placeId : 3
 * regions : 浙江省,宁波市,鄞州区
 * location : 鄞州科技信息孵化园(宁波市鄞州区)D栋四楼
 * place : 科技孵化园
 * delTf : false
 * acceptName : 李同革
 * mobile : 17774004352
 * createTime : 2020-05-27T11:20:03.917+0800
 * streetId : 0
 * lat : 29.807919
 * lng : 121.55747
 * default : true
 */
public class AddressData implements Serializable {
    private Integer id;
    private int userId;
    private String provinceId;
    private String cityId;
    private String districtId;
    private int placeId;
    private String regions;
    private String location;
    private String place;
    private boolean delTf;
    private String acceptName;
    private String mobile;
    private String createTime;
    private int streetId;
    private double lat;
    private double lng;
    @SerializedName("default")
    private boolean defaultX;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isDelTf() {
        return delTf;
    }

    public void setDelTf(boolean delTf) {
        this.delTf = delTf;
    }

    public String getAcceptName() {
        return acceptName;
    }

    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public boolean isDefaultX() {
        return defaultX;
    }

    public void setDefaultX(boolean defaultX) {
        this.defaultX = defaultX;
    }

    @Override
    public String toString() {
        return "AddressData{" +
                "id=" + id +
                ", userId=" + userId +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", districtId=" + districtId +
                ", placeId=" + placeId +
                ", regions='" + regions + '\'' +
                ", location='" + location + '\'' +
                ", place='" + place + '\'' +
                ", delTf=" + delTf +
                ", acceptName='" + acceptName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", createTime='" + createTime + '\'' +
                ", streetId=" + streetId +
                ", lat=" + lat +
                ", lng=" + lng +
                ", defaultX=" + defaultX +
                '}';
    }
}
