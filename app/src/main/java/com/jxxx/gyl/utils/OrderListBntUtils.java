package com.jxxx.gyl.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.MainActivity;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.bean.OrderHistoryDetailBean;
import com.jxxx.gyl.bean.PostOrderSubmit;
import com.jxxx.gyl.view.activity.OrderAffirmActivity;
import com.jxxx.gyl.view.activity.OrderApplyAfterActivity;
import com.jxxx.gyl.view.activity.OrderPayActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderListBntUtils {

    public static void startOrderType(Context mContext, String strOrderType, OrderHistoryDetailBean recordsBean, ShoppingCartInterface mShoppingCartInterface) {
        Log.w("startOrderType","strOrderType:"+strOrderType);
        switch (strOrderType){
            case "去支付":
                OrderPayActivity.startActivityPayS(mContext,recordsBean.getInnerOrderNo(),
                        recordsBean.getPayableAmount(),recordsBean.getPayChannel(),recordsBean.getPayNo());
                break;
            case "确认收货":
                DialogUtils.showDialogHint(mContext, "确认收到货了吗？", false, new DialogUtils.ErrorDialogInterface() {
                    @Override
                    public void btnConfirm() {
                        orderConfirm(mContext, recordsBean.getInnerOrderNo(), new ShoppingCartInterface() {
                            @Override
                            public void isResult(Boolean isResult, String num) {
                                if(isResult){
                                    ToastUtils.showLong("确认收货成功");
                                    mContext.startActivity(new Intent(mContext,MainActivity.class));
                                }
                            }
                        });
                    }
                });
                break;
            case "取消订单":
                List<String> lists = Arrays.asList(ConstValues.ORDER_CANCEL);
                PickerViewUtils.selectorCustom(mContext,lists , "取消订单原因", new PickerViewUtils.ConditionInterfacd() {
                    @Override
                    public void setIndex(int pos) {
                        orderCancel(mContext, lists.get(pos), recordsBean.getInnerOrderNo(), new ShoppingCartInterface() {
                            @Override
                            public void isResult(Boolean isResult, String num) {
                                if(isResult){
                                    ToastUtils.showLong("取消成功");
                                }
                                mShoppingCartInterface.isResult(isResult,num);
                            }
                        });
                    }
                });
                break;
            case "申请售后":
                Intent mIntent = new Intent(mContext,OrderApplyAfterActivity.class);
                mIntent.putParcelableArrayListExtra("orderDetailList",
                        (ArrayList<? extends Parcelable>) recordsBean.getOrderDetailList());
                mIntent.putExtra("innerOrderNo",recordsBean.getInnerOrderNo());
                mContext.startActivity(mIntent);
                break;
            case "再来一单":
                orderAgain(mContext, recordsBean.getInnerOrderNo(), new ShoppingCartInterface() {
                    @Override
                    public void isResult(Boolean isResult, String num) {
                        ConstValues.SHOW_MAIN_FRAGMENT = "购物车";
                        mContext.startActivity(new Intent(mContext,MainActivity.class));
                    }
                });
                break;
            case "删除订单":

                break;
        }
    }

    public static void orderConfirm(Context mContext, String innerOrderNo,
                                          ShoppingCartInterface mShoppingCartInterface) {
        PostOrderSubmit.OrderCancel mOrderCancel = new PostOrderSubmit.OrderCancel();
        mOrderCancel.setInnerOrderNo(innerOrderNo);
        RetrofitUtil.getInstance().apiService()
                .orderConfirm(mOrderCancel)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(Result result) {
                        if(result.getCode()==200) {
                            mShoppingCartInterface.isResult(true,"");
                        }else{
                            if(mShoppingCartInterface!=null){
                                mShoppingCartInterface.isResult(false,"");
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(mShoppingCartInterface!=null){
                            mShoppingCartInterface.isResult(false,"");
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public static void orderAgain(Context mContext, String innerOrderNo,
                                          ShoppingCartInterface mShoppingCartInterface) {
        PostOrderSubmit.OrderCancel mOrderCancel = new PostOrderSubmit.OrderCancel();
        mOrderCancel.setInnerOrderNo(innerOrderNo);
        RetrofitUtil.getInstance().apiService()
                .orderAgain(mOrderCancel)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(Result result) {
                        if(result.getCode()==200) {
                            mShoppingCartInterface.isResult(false,"");
                        }else{
                            if(mShoppingCartInterface!=null){
                                mShoppingCartInterface.isResult(false,"");
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(mShoppingCartInterface!=null){
                            mShoppingCartInterface.isResult(false,"");
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public static void orderCancel(Context mContext, String cancelDesc, String innerOrderNo,
                                          ShoppingCartInterface mShoppingCartInterface) {
        PostOrderSubmit.OrderCancel mOrderCancel = new PostOrderSubmit.OrderCancel();
        mOrderCancel.setCancelDesc(cancelDesc);
        mOrderCancel.setInnerOrderNo(innerOrderNo);
        RetrofitUtil.getInstance().apiService()
                .orderCancel(mOrderCancel)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(Result result) {
                        if(result.getCode()==200) {
                            if(mShoppingCartInterface!=null){
                                mShoppingCartInterface.isResult(true,"");
                            }
                        }else{
                            if(mShoppingCartInterface!=null){
                                mShoppingCartInterface.isResult(false,"");
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(mShoppingCartInterface!=null){
                            mShoppingCartInterface.isResult(false,"");
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    public interface ShoppingCartInterface {
        /**
         * 确定
         */
        public void isResult(Boolean isResult,String num);
    }
}
