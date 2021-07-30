package com.jxxx.gyl.view.adapter;

import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.OrderHistoryDetailBean;

import java.util.ArrayList;
import java.util.List;


public class MineInvoiceOrderAdapter extends BaseQuickAdapter<OrderHistoryDetailBean, BaseViewHolder> {

    public MineInvoiceOrderAdapter(List<OrderHistoryDetailBean> data) {
        super(R.layout.item_mine_invoice_order, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderHistoryDetailBean item) {
        helper.addOnClickListener(R.id.iv_select);
        ImageView iv_select = helper.getView(R.id.iv_select);
        iv_select.setSelected(false);
        if(item.isSelect()){
            iv_select.setSelected(true);
        }

        RecyclerView rvShopList = helper.getView(R.id.rv_shop_list);
        rvShopList.setAdapter(new OrderImageAdapter(item.getOrderDetailList()));
        helper.setText(R.id.tv_time,item.getPlaceTime()+"下单")
                .setText(R.id.tv_shop_num,"共"+item.getTotalItemNum()+"件 商品")
                .setText(R.id.tv_shop_price,"￥"+item.getPayAmount());
    }

}
