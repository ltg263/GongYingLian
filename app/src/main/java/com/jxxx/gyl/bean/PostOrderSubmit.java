package com.jxxx.gyl.bean;

import java.io.Serializable;
import java.util.List;

public class PostOrderSubmit implements Serializable {

    /**
     * dedicatedReceiptInfo : {"account":"1","address":"1","bank":"1","bankPhone":"1","contact":"1","detailsAddress":"1","phone":"1","ratepayerNo":"1","receiptTitle":"1","region":"1"}
     * generalReceiptInfo : {"account":"1","address":"1","bank":"1","bankPhone":"1","contact":"1","detailsAddress":"1","phone":"1","ratepayerNo":"1","receiptTitle":"1","region":"1"}
     * innerOrderNo : 454158125549748224
     * payChannel : WECHAT
     * receiptType : 0
     * shippingAddressId : 5
     * userCouponId : 2
     * userRemark : 要新鲜要新新鲜鲜
     */

    private DedicatedReceiptInfoBean dedicatedReceiptInfo;
    private DedicatedReceiptInfoBean generalReceiptInfo;
    private String innerOrderNo;
    private String payChannel;
    private String receiptType;
    private String shippingAddressId;
    private String userCouponId;
    private String userRemark;

    @Override
    public String toString() {
        return "PostOrderSubmit{" +
                "dedicatedReceiptInfo=" + dedicatedReceiptInfo +
                ", generalReceiptInfo=" + generalReceiptInfo +
                ", innerOrderNo='" + innerOrderNo + '\'' +
                ", payChannel='" + payChannel + '\'' +
                ", receiptType='" + receiptType + '\'' +
                ", shippingAddressId='" + shippingAddressId + '\'' +
                ", userCouponId='" + userCouponId + '\'' +
                ", userRemark='" + userRemark + '\'' +
                '}';
    }

    public DedicatedReceiptInfoBean getDedicatedReceiptInfo() {
        return dedicatedReceiptInfo;
    }

    public void setDedicatedReceiptInfo(DedicatedReceiptInfoBean dedicatedReceiptInfo) {
        this.dedicatedReceiptInfo = dedicatedReceiptInfo;
    }

    public DedicatedReceiptInfoBean getGeneralReceiptInfo() {
        return generalReceiptInfo;
    }

    public void setGeneralReceiptInfo(DedicatedReceiptInfoBean generalReceiptInfo) {
        this.generalReceiptInfo = generalReceiptInfo;
    }

    public String getInnerOrderNo() {
        return innerOrderNo;
    }

    public void setInnerOrderNo(String innerOrderNo) {
        this.innerOrderNo = innerOrderNo;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public String getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(String shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(String userCouponId) {
        this.userCouponId = userCouponId;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public static class DedicatedReceiptInfoBean implements Serializable{
        @Override
        public String toString() {
            return "DedicatedReceiptInfoBean{" +
                    "account='" + account + '\'' +
                    ", address='" + address + '\'' +
                    ", bank='" + bank + '\'' +
                    ", bankPhone='" + bankPhone + '\'' +
                    ", contact='" + contact + '\'' +
                    ", detailsAddress='" + detailsAddress + '\'' +
                    ", phone='" + phone + '\'' +
                    ", ratepayerNo='" + ratepayerNo + '\'' +
                    ", receiptTitle='" + receiptTitle + '\'' +
                    ", region='" + region + '\'' +
                    '}';
        }

        /**
         * account : 1
         * address : 1
         * bank : 1
         * bankPhone : 1
         * contact : 1
         * detailsAddress : 1
         * phone : 1
         * ratepayerNo : 1
         * receiptTitle : 1
         * region : 1
         */

        private String account;
        private String address;
        private String bank;
        private String bankPhone;
        private String contact;
        private String detailsAddress;
        private String phone;
        private String ratepayerNo;
        private String receiptTitle;
        private String region;

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

        public String getBankPhone() {
            return bankPhone;
        }

        public void setBankPhone(String bankPhone) {
            this.bankPhone = bankPhone;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getDetailsAddress() {
            return detailsAddress;
        }

        public void setDetailsAddress(String detailsAddress) {
            this.detailsAddress = detailsAddress;
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

        public String getReceiptTitle() {
            return receiptTitle;
        }

        public void setReceiptTitle(String receiptTitle) {
            this.receiptTitle = receiptTitle;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }

    public static class PayCreate{

        @Override
        public String toString() {
            return "PayCreate{" +
                    "innerOrderNo='" + innerOrderNo + '\'' +
                    ", orderAmount='" + orderAmount + '\'' +
                    ", orderType='" + orderType + '\'' +
                    ", payChannel='" + payChannel + '\'' +
                    '}';
        }

        /**
         * innerOrderNo : OR1212212122
         * orderAmount : 100.01
         * orderType : PURCHASE
         * payChannel : WECHAT
         */

        private String innerOrderNo;
        private String orderAmount;
        private String orderType;
        private String payChannel;

        public String getInnerOrderNo() {
            return innerOrderNo;
        }

        public void setInnerOrderNo(String innerOrderNo) {
            this.innerOrderNo = innerOrderNo;
        }

        public String getOrderAmount() {
            return orderAmount;
        }

        public void setOrderAmount(String orderAmount) {
            this.orderAmount = orderAmount;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public String getPayChannel() {
            return payChannel;
        }

        public void setPayChannel(String payChannel) {
            this.payChannel = payChannel;
        }
    }
    public static class OrderCancel{

        /**
         * cancelDesc : 拍错了
         * innerOrderNo : 454158125549748224
         */

        private String cancelDesc;
        private String innerOrderNo;

        public String getCancelDesc() {
            return cancelDesc;
        }

        public void setCancelDesc(String cancelDesc) {
            this.cancelDesc = cancelDesc;
        }

        public String getInnerOrderNo() {
            return innerOrderNo;
        }

        public void setInnerOrderNo(String innerOrderNo) {
            this.innerOrderNo = innerOrderNo;
        }
    }
    public static class RefundHistory{

        /**
         * current : 1
         * orders : [{"asc":false,"column":"id"}]
         * size : 10
         * status : 1
         */

        private int current;
        private int size;
        private int status;
        private List<OrdersBean> orders;

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public List<OrdersBean> getOrders() {
            return orders;
        }

        public void setOrders(List<OrdersBean> orders) {
            this.orders = orders;
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
    }
}
