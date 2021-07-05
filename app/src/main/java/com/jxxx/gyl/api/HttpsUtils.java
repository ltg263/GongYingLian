package com.jxxx.gyl.api;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.LoginRequest;
import com.jxxx.gyl.bean.OrderInfoBean;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.utils.ToastUtil;
import com.jxxx.gyl.view.activity.login.LoginActivity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HttpsUtils {
    /**
     * 发送验证码
     * @param mContext
     * @param bnt
     * @param phone
     * @param scene
     */
    public static void getVerifyCode(Context mContext,TextView bnt,String phone,String scene) {
        LoginRequest bean = new LoginRequest();
        bean.setPhone(phone);
        bean.setScene(scene);//1注册 2登录 3找回密码
        RetrofitUtil.getInstance().apiService()
                .sendSms(bean)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        if(result.getCode()==200) {
                            ToastUtil.showLongStrToast(mContext,"验证码发送成功");
                            CountDownTimerUtils count = new CountDownTimerUtils(mContext,bnt, 60000);
                            count.start();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private static class CountDownTimerUtils extends CountDownTimer {
        private TextView mTextView;
        private Context mContext;
        public CountDownTimerUtils(Context mContext,TextView textView, long millisInFuture) {
            super(millisInFuture, 1000);
            this.mContext = mContext;
            this.mTextView = textView;

        }

        @Override
        public void onTick(long millisUntilFinished) {
            mTextView.setClickable(false); //设置不可点击
            mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.red40));
            mTextView.setText(millisUntilFinished / 1000 + "秒后重新获取"); //设置倒计时时间
        }

        @Override
        public void onFinish() {
            mTextView.setText("再次获取");
            mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.color_blue_theme));
            mTextView.setClickable(true);//重新获得点击
        }
    }


    public static void userRechargeOrder(Context mContext, String skuId, String spuId,ShoppingCartInterface mShoppingCartInterface) {
        OrderInfoBean mOrderInfoBean = new OrderInfoBean();
        mOrderInfoBean.setShopCartAdd("APP_MALL",skuId,spuId);
        RetrofitUtil.getInstance().apiService()
                .userRechargeOrder(mOrderInfoBean)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        if(result.getCode()==200) {
                            ToastUtils.showLong("已放入购物车");
                            if(mShoppingCartInterface!=null){
                                mShoppingCartInterface.isResult(true);
                            }
                        }else{
                            if(mShoppingCartInterface!=null){
                                mShoppingCartInterface.isResult(false);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(mShoppingCartInterface!=null){
                            mShoppingCartInterface.isResult(false);
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }


    public static void shoppingCartReduce(Context mContext, String skuId, String spuId,ShoppingCartInterface mShoppingCartInterface) {
        OrderInfoBean mOrderInfoBean = new OrderInfoBean();
        mOrderInfoBean.setShopCartDel("1",skuId,spuId);
        RetrofitUtil.getInstance().apiService()
                .shoppingCartReduce(mOrderInfoBean)
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
                                mShoppingCartInterface.isResult(true);
                            }
                        }else{
                            if(mShoppingCartInterface!=null){
                                mShoppingCartInterface.isResult(false);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(mShoppingCartInterface!=null){
                            mShoppingCartInterface.isResult(false);
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
        public void isResult(Boolean isResult);
    }
}
