package com.jxxx.gyl.view.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.ShopInfoData;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.view.activity.ShopDetailsActivity;

import java.util.List;

public class GoodsSkusAdapter extends BaseQuickAdapter<ShopInfoData.SkusBean, BaseViewHolder> {
    String spuSupplyType;
    @Override
    protected void convert(BaseViewHolder helper, ShopInfoData.SkusBean data) {
//        GlideImageLoader.loadImageViewRadius(mContext,iconUrl,30,helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_type,data.getSkuName()).setText(R.id.tv_price,data.getSkuUnit());
        helper.getView(R.id.rl_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopDetailsActivity.startActivityIntent(mContext, data.getId());
            }
        });

        if(spuSupplyType.equals("1")){
            helper.setText(R.id.tv_spuSupplyType,"自营");
        }else if(spuSupplyType.equals("2")){
            helper.setText(R.id.tv_spuSupplyType,"供应商");
        }
    }

    public GoodsSkusAdapter(List<ShopInfoData.SkusBean> data,String spuSupplyType) {
        super(R.layout.item_shop_skus, data);
        this.spuSupplyType = spuSupplyType;
    }
}
