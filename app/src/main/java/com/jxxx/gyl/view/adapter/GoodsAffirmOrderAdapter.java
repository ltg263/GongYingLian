package com.jxxx.gyl.view.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.ShopInfoData;
import com.jxxx.gyl.bean.OrderPreviewBean;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.view.activity.ShopDetailsActivity;

import java.util.List;

public class GoodsAffirmOrderAdapter extends BaseQuickAdapter<OrderPreviewBean.PreviewOrderDTOBean.OrderDetailListBean, BaseViewHolder> {
    @Override
    protected void convert(BaseViewHolder helper, OrderPreviewBean.PreviewOrderDTOBean.OrderDetailListBean data) {
        OrderPreviewBean.PreviewOrderDTOBean.OrderDetailListBean.PreviewOrderSpuDTOBean mData = data.getPreviewOrderSpuDTO();
        GlideImageLoader.loadImageViewRadius(mContext,mData.getIconUrl(),30,helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_type,mData.getSpuName())
                .setText(R.id.tv_price,"￥"+mData.getPreviewOrderSkuDTO().getSkuPriceDTO().getSkuPrice()+mData.getPreviewOrderSkuDTO().getSkuPriceDTO().getUnit())
        .addOnClickListener(R.id.iv_add);
        helper.getView(R.id.rl_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopDetailsActivity.startActivityIntent(mContext, mData.getId());
            }
        });

    }

    public GoodsAffirmOrderAdapter(List<OrderPreviewBean.PreviewOrderDTOBean.OrderDetailListBean> data) {
        super(R.layout.item_shop_order, data);
    }
}
