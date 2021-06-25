package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class HomeMsgAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HomeMsgAdapter(List<String> data) {
        super(R.layout.item_home_msg, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
