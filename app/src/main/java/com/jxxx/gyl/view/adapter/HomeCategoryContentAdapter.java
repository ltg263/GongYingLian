package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.ShopInfoData;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.utils.StringUtil;

import java.util.List;

public class HomeCategoryContentAdapter extends BaseQuickAdapter<ShopInfoData, BaseViewHolder> {

    public HomeCategoryContentAdapter(List<ShopInfoData> data) {
        super(R.layout.include_item_shop, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopInfoData item) {
        GlideImageLoader.loadImageViewRadius(mContext,item.getIconUrl(),30,helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_name,item.getSpuName());

        if(item.getSpuSupplyType().equals("1")){
            helper.setText(R.id.tv_spuSupplyType,"自营");
        }else if(item.getSpuSupplyType().equals("2")){
            helper.setText(R.id.tv_spuSupplyType,"供应商");
        }
        helper.setText(R.id.tv_price,"无价格");
        if(item.getPriceInfo()!=null){
            helper.setText(R.id.tv_price,item.getPriceInfo().getPrice());
        }
        if(item.getSkus()!=null){
            String skuName = "";
            for(int i=0;i<item.getSkus().size();i++){
                if(i==0){
                    skuName = item.getSkus().get(i).getSkuName();
                }else{
                    skuName = skuName+"|"+item.getSkus().get(i).getSkuName();
                }
            }
            if(StringUtil.isBlank(skuName)){
                for(int i=0;i<item.getSkus().size();i++){
                    if(i==0){
                        skuName = item.getSkus().get(i).getSkuUnit();
                    }else{
                        skuName = skuName+"|"+item.getSkus().get(i).getSkuUnit();
                    }
                }
            }
            helper.setText(R.id.tv_type,skuName);
        }
    }

}
