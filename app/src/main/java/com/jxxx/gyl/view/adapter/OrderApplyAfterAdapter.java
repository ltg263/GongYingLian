package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class OrderApplyAfterAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public OrderApplyAfterAdapter(List<String> data) {
        super(R.layout.item_order_apply_after, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
