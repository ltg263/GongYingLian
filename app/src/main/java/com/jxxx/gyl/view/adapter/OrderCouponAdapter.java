package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class OrderCouponAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public OrderCouponAdapter(List<String> data) {
        super(R.layout.item_order_coupon, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
