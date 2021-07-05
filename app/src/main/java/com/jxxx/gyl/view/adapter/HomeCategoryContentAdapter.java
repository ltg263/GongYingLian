package com.jxxx.gyl.view.adapter;

import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.ShopInfoData;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.utils.view.PopupWindowSkus;
import com.jxxx.gyl.view.activity.ShopDetailsActivity;

import java.util.List;

public class HomeCategoryContentAdapter extends BaseQuickAdapter<ShopInfoData, BaseViewHolder> {


    public HomeCategoryContentAdapter(List<ShopInfoData> data) {
        super(R.layout.include_item_shop, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopInfoData item) {
        GlideImageLoader.loadImageViewRadius(mContext,item.getIconUrl(),30,helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_name,item.getSpuName());
        RecyclerView mRvSkus = helper.getView(R.id.rv_skus);
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
            helper.setText(R.id.tv_type,skuName).setGone(R.id.tv_add,false).setGone(R.id.iv_add,false);
            if(item.getSkus().size()>1){
                helper.setGone(R.id.tv_add,true).setGone(R.id.iv_add,false);
            }else{
                helper.setGone(R.id.tv_add,false).setGone(R.id.iv_add,true);
            }
            mRvSkus.setAdapter(new GoodsSkusAdapter(item.getSkus(),item.getSpuSupplyType()));
        }

        helper.getView(R.id.rl_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopDetailsActivity.startActivityIntent(mContext, item.getId());
            }
        });

        helper.getView(R.id.tv_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mRvSkus.getVisibility()==View.VISIBLE){
                    mRvSkus.setVisibility(View.GONE);
                    helper.setVisible(R.id.tv_spuSupplyType,true);
                }else{
                    mRvSkus.setVisibility(View.VISIBLE);
                    helper.setVisible(R.id.tv_spuSupplyType,false);
                }
//                popupWindw(helper.getView(R.id.tv_add),item.getSkus(),item.getIconUrl());
            }
        });

        helper.getView(R.id.iv_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    PopupWindowSkus window;

    private void popupWindw(View view,List<ShopInfoData.SkusBean> skus,String iconUrl) {
        window = new PopupWindowSkus(mContext, skus, iconUrl,new PopupWindowSkus.GiveDialogInterface() {
            @Override
            public void btnConfirm(ShopInfoData.SkusBean bean) {
            }
        });
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        window.setOutsideTouchable(true);
        window.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

}
