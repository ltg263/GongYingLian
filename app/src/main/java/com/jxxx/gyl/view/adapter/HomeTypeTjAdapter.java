package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class HomeTypeTjAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    int curPos = 0;

    public void setCurPos(int curPos) {
        this.curPos = curPos;
    }

    public HomeTypeTjAdapter(List<String> data) {
        super(R.layout.item_home_type_tj, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_title,item).setTextColor(R.id.tv_title,mContext.getResources().getColor(R.color.color_333333))
                .setTextColor(R.id.tv_state,mContext.getResources().getColor(R.color.color_666666))
                .setBackgroundRes(R.id.tv_state,0);

        if(curPos==helper.getLayoutPosition()){
            helper.setTextColor(R.id.tv_title,mContext.getResources().getColor(R.color.color_blue_theme))
                    .setTextColor(R.id.tv_state,mContext.getResources().getColor(R.color.white))
                    .setBackgroundRes(R.id.tv_state,R.drawable.circle_solid_theme_25);
        }


    }

}
