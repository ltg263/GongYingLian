package com.jxxx.gyl.bean;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class OrderInfoBean {

    /**
     * addChannel : APP_MALL
     * skuId : 1
     * spuId : 1
     */

    private String addChannel;
    private String skuId;
    private String spuId;
    private String num;
    private Integer[] checkedSkuIdList;
    private Integer[] unCheckedSkuIdList;

    @Override
    public String toString() {
        return "OrderInfoBean{" +
                "checkedSkuIdList=" + Arrays.toString(checkedSkuIdList) +
                ", unCheckedSkuIdList=" + Arrays.toString(unCheckedSkuIdList) +
                '}';
    }

    public void setShopCartAdd(String addChannel, String skuId, String spuId) {
        this.addChannel = addChannel;
        this.skuId = skuId;
        this.spuId = spuId;
    }

    public void setShopCartDel(String num, String skuId, String spuId) {
        this.num = num;
        this.skuId = skuId;
        this.spuId = spuId;
    }

    public void setShopCartChecked(Integer[] checkedSkuIdList, Integer[] unCheckedSkuIdList) {
        this.checkedSkuIdList = checkedSkuIdList;
        this.unCheckedSkuIdList = unCheckedSkuIdList;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public String getAddChannel() {
        return addChannel;
    }

    public void setAddChannel(String addChannel) {
        this.addChannel = addChannel;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public Integer[] getCheckedSkuIdList() {
        return checkedSkuIdList;
    }

    public void setCheckedSkuIdList(Integer[] checkedSkuIdList) {
        this.checkedSkuIdList = checkedSkuIdList;
    }

    public Integer[] getUnCheckedSkuIdList() {
        return unCheckedSkuIdList;
    }

    public void setUnCheckedSkuIdList(Integer[] unCheckedSkuIdList) {
        this.unCheckedSkuIdList = unCheckedSkuIdList;
    }
}
