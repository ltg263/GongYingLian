package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.OrderHistoryDetailBean;
import com.jxxx.gyl.utils.GlideImageLoader;

import java.util.List;

public class OrderShopAdapter extends BaseQuickAdapter<OrderHistoryDetailBean.OrderDetailListBean, BaseViewHolder> {

    public OrderShopAdapter(List<OrderHistoryDetailBean.OrderDetailListBean> data) {
        super(R.layout.item_order_shop, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderHistoryDetailBean.OrderDetailListBean item) {
        GlideImageLoader.loadImageViewRadius(mContext,item.getUserOrderSpuDTO().getIconUrl(),30,helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_title,item.getUserOrderSpuDTO().getSpuName())
                .setText(R.id.tv_num,item.getUserOrderSpuDTO().getPriceInfo().getUnit())
                .setText(R.id.tv_price,"￥"+item.getUserOrderSpuDTO().getPriceInfo().getPrice()+"×"+item.getSkuNum())
                .setText(R.id.tv_state,item.getUserOrderSpuDTO().getPriceInfo().getUnit()+"/"+"￥"+item.getUserOrderSpuDTO().getPriceInfo().getPrice());
    }

}
