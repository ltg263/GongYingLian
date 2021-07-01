package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.CommodityCategory;
import com.jxxx.gyl.base.ShopInfoData;

import java.util.List;

public class HomeCategoryContentAdapter extends BaseQuickAdapter<ShopInfoData, BaseViewHolder> {

    public HomeCategoryContentAdapter(List<ShopInfoData> data) {
        super(R.layout.include_item_shop, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopInfoData item) {
    }

}
