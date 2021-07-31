package com.jxxx.gyl.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class OrderHistoryDetailBean implements Serializable {

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
    private boolean isSelect;

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public boolean isSelect() {
        return isSelect;
    }

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
    public static class OrderDetailListBean implements Parcelable {
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

        public static class UserOrderSpuDTOBean implements Parcelable {
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

            public static class PriceInfoBean implements Parcelable {
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.price);
                    dest.writeString(this.unit);
                }

                public void readFromParcel(Parcel source) {
                    this.price = source.readString();
                    this.unit = source.readString();
                }

                public PriceInfoBean() {
                }

                protected PriceInfoBean(Parcel in) {
                    this.price = in.readString();
                    this.unit = in.readString();
                }

                public static final Creator<PriceInfoBean> CREATOR = new Creator<PriceInfoBean>() {
                    @Override
                    public PriceInfoBean createFromParcel(Parcel source) {
                        return new PriceInfoBean(source);
                    }

                    @Override
                    public PriceInfoBean[] newArray(int size) {
                        return new PriceInfoBean[size];
                    }
                };
            }

            public static class SkuBean implements Parcelable {
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

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.id);
                    dest.writeParcelable(this.priceInfo, flags);
                    dest.writeString(this.skuImage);
                    dest.writeString(this.skuName);
                    dest.writeString(this.skuNum);
                    dest.writeString(this.skuUnit);
                    dest.writeString(this.spuId);
                }

                public void readFromParcel(Parcel source) {
                    this.id = source.readString();
                    this.priceInfo = source.readParcelable(PriceInfoBean.class.getClassLoader());
                    this.skuImage = source.readString();
                    this.skuName = source.readString();
                    this.skuNum = source.readString();
                    this.skuUnit = source.readString();
                    this.spuId = source.readString();
                }

                public SkuBean() {
                }

                protected SkuBean(Parcel in) {
                    this.id = in.readString();
                    this.priceInfo = in.readParcelable(PriceInfoBean.class.getClassLoader());
                    this.skuImage = in.readString();
                    this.skuName = in.readString();
                    this.skuNum = in.readString();
                    this.skuUnit = in.readString();
                    this.spuId = in.readString();
                }

                public static final Creator<SkuBean> CREATOR = new Creator<SkuBean>() {
                    @Override
                    public SkuBean createFromParcel(Parcel source) {
                        return new SkuBean(source);
                    }

                    @Override
                    public SkuBean[] newArray(int size) {
                        return new SkuBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.iconUrl);
                dest.writeString(this.id);
                dest.writeParcelable(this.priceInfo, flags);
                dest.writeParcelable(this.sku, flags);
                dest.writeString(this.spuImgs);
                dest.writeString(this.spuName);
                dest.writeString(this.spuSupplyType);
                dest.writeString(this.supplierId);
                dest.writeString(this.supplierName);
            }

            public void readFromParcel(Parcel source) {
                this.iconUrl = source.readString();
                this.id = source.readString();
                this.priceInfo = source.readParcelable(PriceInfoBean.class.getClassLoader());
                this.sku = source.readParcelable(SkuBean.class.getClassLoader());
                this.spuImgs = source.readString();
                this.spuName = source.readString();
                this.spuSupplyType = source.readString();
                this.supplierId = source.readString();
                this.supplierName = source.readString();
            }

            public UserOrderSpuDTOBean() {
            }

            protected UserOrderSpuDTOBean(Parcel in) {
                this.iconUrl = in.readString();
                this.id = in.readString();
                this.priceInfo = in.readParcelable(PriceInfoBean.class.getClassLoader());
                this.sku = in.readParcelable(SkuBean.class.getClassLoader());
                this.spuImgs = in.readString();
                this.spuName = in.readString();
                this.spuSupplyType = in.readString();
                this.supplierId = in.readString();
                this.supplierName = in.readString();
            }

            public static final Creator<UserOrderSpuDTOBean> CREATOR = new Creator<UserOrderSpuDTOBean>() {
                @Override
                public UserOrderSpuDTOBean createFromParcel(Parcel source) {
                    return new UserOrderSpuDTOBean(source);
                }

                @Override
                public UserOrderSpuDTOBean[] newArray(int size) {
                    return new UserOrderSpuDTOBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.shareAmount);
            dest.writeString(this.skuNum);
            dest.writeString(this.totalAmount);
            dest.writeParcelable(this.userOrderSpuDTO, flags);
        }

        public void readFromParcel(Parcel source) {
            this.id = source.readString();
            this.shareAmount = source.readString();
            this.skuNum = source.readString();
            this.totalAmount = source.readString();
            this.userOrderSpuDTO = source.readParcelable(UserOrderSpuDTOBean.class.getClassLoader());
        }

        public OrderDetailListBean() {
        }

        protected OrderDetailListBean(Parcel in) {
            this.id = in.readString();
            this.shareAmount = in.readString();
            this.skuNum = in.readString();
            this.totalAmount = in.readString();
            this.userOrderSpuDTO = in.readParcelable(UserOrderSpuDTOBean.class.getClassLoader());
        }

        public static final Parcelable.Creator<OrderDetailListBean> CREATOR = new Parcelable.Creator<OrderDetailListBean>() {
            @Override
            public OrderDetailListBean createFromParcel(Parcel source) {
                return new OrderDetailListBean(source);
            }

            @Override
            public OrderDetailListBean[] newArray(int size) {
                return new OrderDetailListBean[size];
            }
        };
    }
}
