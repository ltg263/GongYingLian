package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class OrderShopAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public OrderShopAdapter(List<String> data) {
        super(R.layout.item_order_shop, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
    }

}
