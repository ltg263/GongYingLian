package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class MineListJdAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MineListJdAdapter(List<String> data) {
        super(R.layout.item_mine_jd, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.bnt_lx).addOnClickListener(R.id.bnt_jd);
    }

}
