package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class MineListHtAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MineListHtAdapter(List<String> data) {
        super(R.layout.item_mine_ht, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.bnt_jy).addOnClickListener(R.id.bnt_xy).addOnClickListener(R.id.bnt_zd);
    }

}
