package com.jxxx.gyl.bean;

import java.util.List;

public class RechargeAllBean {

    /**
     * list : [{"id":8,"amount":10,"giveAmount":0,"delTf":false,"status":1,"createTime":"2020-04-30T20:22:26.086+0800","explain":"优惠1"},{"id":12,"amount":50,"giveAmount":5,"delTf":false,"status":1,"createTime":"2020-05-15T10:31:51.237+0800","explain":"优惠4"},{"id":13,"amount":100,"giveAmount":10,"delTf":false,"status":1,"createTime":"2020-05-15T10:32:16.458+0800","explain":"优惠5"},{"id":14,"amount":1000,"giveAmount":50,"delTf":false,"status":1,"createTime":"2020-05-15T10:32:48.171+0800","explain":"优惠6"},{"id":10,"amount":20,"giveAmount":1,"delTf":false,"status":1,"createTime":"2020-05-15T10:31:29.511+0800","explain":"优惠2"},{"id":11,"amount":30,"giveAmount":2,"delTf":false,"status":1,"createTime":"2020-05-15T10:31:41.298+0800","explain":"优惠3"}]
     * totalCount : 0
     */

    private int totalCount;
    private List<ListBean> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 8
         * amount : 10
         * giveAmount : 0
         * delTf : false
         * status : 1
         * createTime : 2020-04-30T20:22:26.086+0800
         * explain : 优惠1
         */

        private int id;
        private int amount;
        private int giveAmount;
        private boolean delTf;
        private int status;
        private String createTime;
        private String explain;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getGiveAmount() {
            return giveAmount;
        }

        public void setGiveAmount(int giveAmount) {
            this.giveAmount = giveAmount;
        }

        public boolean isDelTf() {
            return delTf;
        }

        public void setDelTf(boolean delTf) {
            this.delTf = delTf;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }
    }
}
