package com.jxxx.gyl.bean;

import java.util.List;

public class OrderSubmitData {

    /**
     * failureReason : 
     * innerOrderNo : 454158125549748224
     * stockLessList : [{"iconUrl":"","id":"1","previewOrderSkuDTO":{"id":"1","skuName":"3斤","skuNum":3,"skuPriceDTO":{"skuPrice":18.88,"unit":"斤"},"skuUnit":"斤","spuId":""},"spuName":"云南甜玉米","spuSupplyType":2,"supplierId":"1","supplierName":"三都港"}]
     * submitStatus : 0
     */

    private String failureReason;
    private String innerOrderNo;
    private String submitStatus;
    private List<StockLessListBean> stockLessList;

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getInnerOrderNo() {
        return innerOrderNo;
    }

    public void setInnerOrderNo(String innerOrderNo) {
        this.innerOrderNo = innerOrderNo;
    }

    public String getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus;
    }

    public List<StockLessListBean> getStockLessList() {
        return stockLessList;
    }

    public void setStockLessList(List<StockLessListBean> stockLessList) {
        this.stockLessList = stockLessList;
    }

    public static class StockLessListBean {
        /**
         * iconUrl : 
         * id : 1
         * previewOrderSkuDTO : {"id":"1","skuName":"3斤","skuNum":3,"skuPriceDTO":{"skuPrice":18.88,"unit":"斤"},"skuUnit":"斤","spuId":""}
         * spuName : 云南甜玉米
         * spuSupplyType : 2
         * supplierId : 1
         * supplierName : 三都港
         */

        private String iconUrl;
        private String id;
        private PreviewOrderSkuDTOBean previewOrderSkuDTO;
        private String spuName;
        private String spuSupplyType;
        private String supplierId;
        private String supplierName;

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

        public PreviewOrderSkuDTOBean getPreviewOrderSkuDTO() {
            return previewOrderSkuDTO;
        }

        public void setPreviewOrderSkuDTO(PreviewOrderSkuDTOBean previewOrderSkuDTO) {
            this.previewOrderSkuDTO = previewOrderSkuDTO;
        }

        public String getSpuName() {
            return spuName;
        }

        public void setSpuName(String spuName) {
            this.spuName = spuName;
        }

        public String getSpuSupplyType() {
            return spuSupplyType;
        }

        public void setSpuSupplyType(String spuSupplyType) {
            this.spuSupplyType = spuSupplyType;
        }

        public String getSupplierId() {
            return supplierId;
        }

        public void setSupplierId(String supplierId) {
            this.supplierId = supplierId;
        }

        public String getSupplierName() {
            return supplierName;
        }

        public void setSupplierName(String supplierName) {
            this.supplierName = supplierName;
        }

        public static class PreviewOrderSkuDTOBean {
            /**
             * id : 1
             * skuName : 3斤
             * skuNum : 3
             * skuPriceDTO : {"skuPrice":18.88,"unit":"斤"}
             * skuUnit : 斤
             * spuId : 
             */

            private String id;
            private String skuName;
            private String skuNum;
            private SkuPriceDTOBean skuPriceDTO;
            private String skuUnit;
            private String spuId;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSkuName() {
                return skuName;
            }

            public void setSkuName(String skuName) {
                this.skuName = skuName;
            }

            public String getSkuNum() {
                return skuNum;
            }

            public void setSkuNum(String skuNum) {
                this.skuNum = skuNum;
            }

            public SkuPriceDTOBean getSkuPriceDTO() {
                return skuPriceDTO;
            }

            public void setSkuPriceDTO(SkuPriceDTOBean skuPriceDTO) {
                this.skuPriceDTO = skuPriceDTO;
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

            public static class SkuPriceDTOBean {
                /**
                 * skuPrice : 18.88
                 * unit : 斤
                 */

                private double skuPrice;
                private String unit;

                public double getSkuPrice() {
                    return skuPrice;
                }

                public void setSkuPrice(double skuPrice) {
                    this.skuPrice = skuPrice;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }
            }
        }
    }
}
