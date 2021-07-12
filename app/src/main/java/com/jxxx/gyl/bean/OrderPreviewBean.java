package com.jxxx.gyl.bean;

import java.util.List;

public class OrderPreviewBean {

    /**
     * defaultShippingAddress : {"address":"","contact":"林嘉","defaulted":0,"houseNo":"","id":0,"landmark":"","latitude":100.11,"longitude":198,"phone":"18099991234","tag":"家","userId":0}
     * previewOrderDTO : {"couponAmount":3.88,"deliveryTime":"约2021-08-08 08:00:00前送达","discountAmount":3.88,"freightAmount":6.88,"innerOrderNo":"","orderDetailList":[{"previewOrderSpuDTO":{"iconUrl":"","id":"1","previewOrderSkuDTO":{"id":"1","skuName":"3斤","skuNum":3,"skuPriceDTO":{"skuPrice":18.88,"unit":"斤"},"skuUnit":"斤","spuId":""},"spuName":"云南甜玉米","spuSupplyType":2,"supplierId":"1","supplierName":"三都港"}}],"orderStatus":"","payAmount":21.88,"payableAmount":24.88,"totalAmount":18,"totalItemNum":1}
     * recommendCoupon : {"couponType":1,"couponValue":"28.00","description":"全场商品满减","effectiveTime":"","id":0,"invalidTime":"","name":"","receiveTime":"","receiveWay":1,"spuIds":"","spuRange":2,"status":0,"statusInfo":"4天后即将过期","tag":"平台券","thresholdAmount":"99.00","title":"满99减28","useSuperimposedType":0,"userId":0}
     * shippingAddressList : [{"address":"","contact":"林嘉","defaulted":0,"houseNo":"","id":0,"landmark":"","latitude":100.11,"longitude":198,"phone":"18099991234","tag":"家","userId":0}]
     * userCouponList : [{"couponType":1,"couponValue":"28.00","description":"全场商品满减","effectiveTime":"","id":0,"invalidTime":"","name":"","receiveTime":"","receiveWay":1,"spuIds":"","spuRange":2,"status":0,"statusInfo":"4天后即将过期","tag":"平台券","thresholdAmount":"99.00","title":"满99减28","useSuperimposedType":0,"userId":0}]
     */

    private DefaultShippingAddressBean defaultShippingAddress;
    private PreviewOrderDTOBean previewOrderDTO;
    private CouponTemplateData recommendCoupon;
    private List<ShippingAddressListBean> shippingAddressList;
    private List<CouponTemplateData> userCouponList;

    public DefaultShippingAddressBean getDefaultShippingAddress() {
        return defaultShippingAddress;
    }

    public void setDefaultShippingAddress(DefaultShippingAddressBean defaultShippingAddress) {
        this.defaultShippingAddress = defaultShippingAddress;
    }

    public PreviewOrderDTOBean getPreviewOrderDTO() {
        return previewOrderDTO;
    }

    public void setPreviewOrderDTO(PreviewOrderDTOBean previewOrderDTO) {
        this.previewOrderDTO = previewOrderDTO;
    }

    public CouponTemplateData getRecommendCoupon() {
        return recommendCoupon;
    }

    public void setRecommendCoupon(CouponTemplateData recommendCoupon) {
        this.recommendCoupon = recommendCoupon;
    }

    public List<ShippingAddressListBean> getShippingAddressList() {
        return shippingAddressList;
    }

    public void setShippingAddressList(List<ShippingAddressListBean> shippingAddressList) {
        this.shippingAddressList = shippingAddressList;
    }

    public List<CouponTemplateData> getUserCouponList() {
        return userCouponList;
    }

    public void setUserCouponList(List<CouponTemplateData> userCouponList) {
        this.userCouponList = userCouponList;
    }

    public static class DefaultShippingAddressBean {
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

    public static class PreviewOrderDTOBean {
        /**
         * couponAmount : 3.88
         * deliveryTime : 约2021-08-08 08:00:00前送达
         * discountAmount : 3.88
         * freightAmount : 6.88
         * innerOrderNo :
         * orderDetailList : [{"previewOrderSpuDTO":{"iconUrl":"","id":"1","previewOrderSkuDTO":{"id":"1","skuName":"3斤","skuNum":3,"skuPriceDTO":{"skuPrice":18.88,"unit":"斤"},"skuUnit":"斤","spuId":""},"spuName":"云南甜玉米","spuSupplyType":2,"supplierId":"1","supplierName":"三都港"}}]
         * orderStatus :
         * payAmount : 21.88
         * payableAmount : 24.88
         * totalAmount : 18
         * totalItemNum : 1
         */

        private String couponAmount;
        private String deliveryTime;
        private String discountAmount;
        private String freightAmount;
        private String innerOrderNo;
        private String orderStatus;
        private String payAmount;
        private String payableAmount;
        private String totalAmount;
        private String totalItemNum;
        private List<OrderDetailListBean> orderDetailList;

        public String getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(String couponAmount) {
            this.couponAmount = couponAmount;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getFreightAmount() {
            return freightAmount;
        }

        public void setFreightAmount(String freightAmount) {
            this.freightAmount = freightAmount;
        }

        public String getInnerOrderNo() {
            return innerOrderNo;
        }

        public void setInnerOrderNo(String innerOrderNo) {
            this.innerOrderNo = innerOrderNo;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(String payAmount) {
            this.payAmount = payAmount;
        }

        public String getPayableAmount() {
            return payableAmount;
        }

        public void setPayableAmount(String payableAmount) {
            this.payableAmount = payableAmount;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getTotalItemNum() {
            return totalItemNum;
        }

        public void setTotalItemNum(String totalItemNum) {
            this.totalItemNum = totalItemNum;
        }

        public List<OrderDetailListBean> getOrderDetailList() {
            return orderDetailList;
        }

        public void setOrderDetailList(List<OrderDetailListBean> orderDetailList) {
            this.orderDetailList = orderDetailList;
        }

        public static class OrderDetailListBean {
            /**
             * previewOrderSpuDTO : {"iconUrl":"","id":"1","previewOrderSkuDTO":{"id":"1","skuName":"3斤","skuNum":3,"skuPriceDTO":{"skuPrice":18.88,"unit":"斤"},"skuUnit":"斤","spuId":""},"spuName":"云南甜玉米","spuSupplyType":2,"supplierId":"1","supplierName":"三都港"}
             */

            private PreviewOrderSpuDTOBean previewOrderSpuDTO;

            public PreviewOrderSpuDTOBean getPreviewOrderSpuDTO() {
                return previewOrderSpuDTO;
            }

            public void setPreviewOrderSpuDTO(PreviewOrderSpuDTOBean previewOrderSpuDTO) {
                this.previewOrderSpuDTO = previewOrderSpuDTO;
            }

            public static class PreviewOrderSpuDTOBean {
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

                        private String skuPrice;
                        private String unit;

                        public String getSkuPrice() {
                            return skuPrice;
                        }

                        public void setSkuPrice(String skuPrice) {
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
    }

    public static class ShippingAddressListBean {
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
}
