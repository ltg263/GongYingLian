package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.utils.GlideImageLoader;

import java.util.List;

public class ShopImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ShopImageAdapter(List<String> data) {
        super(R.layout.item_image_add, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
            GlideImageLoader.loadImageAndDefault(mContext,item, helper.getView(R.id.image_view));
            helper.setVisible(R.id.iv_delete,false);
    }

}
