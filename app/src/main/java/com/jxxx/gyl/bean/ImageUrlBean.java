package com.jxxx.gyl.bean;

import java.io.Serializable;

public class ImageUrlBean implements Serializable {

    public ImageUrlBean(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ImageUrlBean(int type, String imgUrl) {
        this.type = type;
        this.imgUrl = imgUrl;
    }

    public ImageUrlBean() {
    }

    String imgUrl;
    int type;


    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
