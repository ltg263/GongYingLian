package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.ShopInfoData;
import com.jxxx.gyl.utils.GlideImageLoader;

import java.util.List;

public class HomeCategoryContentAdapter extends BaseQuickAdapter<ShopInfoData, BaseViewHolder> {

    public HomeCategoryContentAdapter(List<ShopInfoData> data) {
        super(R.layout.include_item_shop, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopInfoData item) {
        helper.setText(R.id.tv_name,item.getSpuName());
        if(item.getSkus()!=null){
            if(item.getSkus().size()>0){
                GlideImageLoader.loadImageViewRadius(mContext,item.getSkus().get(0).getSkuImage(),30,helper.getView(R.id.iv_img));
                helper.setText(R.id.tv_type,item.getSkus().get(0).getSkuName());
                helper.setText(R.id.tv_price,"无价格");
                if(item.getSkus().get(0).getLevelPrice()==null){
                    helper.setText(R.id.tv_price,item.getSkus().get(0).getLevelPrice().getSkuLevelPrice());
                }
            }
        }
    }

}
