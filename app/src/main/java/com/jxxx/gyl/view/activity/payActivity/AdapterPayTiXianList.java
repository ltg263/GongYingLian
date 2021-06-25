package com.jxxx.gyl.view.activity.payActivity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class AdapterPayTiXianList extends BaseQuickAdapter<String, BaseViewHolder> {

    public AdapterPayTiXianList(List<String> data) {
        super(R.layout.item_pay_ti_xian, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
    }

}
