package com.jxxx.gyl.view.adapter;

import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.ShopInfoData;
import com.jxxx.gyl.bean.HomeActivityData;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.view.activity.ShopDetailsActivity;
import com.jxxx.gyl.view.activity.mine.WebViewActivity;

import java.util.List;

public class HomeGoodsAdapter extends BaseQuickAdapter<HomeActivityData, BaseViewHolder> {

    public HomeGoodsAdapter(List<HomeActivityData> data) {
        super(R.layout.item_home_goodes, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeActivityData item) {
        if (item.getActivityType().equals("1")) {
            ShopInfoData data = item.getData();
            helper.setGone(R.id.rl1, false).setGone(R.id.rl_contact, true);
            if (data.getSkus() != null && data.getSkus().size() > 0) {
                helper.setText(R.id.tv_name, data.getSpuName());
                GlideImageLoader.loadImageViewRadius(mContext, data.getIconUrl(), helper.getView(R.id.iv_img));
                if (data.getSpuSupplyType().equals("1")) {
                    helper.setText(R.id.tv_spuSupplyType, "自营");
                } else if (data.getSpuSupplyType().equals("2")) {
                    helper.setText(R.id.tv_spuSupplyType, "供应商");
                }
                helper.setText(R.id.tv_price, "无价格");
                if (data.getPriceInfo() != null) {
                    helper.setText(R.id.tv_price, data.getPriceInfo().getPrice());
                }
                if (data.getSkus() != null) {
                    String skuName = "";
                    for (int i = 0; i < data.getSkus().size(); i++) {
                        if (i == 0) {
                            skuName = data.getSkus().get(i).getSkuName();
                        } else {
                            skuName = skuName + "|" + data.getSkus().get(i).getSkuName();
                        }
                    }
                    if (StringUtil.isBlank(skuName)) {
                        for (int i = 0; i < data.getSkus().size(); i++) {
                            if (i == 0) {
                                skuName = data.getSkus().get(i).getSkuUnit();
                            } else {
                                skuName = skuName + "|" + data.getSkus().get(i).getSkuUnit();
                            }
                        }
                    }
                    helper.setText(R.id.tv_type, skuName);
//                helper.setGone(R.id.tv_add,false).setGone(R.id.iv_add,false);
//                if(data.getSkus().size()>1){
//                    helper.setGone(R.id.tv_add,true).setGone(R.id.iv_add,false);
//                }else{
//                    helper.setGone(R.id.tv_add,false).setGone(R.id.iv_add,true);
//                }
                    helper.setGone(R.id.tv_add, false).setGone(R.id.iv_add, true);
                }
            }
        } else if (item.getActivityType().equals("2")) {
            helper.setGone(R.id.rl1, true).setGone(R.id.rl_contact, false)
                    .setText(R.id.tv_1, item.getContent())
                    .setText(R.id.tv_2, item.getTitle());
            GlideImageLoader.loadImageViewRadius(mContext, item.getImageUrl(), 30, helper.getView(R.id.siv_img));
        }

        helper.getView(R.id.rl1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, WebViewActivity.class);
                mIntent.putExtra("type", item.getRelateContent());
                mContext.startActivity(mIntent);
            }
        });

        helper.getView(R.id.rl_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopDetailsActivity.startActivityIntent(mContext, item.getData().getId());
            }
        });
    }
}
