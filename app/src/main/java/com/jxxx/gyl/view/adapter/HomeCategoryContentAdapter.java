package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.CommodityCategory;

import java.util.List;

public class HomeCategoryContentAdapter extends BaseQuickAdapter<CommodityCategory.ListBean.ChildrenBean, BaseViewHolder> {

    public HomeCategoryContentAdapter(List<CommodityCategory.ListBean.ChildrenBean> data) {
        super(R.layout.item_shop_contnt, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityCategory.ListBean.ChildrenBean item) {
    }

}
