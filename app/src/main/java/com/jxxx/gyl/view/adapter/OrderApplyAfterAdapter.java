package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.OrderRefundHistoryBean;
import com.jxxx.gyl.utils.GlideImageLoader;

import java.util.List;

public class OrderApplyAfterAdapter extends BaseQuickAdapter<OrderRefundHistoryBean.RecordsBean, BaseViewHolder> {

    public OrderApplyAfterAdapter(List<OrderRefundHistoryBean.RecordsBean> data) {
        super(R.layout.item_order_apply_after, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderRefundHistoryBean.RecordsBean item) {
        String status = "";
        if(item.getStatus().equals("1")){
            status= "审核通过";
        }else  if(item.getStatus().equals("2")){
            status= "审核失败";
        }else  if(item.getStatus().equals("3")){
            status= "进行中";
        }
        GlideImageLoader.loadImageViewRadius(mContext, item.getAuditUserId(), 30, helper.getView(R.id.siv_img));
        helper.setText(R.id.tv_refundNo,"退款单号："+item.getRefundNo()).setText(R.id.tv_status,status);
    }

}
