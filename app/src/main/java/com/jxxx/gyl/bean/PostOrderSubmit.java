package com.jxxx.gyl.bean;

public class PostOrderSubmit {

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

    public static class DedicatedReceiptInfoBean {
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
}
