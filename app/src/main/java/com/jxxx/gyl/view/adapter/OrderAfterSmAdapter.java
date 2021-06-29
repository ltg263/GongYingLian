package com.jxxx.gyl.view.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class OrderAfterSmAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    int curPos = -1;
    public OrderAfterSmAdapter(List<String> data) {
        super(R.layout.item_order_after_sm, data);
    }

    public void setCurPos(int curPos) {
        this.curPos = curPos;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_title,item);
        ImageView iv_select = helper.getView(R.id.iv_select);
        iv_select.setSelected(false);
        if(helper.getLayoutPosition()==curPos){
            iv_select.setSelected(true);
        }
    }

}
