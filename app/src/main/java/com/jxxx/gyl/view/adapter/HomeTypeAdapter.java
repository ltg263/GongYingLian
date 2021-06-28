package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class HomeTypeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HomeTypeAdapter(List<String> data) {
        super(R.layout.item_home_type, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_name,item);
    }

}
