package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class HomeGoodsGzAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    int curPos = 0;

    public void setCurPos(int curPos) {
        this.curPos = curPos;
    }

    public HomeGoodsGzAdapter(List<String> data) {
        super(R.layout.item_home_goodes_gz, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setBackgroundRes(R.id.ll,R.drawable.circle_solid_f4f4f4_5)
                .setTextColor(R.id.tv_gz1,mContext.getResources().getColor(R.color.color_333333))
                .setTextColor(R.id.tv_gz2,mContext.getResources().getColor(R.color.color_666666));
        if(helper.getLayoutPosition()==curPos){
            helper.setBackgroundRes(R.id.ll,R.drawable.circle_solid_theme_5)
                    .setTextColor(R.id.tv_gz1,mContext.getResources().getColor(R.color.white))
                    .setTextColor(R.id.tv_gz2,mContext.getResources().getColor(R.color.white));
        }
    }
}
