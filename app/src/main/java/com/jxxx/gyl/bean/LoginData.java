package com.jxxx.gyl.bean;

public class LoginData {
    /**
     * accessToken : {"accessToken":"1256","issue":0,"tokenExpire":18000}
     * auditStatus : 0未提交 1审核通过 2审核失败 3审核中
     * failureReason :
     * userId : 1
     */

    private AccessTokenBean accessToken;
    private String auditStatus;
    private String failureReason;
    private String userId;

    public AccessTokenBean getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessTokenBean accessToken) {
        this.accessToken = accessToken;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class AccessTokenBean {
        /**
         * accessToken : 1256
         * issue : 0
         * tokenExpire : 18000
         */

        private String accessToken;
        private String issue;
        private String tokenExpire;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        public String getTokenExpire() {
            return tokenExpire;
        }

        public void setTokenExpire(String tokenExpire) {
            this.tokenExpire = tokenExpire;
        }
    }
}

