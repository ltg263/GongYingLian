package com.jxxx.gyl.bean;

import java.util.List;

public class OrderRefundHistoryBean {

    /**
     * current : 0
     * hitCount : true
     * optimizeCountSql : true
     * orders : [{"asc":false,"column":"id"}]
     * records : [{"auditUserId":0,"createTime":"","createUser":0,"deleted":0,"extension":"","fromOrderStatus":"","id":0,"innerOrderNo":"","refundAmount":0,"refundDesc":"","refundNo":"","remark":"","status":0,"tenantId":0,"type":0,"updateTime":"","updateUser":0,"userId":0}]
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
         * auditUserId : 0
         * createTime :
         * createUser : 0
         * deleted : 0
         * extension :
         * fromOrderStatus :
         * id : 0
         * innerOrderNo :
         * refundAmount : 0
         * refundDesc :
         * refundNo :
         * remark :
         * status : 0
         * tenantId : 0
         * type : 0
         * updateTime :
         * updateUser : 0
         * userId : 0
         */

        private String auditUserId;
        private String createTime;
        private String createUser;
        private String deleted;
        private String extension;
        private String fromOrderStatus;
        private String id;
        private String innerOrderNo;
        private String refundAmount;
        private String refundDesc;
        private String refundNo;
        private String remark;
        private String status;
        private String tenantId;
        private String type;
        private String updateTime;
        private String updateUser;
        private String userId;

        public String getAuditUserId() {
            return auditUserId;
        }

        public void setAuditUserId(String auditUserId) {
            this.auditUserId = auditUserId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateUser() {
            return createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        public String getFromOrderStatus() {
            return fromOrderStatus;
        }

        public void setFromOrderStatus(String fromOrderStatus) {
            this.fromOrderStatus = fromOrderStatus;
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

        public String getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(String refundAmount) {
            this.refundAmount = refundAmount;
        }

        public String getRefundDesc() {
            return refundDesc;
        }

        public void setRefundDesc(String refundDesc) {
            this.refundDesc = refundDesc;
        }

        public String getRefundNo() {
            return refundNo;
        }

        public void setRefundNo(String refundNo) {
            this.refundNo = refundNo;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateUser() {
            return updateUser;
        }

        public void setUpdateUser(String updateUser) {
            this.updateUser = updateUser;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
