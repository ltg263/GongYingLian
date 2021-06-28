package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.CommodityCategory;

import java.util.List;

public class HomeCategoryParentAdapter extends BaseQuickAdapter<CommodityCategory.ListBean, BaseViewHolder> {
    int curPos = 0;

    public HomeCategoryParentAdapter(List<CommodityCategory.ListBean> data) {
        super(R.layout.item_type_category_parent, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityCategory.ListBean item) {
        helper.setText(R.id.tv_name,item.getCategoryName()).setVisible(R.id.view,false);
        if(curPos==helper.getLayoutPosition()){
            helper.setVisible(R.id.view,true);
        }
    }

    public void setCurPos(int curPos) {
        this.curPos = curPos;
    }
}
