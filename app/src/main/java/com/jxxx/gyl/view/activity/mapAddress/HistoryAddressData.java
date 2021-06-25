package com.jxxx.gyl.view.activity.mapAddress;

import com.amap.api.maps.model.LatLng;

public class HistoryAddressData {
    String address;
    String addressXq;
    LatLng mLatLng;

    public HistoryAddressData(String address, String addressXq, LatLng latLng) {
        this.address = address;
        this.addressXq = addressXq;
        this.mLatLng = latLng;
    }

    public void setAddressXq(String addressXq) {
        this.addressXq = addressXq;
    }

    public String getAddressXq() {
        return addressXq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LatLng getLatLng() {
        return mLatLng;
    }

    public void setLatLng(LatLng latLng) {
        mLatLng = latLng;
    }
}
