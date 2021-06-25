package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class MineListFylrAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public boolean isBianji = false;
    public MineListFylrAdapter(List<String> data) {
        super(R.layout.item_mine_fylr, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.bnt_1).addOnClickListener(R.id.bnt_2).addOnClickListener(R.id.bnt_3);
        helper.setGone(R.id.iv_select,false);
        if(isBianji){
            helper.setGone(R.id.iv_select,true);
        }
    }

    public void setBianji(boolean bianji) {
        isBianji = bianji;
    }
}
