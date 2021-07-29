package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.OrderHistoryBean;
import com.jxxx.gyl.bean.OrderHistoryDetailBean;
import com.jxxx.gyl.bean.OrderPreviewBean;
import com.jxxx.gyl.utils.GlideImageLoader;

import java.util.List;

public class OrderImageAdapter extends BaseQuickAdapter<OrderHistoryDetailBean.OrderDetailListBean, BaseViewHolder> {

    public OrderImageAdapter(List<OrderHistoryDetailBean.OrderDetailListBean> data) {
        super(R.layout.item_image_add, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderHistoryDetailBean.OrderDetailListBean item) {
            GlideImageLoader.loadImageAndDefault(mContext,item.getUserOrderSpuDTO().getIconUrl(), helper.getView(R.id.image_view));
            helper.setVisible(R.id.iv_delete,false);
    }

}
