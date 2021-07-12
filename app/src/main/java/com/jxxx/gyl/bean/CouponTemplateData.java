package com.jxxx.gyl.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class CouponTemplateData implements Parcelable {

    /**
     * couponType : 1
     * couponValue : 18
     * description : 全部商品可用
     * effectiveTime : 
     * id : 1
     * invalidTime : 
     * isDraw : 0
     * name : 平台通用优惠券
     * receiveEndTime : 
     * receiveStartTime : 
     * receiveWay : 1
     * releaseQuantity : 100
     * residueQuantity : 89
     * residueRatio : 0.89
     * returnQualification : 1
     * spuIds : 
     * spuRange : 2
     * status : 1
     * tag : 平台券
     * thresholdAmount : 58
     * title : 满58减18
     * useSuperimposedType : 0
     */
    private String couponType;
    private String couponValue;
    private String description;
    private String effectiveTime;
    private String id;
    private String invalidTime;
    private String isDraw;
    private String name;
    private String receiveEndTime;
    private String receiveStartTime;
    private String receiveWay;
    private String releaseQuantity;
    private String residueQuantity;
    private String residueRatio;
    private String returnQualification;
    private String spuIds;
    private String spuRange;
    private String status;
    private String tag;
    private String thresholdAmount;
    private String title;
    private String useSuperimposedType;
    private String userId;
    private String statusInfo;

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public String getUserId() {
        return userId;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(String couponValue) {
        this.couponValue = couponValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(String invalidTime) {
        this.invalidTime = invalidTime;
    }

    public String getIsDraw() {
        return isDraw;
    }

    public void setIsDraw(String isDraw) {
        this.isDraw = isDraw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceiveEndTime() {
        return receiveEndTime;
    }

    public void setReceiveEndTime(String receiveEndTime) {
        this.receiveEndTime = receiveEndTime;
    }

    public String getReceiveStartTime() {
        return receiveStartTime;
    }

    public void setReceiveStartTime(String receiveStartTime) {
        this.receiveStartTime = receiveStartTime;
    }

    public String getReceiveWay() {
        return receiveWay;
    }

    public void setReceiveWay(String receiveWay) {
        this.receiveWay = receiveWay;
    }

    public String getReleaseQuantity() {
        return releaseQuantity;
    }

    public void setReleaseQuantity(String releaseQuantity) {
        this.releaseQuantity = releaseQuantity;
    }

    public String getResidueQuantity() {
        return residueQuantity;
    }

    public void setResidueQuantity(String residueQuantity) {
        this.residueQuantity = residueQuantity;
    }

    public String getResidueRatio() {
        return residueRatio;
    }

    public void setResidueRatio(String residueRatio) {
        this.residueRatio = residueRatio;
    }

    public String getReturnQualification() {
        return returnQualification;
    }

    public void setReturnQualification(String returnQualification) {
        this.returnQualification = returnQualification;
    }

    public String getSpuIds() {
        return spuIds;
    }

    public void setSpuIds(String spuIds) {
        this.spuIds = spuIds;
    }

    public String getSpuRange() {
        return spuRange;
    }

    public void setSpuRange(String spuRange) {
        this.spuRange = spuRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getThresholdAmount() {
        return thresholdAmount;
    }

    public void setThresholdAmount(String thresholdAmount) {
        this.thresholdAmount = thresholdAmount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUseSuperimposedType() {
        return useSuperimposedType;
    }

    public void setUseSuperimposedType(String useSuperimposedType) {
        this.useSuperimposedType = useSuperimposedType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.couponType);
        dest.writeString(this.couponValue);
        dest.writeString(this.description);
        dest.writeString(this.effectiveTime);
        dest.writeString(this.id);
        dest.writeString(this.invalidTime);
        dest.writeString(this.isDraw);
        dest.writeString(this.name);
        dest.writeString(this.receiveEndTime);
        dest.writeString(this.receiveStartTime);
        dest.writeString(this.receiveWay);
        dest.writeString(this.releaseQuantity);
        dest.writeString(this.residueQuantity);
        dest.writeString(this.residueRatio);
        dest.writeString(this.returnQualification);
        dest.writeString(this.spuIds);
        dest.writeString(this.spuRange);
        dest.writeString(this.status);
        dest.writeString(this.tag);
        dest.writeString(this.thresholdAmount);
        dest.writeString(this.title);
        dest.writeString(this.useSuperimposedType);
        dest.writeString(this.userId);
        dest.writeString(this.statusInfo);
    }

    public void readFromParcel(Parcel source) {
        this.couponType = source.readString();
        this.couponValue = source.readString();
        this.description = source.readString();
        this.effectiveTime = source.readString();
        this.id = source.readString();
        this.invalidTime = source.readString();
        this.isDraw = source.readString();
        this.name = source.readString();
        this.receiveEndTime = source.readString();
        this.receiveStartTime = source.readString();
        this.receiveWay = source.readString();
        this.releaseQuantity = source.readString();
        this.residueQuantity = source.readString();
        this.residueRatio = source.readString();
        this.returnQualification = source.readString();
        this.spuIds = source.readString();
        this.spuRange = source.readString();
        this.status = source.readString();
        this.tag = source.readString();
        this.thresholdAmount = source.readString();
        this.title = source.readString();
        this.useSuperimposedType = source.readString();
        this.userId = source.readString();
        this.statusInfo = source.readString();
    }

    public CouponTemplateData() {
    }

    protected CouponTemplateData(Parcel in) {
        this.couponType = in.readString();
        this.couponValue = in.readString();
        this.description = in.readString();
        this.effectiveTime = in.readString();
        this.id = in.readString();
        this.invalidTime = in.readString();
        this.isDraw = in.readString();
        this.name = in.readString();
        this.receiveEndTime = in.readString();
        this.receiveStartTime = in.readString();
        this.receiveWay = in.readString();
        this.releaseQuantity = in.readString();
        this.residueQuantity = in.readString();
        this.residueRatio = in.readString();
        this.returnQualification = in.readString();
        this.spuIds = in.readString();
        this.spuRange = in.readString();
        this.status = in.readString();
        this.tag = in.readString();
        this.thresholdAmount = in.readString();
        this.title = in.readString();
        this.useSuperimposedType = in.readString();
        this.userId = in.readString();
        this.statusInfo = in.readString();
    }

    public static final Parcelable.Creator<CouponTemplateData> CREATOR = new Parcelable.Creator<CouponTemplateData>() {
        @Override
        public CouponTemplateData createFromParcel(Parcel source) {
            return new CouponTemplateData(source);
        }

        @Override
        public CouponTemplateData[] newArray(int size) {
            return new CouponTemplateData[size];
        }
    };
}
