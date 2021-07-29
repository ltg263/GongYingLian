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
    private List<OrderHistoryDetailBean> records;

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

    public List<OrderHistoryDetailBean> getRecords() {
        return records;
    }

    public void setRecords(List<OrderHistoryDetailBean> records) {
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
}
