package com.jxxx.gyl.base;


import java.util.List;


public class ShopInfoData {

    /**
     * iconUrl : 
     * id : 
     * offSaleTime : 
     * skus : [{"id":"","levelPrice":{"level":"","skuId":0,"skuLevelPrice":0},"skuImage":"","skuName":"","skuSaleNum":0,"skuUnit":"","spuId":"","stockNum":0}]
     * spuDesc : 
     * spuImgs : 
     * spuName : 
     * spuParams : 
     * spuPrice : 0
     * spuSaleNum : 0
     * spuSelfSupply : false
     * spuShortDesc : 
     * suppliersId : 
     * suppliersName : 
     */

    private String iconUrl;
    private String id;
    private String offSaleTime;
    private String spuDesc;
    private String spuImgs;
    private String spuName;
    private String spuParams;
    private String spuPrice;
    private String spuSaleNum;
    private boolean spuSelfSupply;
    private String spuShortDesc;
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

    public String getSpuDesc() {
        return spuDesc;
    }

    public void setSpuDesc(String spuDesc) {
        this.spuDesc = spuDesc;
    }

    public String getSpuImgs() {
        return spuImgs;
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

    public String getSpuPrice() {
        return spuPrice;
    }

    public void setSpuPrice(String spuPrice) {
        this.spuPrice = spuPrice;
    }

    public String getSpuSaleNum() {
        return spuSaleNum;
    }

    public void setSpuSaleNum(String spuSaleNum) {
        this.spuSaleNum = spuSaleNum;
    }

    public boolean isSpuSelfSupply() {
        return spuSelfSupply;
    }

    public void setSpuSelfSupply(boolean spuSelfSupply) {
        this.spuSelfSupply = spuSelfSupply;
    }

    public String getSpuShortDesc() {
        return spuShortDesc;
    }

    public void setSpuShortDesc(String spuShortDesc) {
        this.spuShortDesc = spuShortDesc;
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

    public static class SkusBean {
        /**
         * id : 
         * levelPrice : {"level":"","skuId":0,"skuLevelPrice":0}
         * skuImage : 
         * skuName : 
         * skuSaleNum : 0
         * skuUnit : 
         * spuId : 
         * stockNum : 0
         */

        private String id;
        private LevelPriceBean levelPrice;
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

        public LevelPriceBean getLevelPrice() {
            return levelPrice;
        }

        public void setLevelPrice(LevelPriceBean levelPrice) {
            this.levelPrice = levelPrice;
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

        public static class LevelPriceBean {
            /**
             * level : 
             * skuId : 0
             * skuLevelPrice : 0
             */

            private String level;
            private String skuId;
            private String skuLevelPrice;

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getSkuId() {
                return skuId;
            }

            public void setSkuId(String skuId) {
                this.skuId = skuId;
            }

            public String getSkuLevelPrice() {
                return skuLevelPrice;
            }

            public void setSkuLevelPrice(String skuLevelPrice) {
                this.skuLevelPrice = skuLevelPrice;
            }
        }
    }
}
