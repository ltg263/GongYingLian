package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.CommodityCategory;

import java.util.List;

public class HomeCategoryChildAdapter extends BaseQuickAdapter<CommodityCategory.SubListBean, BaseViewHolder> {
    int curPos = 0;

    public HomeCategoryChildAdapter(List<CommodityCategory.SubListBean> data) {
        super(R.layout.item_type_category_child, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityCategory.SubListBean item) {
        helper.setText(R.id.tv_name,item.getCateName()).setBackgroundColor(R.id.tv_name,0);
        if(curPos==helper.getLayoutPosition()){
            helper.setText(R.id.tv_name,item.getCateName()).setBackgroundColor(R.id.tv_name,mContext.getResources().getColor(R.color.white));
        }
    }

    public void setCurPos(int curPos) {
        this.curPos = curPos;
    }
}
