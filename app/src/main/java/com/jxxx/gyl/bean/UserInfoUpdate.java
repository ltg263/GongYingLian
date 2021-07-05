package com.jxxx.gyl.bean;

public class UserInfoUpdate {

    /**
     * baseInfo : {"auditStatus":0,"businessCategoryId":0,"businessStatus":0,"id":0,"level":"","realName":"","selfInvitationCode":"","storefrontAddress":"","storefrontDetailedAddress":"","storefrontImageUrl":"","storefrontName":"","subbranchName":"","superInvitationCode":""}
     */

    private BaseInfoBean baseInfo;

    public BaseInfoBean getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfoBean baseInfo) {
        this.baseInfo = baseInfo;
    }

    public static class BaseInfoBean {
        /**
         * auditStatus : 0
         * businessCategoryId : 0
         * businessStatus : 0
         * id : 0
         * level :
         * realName :
         * selfInvitationCode :
         * storefrontAddress :
         * storefrontDetailedAddress :
         * storefrontImageUrl :
         * storefrontName :
         * subbranchName :
         * superInvitationCode :
         */

        private String auditStatus;
        private String businessCategoryId;
        private String businessStatus;
        private String id;
        private String level;
        private String realName;
        private String selfInvitationCode;
        private String storefrontAddress;
        private String storefrontDetailedAddress;
        private String storefrontImageUrl;
        private String storefrontName;
        private String subbranchName;
        private String superInvitationCode;

        public String getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(String auditStatus) {
            this.auditStatus = auditStatus;
        }

        public String getBusinessCategoryId() {
            return businessCategoryId;
        }

        public void setBusinessCategoryId(String businessCategoryId) {
            this.businessCategoryId = businessCategoryId;
        }

        public String getBusinessStatus() {
            return businessStatus;
        }

        public void setBusinessStatus(String businessStatus) {
            this.businessStatus = businessStatus;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getSelfInvitationCode() {
            return selfInvitationCode;
        }

        public void setSelfInvitationCode(String selfInvitationCode) {
            this.selfInvitationCode = selfInvitationCode;
        }

        public String getStorefrontAddress() {
            return storefrontAddress;
        }

        public void setStorefrontAddress(String storefrontAddress) {
            this.storefrontAddress = storefrontAddress;
        }

        public String getStorefrontDetailedAddress() {
            return storefrontDetailedAddress;
        }

        public void setStorefrontDetailedAddress(String storefrontDetailedAddress) {
            this.storefrontDetailedAddress = storefrontDetailedAddress;
        }

        public String getStorefrontImageUrl() {
            return storefrontImageUrl;
        }

        public void setStorefrontImageUrl(String storefrontImageUrl) {
            this.storefrontImageUrl = storefrontImageUrl;
        }

        public String getStorefrontName() {
            return storefrontName;
        }

        public void setStorefrontName(String storefrontName) {
            this.storefrontName = storefrontName;
        }

        public String getSubbranchName() {
            return subbranchName;
        }

        public void setSubbranchName(String subbranchName) {
            this.subbranchName = subbranchName;
        }

        public String getSuperInvitationCode() {
            return superInvitationCode;
        }

        public void setSuperInvitationCode(String superInvitationCode) {
            this.superInvitationCode = superInvitationCode;
        }
    }
}

