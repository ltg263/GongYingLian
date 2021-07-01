package com.jxxx.gyl.view.adapter;

import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.ShopInfoData;
import com.jxxx.gyl.bean.HomeActivityData;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.view.activity.ShopDetailsActivity;
import com.jxxx.gyl.view.activity.mine.WebViewActivity;

import java.util.List;

public class HomeGoodsAdapter extends BaseQuickAdapter<HomeActivityData, BaseViewHolder> {

    public HomeGoodsAdapter(List<HomeActivityData> data) {
        super(R.layout.item_home_goodes, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeActivityData item) {
        ShopInfoData data = item.getData();
        if(item.getActivityType().equals("1")){
            helper.setGone(R.id.rl1,false).setGone(R.id.rl_contact,true)
                    .setText(R.id.tv_name,data.getSpuName());
            if(data.getSkus()!=null && data.getSkus().size()>0){
                GlideImageLoader.loadImageViewRadius(mContext,data.getSkus().get(0).getSkuImage(),30,helper.getView(R.id.iv_img));
                helper.setText(R.id.tv_type,data.getSkus().get(0).getSkuName());
                helper.setText(R.id.tv_price,"无价格");
                if(data.getSkus().get(0).getLevelPrice()==null){
                    helper.setText(R.id.tv_price,data.getSkus().get(0).getLevelPrice().getSkuLevelPrice());
                }
            }
        }else if(item.getActivityType().equals("2")){
            helper.setGone(R.id.rl1,true).setGone(R.id.rl_contact,false).setText(R.id.tv_1,item.getStartTime());
            GlideImageLoader.loadImageViewRadius(mContext,item.getImageUrl(),30,helper.getView(R.id.siv_img));
        }

        helper.getView(R.id.rl1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, WebViewActivity.class);
                mIntent.putExtra("type",item.getContent());
                mContext.startActivity(mIntent);
            }
        });

        helper.getView(R.id.rl_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ShopDetailsActivity.startActivityIntent(mContext,item.getData().getId());
            }
        });
    }
}
