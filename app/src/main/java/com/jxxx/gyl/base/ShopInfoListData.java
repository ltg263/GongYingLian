package com.jxxx.gyl.base;


import java.util.List;

public class ShopInfoListData {

    /**
     * recommendList : [{"iconUrl":"","id":"","offSaleTime":"","skus":[{"id":"","levelPrice":{"level":"","skuId":0,"skuLevelPrice":0},"skuImage":"","skuName":"","skuSaleNum":0,"skuUnit":"","spuId":"","stockNum":0}],"spuDesc":"","spuImgs":"","spuName":"","spuParams":"","spuPrice":0,"spuSaleNum":0,"spuSelfSupply":false,"spuShortDesc":"","suppliersId":"","suppliersName":""}]
     * relatedList : [{}]
     * spu : {}
     */

    private SpuBean spu;
    private List<ShopInfoData> recommendList;
    private List<RelatedListBean> relatedList;

    public SpuBean getSpu() {
        return spu;
    }

    public void setSpu(SpuBean spu) {
        this.spu = spu;
    }

    public List<ShopInfoData> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<ShopInfoData> recommendList) {
        this.recommendList = recommendList;
    }

    public List<RelatedListBean> getRelatedList() {
        return relatedList;
    }

    public void setRelatedList(List<RelatedListBean> relatedList) {
        this.relatedList = relatedList;
    }

    public static class SpuBean {
    }
    public static class RelatedListBean {
    }
}
