package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.CommodityCategory;
import com.jxxx.gyl.bean.HomeCategoryData;
import com.jxxx.gyl.utils.GlideImageLoader;

import java.util.List;

public class HomeTypeAdapter extends BaseQuickAdapter<HomeCategoryData, BaseViewHolder> {

    public HomeTypeAdapter(List<HomeCategoryData> data) {
        super(R.layout.item_home_type, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeCategoryData item) {
        helper.setText(R.id.tv_name,item.getCateName());
        if(helper.getLayoutPosition()==9){
            helper.setText(R.id.tv_name,"全部分类");
        }
        GlideImageLoader.loadImageViewRadius(mContext,item.getImageUrl(),helper.getView(R.id.iv_img));
    }

}
