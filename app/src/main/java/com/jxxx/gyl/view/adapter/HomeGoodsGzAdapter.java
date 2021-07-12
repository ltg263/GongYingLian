package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.ShopInfoData;

import java.util.List;

public class HomeGoodsGzAdapter extends BaseQuickAdapter<ShopInfoData.SkusBean, BaseViewHolder> {

    int curPos = 0;

    public void setCurPos(int curPos) {
        this.curPos = curPos;
    }

    public HomeGoodsGzAdapter(List<ShopInfoData.SkusBean> data) {
        super(R.layout.item_home_goodes_gz, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopInfoData.SkusBean item) {
        helper.setText(R.id.tv_skuName,item.getSkuName()).setText(R.id.tv_skuUnit,"无价格");
        if(item.getPriceInfo()!=null){
            helper.setText(R.id.tv_skuUnit,"￥"+item.getPriceInfo().getPrice()+item.getSkuUnit());
        }
        helper.setBackgroundRes(R.id.ll,R.drawable.circle_solid_f4f4f4_5)
                .setTextColor(R.id.tv_skuName,mContext.getResources().getColor(R.color.color_333333))
                .setTextColor(R.id.tv_skuUnit,mContext.getResources().getColor(R.color.color_666666));
        if(helper.getLayoutPosition()==curPos){
            helper.setBackgroundRes(R.id.ll,R.drawable.circle_solid_theme_5)
                    .setTextColor(R.id.tv_skuName,mContext.getResources().getColor(R.color.white))
                    .setTextColor(R.id.tv_skuUnit,mContext.getResources().getColor(R.color.white));
        }
    }
}
