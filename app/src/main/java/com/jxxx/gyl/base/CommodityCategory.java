package com.jxxx.gyl.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AlienChao
 * @date 2020/05/15 11:27
 */
public class CommodityCategory {

    private List<ListBean> list;

    public List<ListBean> getList() {
        if (list == null) {
            list= new ArrayList<>();
        }
        if (list.size()==0) {
            list.add(new ListBean());
        }

        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * categoryId : 1
         * categoryName : 肉食品
         * categoryOrder : 1
         * children : [{"categoryId":3,"categoryName":"猪肉","categoryOrder":1,"id":9,"image":"https://app.nbningjiang.com/ningjiangshengxian/upload/category-default.png","parentId":1,"siteId":2},{"categoryId":5,"categoryName":"羊肉","categoryOrder":3,"id":2,"image":"https://app.nbningjiang.com/ningjiangshengxian/upload/category-default.png","parentId":1,"siteId":2}]
         * image : https://app.nbningjiang.com/ningjiangshengxian/upload/category-default.png
         */

        private int categoryId;
        private String categoryName;
        private int categoryOrder;
        private String image;
        private List<ChildrenBean> children;
        private boolean isCheck=false;

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public int getCategoryOrder() {
            return categoryOrder;
        }

        public void setCategoryOrder(int categoryOrder) {
            this.categoryOrder = categoryOrder;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<ChildrenBean> getChildren() {
            if (children == null) {
                return new ArrayList<>();
            }
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * categoryId : 3
             * categoryName : 猪肉
             * categoryOrder : 1
             * id : 9
             * image : https://app.nbningjiang.com/ningjiangshengxian/upload/category-default.png
             * parentId : 1
             * siteId : 2
             */

            private int categoryId;
            private String categoryName;
            private String siteName;
            private int categoryOrder;
            private int id;
            private String image;
            private int parentId;
            private int siteId;
            private boolean isCheck=false;

            public String getSiteName() {
                return siteName == null ? "" : siteName;
            }

            public void setSiteName(String siteName) {
                this.siteName = siteName;
            }

            public boolean isCheck() {
                return isCheck;
            }

            public ChildrenBean setCheck(boolean check) {
                isCheck = check;
                return this;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public int getCategoryOrder() {
                return categoryOrder;
            }

            public void setCategoryOrder(int categoryOrder) {
                this.categoryOrder = categoryOrder;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public int getSiteId() {
                return siteId;
            }

            public void setSiteId(int siteId) {
                this.siteId = siteId;
            }
        }
    }
}
