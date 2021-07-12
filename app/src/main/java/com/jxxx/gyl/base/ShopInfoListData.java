package com.jxxx.gyl.base;


import java.util.List;

public class ShopInfoListData {

    /**
     * recommendList : [{"iconUrl":"","id":"","offSaleTime":"","skus":[{"id":"","levelPrice":{"level":"","skuId":0,"skuLevelPrice":0},"skuImage":"","skuName":"","skuSaleNum":0,"skuUnit":"","spuId":"","stockNum":0}],"spuDesc":"","spuImgs":"","spuName":"","spuParams":"","spuPrice":0,"spuSaleNum":0,"spuSelfSupply":false,"spuShortDesc":"","supplierId":"","supplierName":""}]
     * relatedList : [{}]
     * spu : {}
     */

    private ShopInfoData spu;
    private List<ShopInfoData> recommendList;
    private List<ShopInfoData> relatedList;

    public ShopInfoData getSpu() {
        return spu;
    }

    public void setSpu(ShopInfoData spu) {
        this.spu = spu;
    }

    public List<ShopInfoData> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<ShopInfoData> recommendList) {
        this.recommendList = recommendList;
    }

    public List<ShopInfoData> getRelatedList() {
        return relatedList;
    }

    public void setRelatedList(List<ShopInfoData> relatedList) {
        this.relatedList = relatedList;
    }
}
