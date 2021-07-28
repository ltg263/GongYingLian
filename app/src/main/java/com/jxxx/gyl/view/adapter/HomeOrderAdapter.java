package com.jxxx.gyl.view.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.OrderHistoryBean;

import java.util.ArrayList;
import java.util.List;

public class HomeOrderAdapter extends BaseQuickAdapter<OrderHistoryBean.RecordsBean, BaseViewHolder> {

    public HomeOrderAdapter(List<OrderHistoryBean.RecordsBean> data) {
        super(R.layout.item_home_order, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderHistoryBean.RecordsBean item) {
//                NONE,           //无状态
//                INIT,           //初始化
//                UNPAID,         //待支付
//                UN_DELIVERY,    //待发货（同已付款）
//                UN_RECEIVE,     //待收货（同已发货）
//                FINISHED,       //已完成（同待评价）终结状态
//                CANCELLED,      //已取消（同已关闭）终结状态
//                WAITING_REFUND, //待退款（同退款中）
//                REFUNDED,       //已退款 终结状态
        helper.setVisible(R.id.bnt_1,false).setVisible(R.id.bnt_2,false).setVisible(R.id.bnt_3,false);
        String orderStatusString = "无";
        switch (item.getOrderStatus()){
            case "NONE":
                orderStatusString = "无";
                break;
            case "INIT":
                orderStatusString = "初始化";
                break;
            case "UNPAID":
                helper.setVisible(R.id.bnt_1,false).setText(R.id.bnt_1,"")
                        .setVisible(R.id.bnt_2,true).setText(R.id.bnt_2,"取消订单")
                        .setVisible(R.id.bnt_3,true).setText(R.id.bnt_3,"去支付");
                orderStatusString = "待支付";
                break;
            case "UN_DELIVERY":
                helper.setVisible(R.id.bnt_1,false).setText(R.id.bnt_1,"")
                        .setVisible(R.id.bnt_2,true).setText(R.id.bnt_2,"再来一单")
                        .setVisible(R.id.bnt_3,true).setText(R.id.bnt_3,"售后申请");
                orderStatusString = "待发货";
                break;
            case "UN_RECEIVE":
                helper.setVisible(R.id.bnt_1,false).setText(R.id.bnt_1,"")
                        .setVisible(R.id.bnt_2,true).setText(R.id.bnt_2,"再来一单")
                        .setVisible(R.id.bnt_3,true).setText(R.id.bnt_3,"确认收货");
                orderStatusString = "待收货";
                break;
            case "FINISHED":
                helper.setVisible(R.id.bnt_1,false).setText(R.id.bnt_1,"")
                        .setVisible(R.id.bnt_2,true).setText(R.id.bnt_2,"再来一单")
                        .setVisible(R.id.bnt_3,true).setText(R.id.bnt_3,"售后申请");
                orderStatusString = "已完成";
                break;
            case "CANCELLED":
                helper.setVisible(R.id.bnt_1,false).setText(R.id.bnt_1,"")
                        .setVisible(R.id.bnt_2,false).setText(R.id.bnt_2,"")
                        .setVisible(R.id.bnt_3,true).setText(R.id.bnt_3,"再来一单");
                orderStatusString = "已取消";
                break;
            case "WAITING_REFUND":
                helper.setVisible(R.id.bnt_1,false).setText(R.id.bnt_1,"")
                        .setVisible(R.id.bnt_2,false).setText(R.id.bnt_2,"")
                        .setVisible(R.id.bnt_3,true).setText(R.id.bnt_3,"再来一单");
                orderStatusString = "待退款";
                break;
            case "REFUNDED":
                helper.setVisible(R.id.bnt_1,false).setText(R.id.bnt_1,"")
                        .setVisible(R.id.bnt_2,false).setText(R.id.bnt_2,"")
                        .setVisible(R.id.bnt_3,true).setText(R.id.bnt_3,"再来一单");
                orderStatusString = "已退款";
                break;
        }

        helper.addOnClickListener(R.id.bnt_1).addOnClickListener(R.id.bnt_2).addOnClickListener(R.id.bnt_3)
                .setText(R.id.tv_time,item.getPlaceTime()+"下单").setText(R.id.tv_state,orderStatusString)
        .setText(R.id.tv_shop_num,"共"+item.getTotalItemNum()+"件 商品").setText(R.id.tv_shop_price,"￥"+item.getTotalAmount());


        RecyclerView rvShopList = helper.getView(R.id.rv_shop_list);
        rvShopList.setAdapter(new OrderImageAdapter(item.getOrderDetailList()));
    }

}
