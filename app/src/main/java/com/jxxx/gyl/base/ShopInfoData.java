package com.jxxx.gyl.base;

import java.util.List;

public class ShopInfoData {

    /**
     * iconUrl : 
     * id : 
     * offSaleTime : 
     * priceInfo : {"price":0}
     * skus : [{"id":"","priceInfo":{"price":0},"skuImage":"","skuName":"","skuSaleNum":0,"skuUnit":"","spuId":"","stockNum":0}]
     * spuDesc : 
     * spuImgs : 
     * spuName : 
     * spuParams : 
     * spuSaleNum : 0
     * spuShortDesc : 
     * spuSupplyType : 0
     * suppliersId : 
     * suppliersName : 
     */

    private String iconUrl;
    private String id;
    private String offSaleTime;
    private PriceInfoBean priceInfo;
    private String spuDesc;
    private String spuImgs;
    private String spuName;
    private String spuParams;
    private String spuSaleNum;
    private String spuShortDesc;
    private String spuSupplyType;
    private String suppliersId;
    private String suppliersName;
    private List<SkusBean> skus;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOffSaleTime() {
        return offSaleTime;
    }

    public void setOffSaleTime(String offSaleTime) {
        this.offSaleTime = offSaleTime;
    }

    public PriceInfoBean getPriceInfo() {
        return priceInfo;
    }

    public void setPriceInfo(PriceInfoBean priceInfo) {
        this.priceInfo = priceInfo;
    }

    public String getSpuDesc() {
        return spuDesc;
    }

    public void setSpuDesc(String spuDesc) {
        this.spuDesc = spuDesc;
    }

    public String[] getSpuImgs() {
        return spuImgs.replace("[","")
                .replace("]","")
                .replace("\"","").split(",");
    }

    public void setSpuImgs(String spuImgs) {
        this.spuImgs = spuImgs;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSpuParams() {
        return spuParams;
    }

    public void setSpuParams(String spuParams) {
        this.spuParams = spuParams;
    }

    public String getSpuSaleNum() {
        return spuSaleNum;
    }

    public void setSpuSaleNum(String spuSaleNum) {
        this.spuSaleNum = spuSaleNum;
    }

    public String getSpuShortDesc() {
        return spuShortDesc;
    }

    public void setSpuShortDesc(String spuShortDesc) {
        this.spuShortDesc = spuShortDesc;
    }

    public String getSpuSupplyType() {
        return spuSupplyType;
    }

    public void setSpuSupplyType(String spuSupplyType) {
        this.spuSupplyType = spuSupplyType;
    }

    public String getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(String suppliersId) {
        this.suppliersId = suppliersId;
    }

    public String getSuppliersName() {
        return suppliersName;
    }

    public void setSuppliersName(String suppliersName) {
        this.suppliersName = suppliersName;
    }

    public List<SkusBean> getSkus() {
        return skus;
    }

    public void setSkus(List<SkusBean> skus) {
        this.skus = skus;
    }

    public static class PriceInfoBean {
        /**
         * price : 0
         * unit : 斤
         */

        private String price;
        private String unit;

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getUnit() {
            return "";
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    public static class SkusBean {
        /**
         * id : 
         * priceInfo : {"price":0}
         * skuImage : 
         * skuName : 
         * skuSaleNum : 0
         * skuUnit : 
         * spuId : 
         * stockNum : 0
         */

        private String id;
        private PriceInfoBean priceInfo;
        private String skuImage;
        private String skuName;
        private String skuSaleNum;
        private String skuUnit;
        private String spuId;
        private String stockNum;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public PriceInfoBean getPriceInfo() {
            return priceInfo;
        }

        public void setPriceInfo(PriceInfoBean priceInfo) {
            this.priceInfo = priceInfo;
        }

        public String getSkuImage() {
            return skuImage;
        }

        public void setSkuImage(String skuImage) {
            this.skuImage = skuImage;
        }

        public String getSkuName() {
            return skuName;
        }

        public void setSkuName(String skuName) {
            this.skuName = skuName;
        }

        public String getSkuSaleNum() {
            return skuSaleNum;
        }

        public void setSkuSaleNum(String skuSaleNum) {
            this.skuSaleNum = skuSaleNum;
        }

        public String getSkuUnit() {
            return skuUnit;
        }

        public void setSkuUnit(String skuUnit) {
            this.skuUnit = skuUnit;
        }

        public String getSpuId() {
            return spuId;
        }

        public void setSpuId(String spuId) {
            this.spuId = spuId;
        }

        public String getStockNum() {
            return stockNum;
        }

        public void setStockNum(String stockNum) {
            this.stockNum = stockNum;
        }
    }
}
