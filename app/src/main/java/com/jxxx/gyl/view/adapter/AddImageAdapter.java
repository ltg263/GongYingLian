package com.jxxx.gyl.view.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.ImageUrlBean;
import com.jxxx.gyl.utils.GlideImageLoader;

import java.util.List;

public class AddImageAdapter extends BaseQuickAdapter<ImageUrlBean, BaseViewHolder> {

    public AddImageAdapter(List<ImageUrlBean> data) {
        super(R.layout.item_image_add, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ImageUrlBean item) {
        helper.setImageResource(R.id.image_view,R.drawable.group_521).setVisible(R.id.iv_delete,false);
        if(item!=null){
            GlideImageLoader.loadImageAndDefault(mContext,item.getImgUrl(), (ImageView) helper.getView(R.id.image_view));
            helper.addOnClickListener(R.id.iv_delete).setVisible(R.id.iv_delete,true);
        }
    }

}
