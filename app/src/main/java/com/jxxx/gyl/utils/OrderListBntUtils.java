package com.jxxx.gyl.utils;

import android.content.Context;
import android.util.Log;

import com.jxxx.gyl.bean.OrderHistoryBean;
import com.jxxx.gyl.bean.OrderHistoryDetailBean;
import com.jxxx.gyl.view.activity.OrderApplyAfterActivity;
import com.jxxx.gyl.view.activity.OrderPayActivity;

public class OrderListBntUtils {
    public static void startOrderType(Context mContext,String strOrderType, OrderHistoryDetailBean recordsBean) {
        Log.w("startOrderType","strOrderType:"+strOrderType);
        switch (strOrderType){
            case "去支付":
                OrderPayActivity.startActivityPayS(mContext,recordsBean.getInnerOrderNo(),
                        recordsBean.getPayableAmount(),recordsBean.getPayChannel(),recordsBean.getPayNo());
                break;
            case "确认收货":

                break;
            case "取消订单":

                break;
            case "申请售后":

                break;
            case "再来一单":

                break;
            case "删除订单":

                break;
        }
    }
}
