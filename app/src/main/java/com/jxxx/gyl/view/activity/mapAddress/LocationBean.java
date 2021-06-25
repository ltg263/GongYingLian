package com.jxxx.gyl.view.activity.mapAddress;

import java.io.Serializable;

public class LocationBean implements Serializable {

    private double lon;
    private double lat;
    private String title;
    private String content;

    public LocationBean(double lon, double lat, String title, String content){
        this.lon = lon;
        this.lat = lat;
        this.title = title;
        this.content = content;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}