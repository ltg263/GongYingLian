package com.jxxx.gyl.bean;

import java.util.List;

import com.contrarywind.interfaces.IPickerViewData;

public class CategoryTreeData {

    private List<CategoryListBean> categoryList;

    public List<CategoryListBean> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryListBean> categoryList) {
        this.categoryList = categoryList;
    }

    public static class CategoryListBean implements IPickerViewData {
        /**
         * id : 1
         * pid : 0
         * categoryName : 餐饮-火锅
         * sortValue : 0
         * children : [{"id":2,"pid":1,"categoryName":"川味/重庆火锅","sortValue":1,"children":[]},{"id":4,"pid":1,"categoryName":"云南火锅","sortValue":2,"children":[]},{"id":3,"pid":1,"categoryName":"羊蝎子火锅","sortValue":3,"children":[]},{"id":5,"pid":1,"categoryName":"老北京火锅","sortValue":4,"children":[]}]
         */

        private String id;
        private String pid;
        private String categoryName;
        private String sortValue;
        private List<ChildrenBean> children;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getSortValue() {
            return sortValue;
        }

        public void setSortValue(String sortValue) {
            this.sortValue = sortValue;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        @Override
        public String getPickerViewText() {
            return categoryName;
        }

        public static class ChildrenBean  implements IPickerViewData {
            /**
             * id : 2
             * pid : 1
             * categoryName : 川味/重庆火锅
             * sortValue : 1
             */

            private String id;
            private String pid;
            private String categoryName;
            private String sortValue;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public String getSortValue() {
                return sortValue;
            }

            public void setSortValue(String sortValue) {
                this.sortValue = sortValue;
            }

            @Override
            public String getPickerViewText() {
                return categoryName;
            }
        }
    }
}
