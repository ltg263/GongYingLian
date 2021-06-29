package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.utils.GlideImageLoader;

import java.util.List;

public class ShopCarGoodsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ShopCarGoodsAdapter(List<String> data) {
        super(R.layout.item_shop_car_goodes, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        String str="http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg";
        GlideImageLoader.loadImageViewRadius(mContext,str,30,helper.getView(R.id.iv_img));
    }

}
