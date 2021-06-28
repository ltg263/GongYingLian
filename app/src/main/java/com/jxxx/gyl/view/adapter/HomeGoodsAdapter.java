package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.utils.GlideImageLoader;

import java.util.List;

public class HomeGoodsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HomeGoodsAdapter(List<String> data) {
        super(R.layout.item_home_goodes, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        String str="http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg";

        helper.setGone(R.id.rl1,false).setGone(R.id.rl_contact,true);
        GlideImageLoader.loadImageViewRadius(mContext,str,15,helper.getView(R.id.iv_img));
        if(helper.getLayoutPosition()==0){
            GlideImageLoader.loadImageViewRadius(mContext,str,15,helper.getView(R.id.siv_img));
            helper.setGone(R.id.rl1,true).setGone(R.id.rl_contact,false);
        }
    }

}
