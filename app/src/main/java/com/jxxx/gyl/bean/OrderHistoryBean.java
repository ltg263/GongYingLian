package com.jxxx.gyl.bean;

import java.util.List;

public class OrderHistoryBean {

    /**
     * current : 0
     * hitCount : true
     * optimizeCountSql : true
     * orders : [{"asc":false,"column":"id"}]
     * records : [{"autoDeliveryTime":"","cancelDesc":"","cancelEndTime":"","cancelTime":"","cancelType":"","couponAmount":0,"dedicatedReceiptInfo":{"account":"1","address":"1","bank":"1","email":"1","phone":"1","ratepayerNo":"1","receiptAmount":"1","receiptContent":"1","receiptTitle":"1","type":1},"deliveryAddress":"","deliveryMobile":"","deliveryName":"","deliveryType":"","depositPayTime":"","discountAmount":0,"endTime":"","freightAmount":0,"generalReceiptInfo":{"account":"1","address":"1","bank":"1","email":"1","phone":"1","ratepayerNo":"1","receiptAmount":"1","receiptContent":"1","receiptTitle":"1","type":1},"id":0,"innerOrderNo":"","orderDetailList":[{"id":0,"shareAmount":0,"skuNum":0,"totalAmount":0,"userOrderSpuDTO":{"iconUrl":"","id":"","priceInfo":{"price":0,"unit":""},"sku":{"id":"","priceInfo":{"price":0,"unit":""},"skuImage":"","skuName":"","skuNum":0,"skuUnit":"","spuId":""},"spuImgs":"","spuName":"","spuSupplyType":0,"supplierId":"","supplierName":""}}],"orderStatus":"","outerOrderNo":"","payAmount":0,"payChannel":"","payCreateTime":"","payFinishTime":"","payNo":"","payStatus":"","payableAmount":0,"placeTime":"","receiptType":0,"totalAmount":0,"totalItemNum":0,"userCouponId":0,"userId":0,"userRemark":"","warehouseId":0}]
     * searchCount : true
     * size : 0
     * total : 0
     */

    private int current;
    private boolean hitCount;
    private boolean optimizeCountSql;
    private boolean searchCount;
    private int size;
    private int total;
    private List<OrdersBean> orders;
    private List<RecordsBean> records;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public boolean isHitCount() {
        return hitCount;
    }

    public void setHitCount(boolean hitCount) {
        this.hitCount = hitCount;
    }

    public boolean isOptimizeCountSql() {
        return optimizeCountSql;
    }

    public void setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
    }

    public boolean isSearchCount() {
        return searchCount;
    }

    public void setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<OrdersBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersBean> orders) {
        this.orders = orders;
    }

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class OrdersBean {
        /**
         * asc : false
         * column : id
         */

        private boolean asc;
        private String column;

        public boolean isAsc() {
            return asc;
        }

        public void setAsc(boolean asc) {
            this.asc = asc;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }
    }

    public static class RecordsBean {
        /**
         * autoDeliveryTime :
         * cancelDesc :
         * cancelEndTime :
         * cancelTime :
         * cancelType :
         * couponAmount : 0
         * dedicatedReceiptInfo : {"account":"1","address":"1","bank":"1","email":"1","phone":"1","ratepayerNo":"1","receiptAmount":"1","receiptContent":"1","receiptTitle":"1","type":1}
         * deliveryAddress :
         * deliveryMobile :
         * deliveryName :
         * deliveryType :
         * depositPayTime :
         * discountAmount : 0
         * endTime :
         * freightAmount : 0
         * generalReceiptInfo : {"account":"1","address":"1","bank":"1","email":"1","phone":"1","ratepayerNo":"1","receiptAmount":"1","receiptContent":"1","receiptTitle":"1","type":1}
         * id : 0
         * innerOrderNo :
         * orderDetailList : [{"id":0,"shareAmount":0,"skuNum":0,"totalAmount":0,"userOrderSpuDTO":{"iconUrl":"","id":"","priceInfo":{"price":0,"unit":""},"sku":{"id":"","priceInfo":{"price":0,"unit":""},"skuImage":"","skuName":"","skuNum":0,"skuUnit":"","spuId":""},"spuImgs":"","spuName":"","spuSupplyType":0,"supplierId":"","supplierName":""}}]
         * orderStatus :
         * outerOrderNo :
         * payAmount : 0
         * payChannel :
         * payCreateTime :
         * payFinishTime :
         * payNo :
         * payStatus :
         * payableAmount : 0
         * placeTime :
         * receiptType : 0
         * totalAmount : 0
         * totalItemNum : 0
         * userCouponId : 0
         * userId : 0
         * userRemark :
         * warehouseId : 0
         */

        private String autoDeliveryTime;
        private String cancelDesc;
        private String cancelEndTime;
        private String cancelTime;
        private String cancelType;
        private String couponAmount;
        private DedicatedReceiptInfoBean dedicatedReceiptInfo;
        private String deliveryAddress;
        private String deliveryMobile;
        private String deliveryName;
        private String deliveryType;
        private String depositPayTime;
        private String discountAmount;
        private String endTime;
        private String freightAmount;
        private DedicatedReceiptInfoBean generalReceiptInfo;
        private String id;
        private String innerOrderNo;
        private String orderStatus;
        private String outerOrderNo;
        private String payAmount;
        private String payChannel;
        private String payCreateTime;
        private String payFinishTime;
        private String payNo;
        private String payStatus;
        private String payableAmount;
        private String placeTime;
        private String receiptType;
        private String totalAmount;
        private String totalItemNum;
        private String userCouponId;
        private String userId;
        private String userRemark;
        private String warehouseId;
        private List<OrderDetailListBean> orderDetailList;

        public String getAutoDeliveryTime() {
            return autoDeliveryTime;
        }

        public void setAutoDeliveryTime(String autoDeliveryTime) {
            this.autoDeliveryTime = autoDeliveryTime;
        }

        public String getCancelDesc() {
            return cancelDesc;
        }

        public void setCancelDesc(String cancelDesc) {
            this.cancelDesc = cancelDesc;
        }

        public String getCancelEndTime() {
            return cancelEndTime;
        }

        public void setCancelEndTime(String cancelEndTime) {
            this.cancelEndTime = cancelEndTime;
        }

        public String getCancelTime() {
            return cancelTime;
        }

        public void setCancelTime(String cancelTime) {
            this.cancelTime = cancelTime;
        }

        public String getCancelType() {
            return cancelType;
        }

        public void setCancelType(String cancelType) {
            this.cancelType = cancelType;
        }

        public String getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(String couponAmount) {
            this.couponAmount = couponAmount;
        }

        public DedicatedReceiptInfoBean getDedicatedReceiptInfo() {
            return dedicatedReceiptInfo;
        }

        public void setDedicatedReceiptInfo(DedicatedReceiptInfoBean dedicatedReceiptInfo) {
            this.dedicatedReceiptInfo = dedicatedReceiptInfo;
        }

        public String getDeliveryAddress() {
            return deliveryAddress;
        }

        public void setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
        }

        public String getDeliveryMobile() {
            return deliveryMobile;
        }

        public void setDeliveryMobile(String deliveryMobile) {
            this.deliveryMobile = deliveryMobile;
        }

        public String getDeliveryName() {
            return deliveryName;
        }

        public void setDeliveryName(String deliveryName) {
            this.deliveryName = deliveryName;
        }

        public String getDeliveryType() {
            return deliveryType;
        }

        public void setDeliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
        }

        public String getDepositPayTime() {
            return depositPayTime;
        }

        public void setDepositPayTime(String depositPayTime) {
            this.depositPayTime = depositPayTime;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getFreightAmount() {
            return freightAmount;
        }

        public void setFreightAmount(String freightAmount) {
            this.freightAmount = freightAmount;
        }

        public DedicatedReceiptInfoBean getGeneralReceiptInfo() {
            return generalReceiptInfo;
        }

        public void setGeneralReceiptInfo(DedicatedReceiptInfoBean generalReceiptInfo) {
            this.generalReceiptInfo = generalReceiptInfo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getOuterOrderNo() {
            return outerOrderNo;
        }

        public void setOuterOrderNo(String outerOrderNo) {
            this.outerOrderNo = outerOrderNo;
        }

        public String getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(String payAmount) {
            this.payAmount = payAmount;
        }

        public String getPayChannel() {
            return payChannel;
        }

        public void setPayChannel(String payChannel) {
            this.payChannel = payChannel;
        }

        public String getPayCreateTime() {
            return payCreateTime;
        }

        public void setPayCreateTime(String payCreateTime) {
            this.payCreateTime = payCreateTime;
        }

        public String getPayFinishTime() {
            return payFinishTime;
        }

        public void setPayFinishTime(String payFinishTime) {
            this.payFinishTime = payFinishTime;
        }

        public String getPayNo() {
            return payNo;
        }

        public void setPayNo(String payNo) {
            this.payNo = payNo;
        }

        public String getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(String payStatus) {
            this.payStatus = payStatus;
        }

        public String getPayableAmount() {
            return payableAmount;
        }

        public void setPayableAmount(String payableAmount) {
            this.payableAmount = payableAmount;
        }

        public String getPlaceTime() {
            return placeTime;
        }

        public void setPlaceTime(String placeTime) {
            this.placeTime = placeTime;
        }

        public String getReceiptType() {
            return receiptType;
        }

        public void setReceiptType(String receiptType) {
            this.receiptType = receiptType;
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

        public String getUserCouponId() {
            return userCouponId;
        }

        public void setUserCouponId(String userCouponId) {
            this.userCouponId = userCouponId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserRemark() {
            return userRemark;
        }

        public void setUserRemark(String userRemark) {
            this.userRemark = userRemark;
        }

        public String getWarehouseId() {
            return warehouseId;
        }

        public void setWarehouseId(String warehouseId) {
            this.warehouseId = warehouseId;
        }

        public List<OrderDetailListBean> getOrderDetailList() {
            return orderDetailList;
        }

        public void setOrderDetailList(List<OrderDetailListBean> orderDetailList) {
            this.orderDetailList = orderDetailList;
        }

        public static class DedicatedReceiptInfoBean {
            /**
             * account : 1
             * address : 1
             * bank : 1
             * email : 1
             * phone : 1
             * ratepayerNo : 1
             * receiptAmount : 1
             * receiptContent : 1
             * receiptTitle : 1
             * type : 1
             */

            private String account;
            private String address;
            private String bank;
            private String email;
            private String phone;
            private String ratepayerNo;
            private String receiptAmount;
            private String receiptContent;
            private String receiptTitle;
            private String type;

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getBank() {
                return bank;
            }

            public void setBank(String bank) {
                this.bank = bank;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getRatepayerNo() {
                return ratepayerNo;
            }

            public void setRatepayerNo(String ratepayerNo) {
                this.ratepayerNo = ratepayerNo;
            }

            public String getReceiptAmount() {
                return receiptAmount;
            }

            public void setReceiptAmount(String receiptAmount) {
                this.receiptAmount = receiptAmount;
            }

            public String getReceiptContent() {
                return receiptContent;
            }

            public void setReceiptContent(String receiptContent) {
                this.receiptContent = receiptContent;
            }

            public String getReceiptTitle() {
                return receiptTitle;
            }

            public void setReceiptTitle(String receiptTitle) {
                this.receiptTitle = receiptTitle;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class OrderDetailListBean {
            /**
             * id : 0
             * shareAmount : 0
             * skuNum : 0
             * totalAmount : 0
             * userOrderSpuDTO : {"iconUrl":"","id":"","priceInfo":{"price":0,"unit":""},"sku":{"id":"","priceInfo":{"price":0,"unit":""},"skuImage":"","skuName":"","skuNum":0,"skuUnit":"","spuId":""},"spuImgs":"","spuName":"","spuSupplyType":0,"supplierId":"","supplierName":""}
             */

            private String id;
            private String shareAmount;
            private String skuNum;
            private String totalAmount;
            private UserOrderSpuDTOBean userOrderSpuDTO;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getShareAmount() {
                return shareAmount;
            }

            public void setShareAmount(String shareAmount) {
                this.shareAmount = shareAmount;
            }

            public String getSkuNum() {
                return skuNum;
            }

            public void setSkuNum(String skuNum) {
                this.skuNum = skuNum;
            }

            public String getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(String totalAmount) {
                this.totalAmount = totalAmount;
            }

            public UserOrderSpuDTOBean getUserOrderSpuDTO() {
                return userOrderSpuDTO;
            }

            public void setUserOrderSpuDTO(UserOrderSpuDTOBean userOrderSpuDTO) {
                this.userOrderSpuDTO = userOrderSpuDTO;
            }

            public static class UserOrderSpuDTOBean {
                /**
                 * iconUrl :
                 * id :
                 * priceInfo : {"price":0,"unit":""}
                 * sku : {"id":"","priceInfo":{"price":0,"unit":""},"skuImage":"","skuName":"","skuNum":0,"skuUnit":"","spuId":""}
                 * spuImgs :
                 * spuName :
                 * spuSupplyType : 0
                 * supplierId :
                 * supplierName :
                 */

                private String iconUrl;
                private String id;
                private PriceInfoBean priceInfo;
                private SkuBean sku;
                private String spuImgs;
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

                public PriceInfoBean getPriceInfo() {
                    return priceInfo;
                }

                public void setPriceInfo(PriceInfoBean priceInfo) {
                    this.priceInfo = priceInfo;
                }

                public SkuBean getSku() {
                    return sku;
                }

                public void setSku(SkuBean sku) {
                    this.sku = sku;
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

                public static class PriceInfoBean {
                    /**
                     * price : 0
                     * unit :
                     */

                    private String price;
                    private String unit;

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public String getUnit() {
                        return unit;
                    }

                    public void setUnit(String unit) {
                        this.unit = unit;
                    }
                }

                public static class SkuBean {
                    /**
                     * id :
                     * priceInfo : {"price":0,"unit":""}
                     * skuImage :
                     * skuName :
                     * skuNum : 0
                     * skuUnit :
                     * spuId :
                     */

                    private String id;
                    private PriceInfoBean priceInfo;
                    private String skuImage;
                    private String skuName;
                    private String skuNum;
                    private String skuUnit;
                    private String spuId;

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

                    public String getSkuNum() {
                        return skuNum;
                    }

                    public void setSkuNum(String skuNum) {
                        this.skuNum = skuNum;
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
                }
            }
        }
    }
}
