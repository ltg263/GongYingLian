package com.jxxx.gyl.bean;

public class GlobalAdconfigBean {

    /**
     * indexPage : {"id":1,"positionCode":"indexPage","title":"首页广告位","content":null,"imageUrl":"https://tse1-mm.cn.bing.net/th/id/OIP-C.NmdXHefRPYfMk61ACChXCgHaE7?w=259&h=180&c=7&o=5&pid=1.7","redirectUrl":null,"status":1,"extension":null,"deleted":0,"createUser":0,"updateUser":0,"tenantId":0,"updateTime":"2021-07-05 15:36:33","createTime":"2021-07-05 15:36:33"}
     */

    private IndexPageBean indexPage;

    public IndexPageBean getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(IndexPageBean indexPage) {
        this.indexPage = indexPage;
    }

    public static class IndexPageBean {
        /**
         * id : 1
         * positionCode : indexPage
         * title : 首页广告位
         * content : null
         * imageUrl : https://tse1-mm.cn.bing.net/th/id/OIP-C.NmdXHefRPYfMk61ACChXCgHaE7?w=259&h=180&c=7&o=5&pid=1.7
         * redirectUrl : null
         * status : 1
         * extension : null
         * deleted : 0
         * createUser : 0
         * updateUser : 0
         * tenantId : 0
         * updateTime : 2021-07-05 15:36:33
         * createTime : 2021-07-05 15:36:33
         */

        private String id;
        private String positionCode;
        private String title;
        private String content;
        private String imageUrl;
        private String redirectUrl;
        private String status;
        private String extension;
        private String deleted;
        private String createUser;
        private String updateUser;
        private String tenantId;
        private String updateTime;
        private String createTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPositionCode() {
            return positionCode;
        }

        public void setPositionCode(String positionCode) {
            this.positionCode = positionCode;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getRedirectUrl() {
            return redirectUrl;
        }

        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getCreateUser() {
            return createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getUpdateUser() {
            return updateUser;
        }

        public void setUpdateUser(String updateUser) {
            this.updateUser = updateUser;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
