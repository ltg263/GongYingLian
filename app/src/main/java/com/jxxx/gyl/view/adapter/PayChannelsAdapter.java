package com.jxxx.gyl.view.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.ChannelsListBean;
import com.jxxx.gyl.utils.GlideImageLoader;

import java.util.List;

public class PayChannelsAdapter extends BaseQuickAdapter<ChannelsListBean, BaseViewHolder> {

    String channelCode = "";

    public PayChannelsAdapter(List<ChannelsListBean> data) {
        super(R.layout.item_pay_channdle, data);
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        notifyDataSetChanged();
    }

    public String getChannelCode() {
        return channelCode;
    }

    @Override
    protected void convert(BaseViewHolder helper, ChannelsListBean item) {
        GlideImageLoader.loadImageAndDefault(mContext,item.getChannelIcon(),helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_pay,item.getChannelName());
        ImageView iv_select_wx = helper.getView(R.id.iv_select_wx);
        iv_select_wx.setSelected(false);
        if(item.getChannelCode().equals(channelCode)){
            iv_select_wx.setSelected(true);
        }
    }

}
