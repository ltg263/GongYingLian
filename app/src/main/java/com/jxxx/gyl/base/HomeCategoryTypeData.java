package com.jxxx.gyl.base;

import java.util.List;

public class HomeCategoryTypeData {

    private List<ShopInfoData> spuList;
    private List<TagListBean> tagList;

    public List<ShopInfoData> getSpuList() {
        return spuList;
    }

    public void setSpuList(List<ShopInfoData> spuList) {
        this.spuList = spuList;
    }

    public List<TagListBean> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagListBean> tagList) {
        this.tagList = tagList;
    }

    public static class TagListBean {
        /**
         * id :
         * tagName :
         * tagType : 0
         */

        private String id;
        private String tagName;
        private int tagType;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public int getTagType() {
            return tagType;
        }

        public void setTagType(int tagType) {
            this.tagType = tagType;
        }
    }
}
