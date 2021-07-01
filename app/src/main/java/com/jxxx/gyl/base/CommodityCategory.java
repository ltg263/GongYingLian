package com.jxxx.gyl.base;

import java.util.List;

/**
 * @author AlienChao
 * @date 2020/05/15 11:27
 */
public class CommodityCategory {

    /**
     * cateName :
     * iconUrl :
     * id :
     * imageUrl :
     * parentId :
     * subList : [{"cateName":"","iconUrl":"","id":"","imageUrl":"","parentId":""}]
     */

    private String cateName;
    private String iconUrl;
    private String id;
    private String imageUrl;
    private String parentId;
    private List<SubListBean> subList;

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<SubListBean> getSubList() {
        return subList;
    }

    public void setSubList(List<SubListBean> subList) {
        this.subList = subList;
    }

    public static class SubListBean {
        /**
         * cateName :
         * iconUrl :
         * id :
         * imageUrl :
         * parentId :
         */

        private String cateName;
        private String iconUrl;
        private String id;
        private String imageUrl;
        private String parentId;

        public String getCateName() {
            return cateName;
        }

        public void setCateName(String cateName) {
            this.cateName = cateName;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }
    }
}
