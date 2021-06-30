package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class MineCouponListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MineCouponListAdapter(List<String> data) {
        super(R.layout.item_mine_coupon, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
