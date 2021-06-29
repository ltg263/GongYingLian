package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.CommodityCategory;

import java.util.List;

public class HomeTypeAdapter extends BaseQuickAdapter<CommodityCategory.ListBean, BaseViewHolder> {

    public HomeTypeAdapter(List<CommodityCategory.ListBean> data) {
        super(R.layout.item_home_type, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityCategory.ListBean item) {
        helper.setText(R.id.tv_name,item.getCategoryName());
        if(helper.getLayoutPosition()==9){
            helper.setText(R.id.tv_name,"全部分类");
        }
//        GlideImageLoader.loadImageViewRadius(mContext,item.getImage(),helper.getView(R.id.iv_img));
    }

}
