package com.jxxx.gyl.view.activity.payActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.ParamData;
import com.jxxx.gyl.bean.RechargeAllBean;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ActivityPayChongZhi extends BaseActivity {//implements PaymentContract.View
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.tv_cz_1)
    TextView mTvCz1;
    @BindView(R.id.tv_czx_1)
    TextView mTvCzx1;
    @BindView(R.id.ll_cz_1)
    LinearLayout mLlCz1;
    @BindView(R.id.tv_cz_2)
    TextView mTvCz2;
    @BindView(R.id.tv_czx_2)
    TextView mTvCzx2;
    @BindView(R.id.ll_cz_2)
    LinearLayout mLlCz2;
    @BindView(R.id.tv_cz_3)
    TextView mTvCz3;
    @BindView(R.id.tv_czx_3)
    TextView mTvCzx3;
    @BindView(R.id.ll_cz_3)
    LinearLayout mLlCz3;
    @BindView(R.id.tv_cz_4)
    TextView mTvCz4;
    @BindView(R.id.tv_czx_4)
    TextView mTvCzx4;
    @BindView(R.id.ll_cz_4)
    LinearLayout mLlCz4;
    @BindView(R.id.tv_cz_5)
    TextView mTvCz5;
    @BindView(R.id.tv_czx_5)
    TextView mTvCzx5;
    @BindView(R.id.ll_cz_5)
    LinearLayout mLlCz5;
    @BindView(R.id.tv_cz_6)
    TextView mTvCz6;
    @BindView(R.id.tv_czx_6)
    TextView mTvCzx6;
    @BindView(R.id.ll_cz_6)
    LinearLayout mLlCz6;
    @BindView(R.id.tv_commit)
    TextView mTvCommit;
    @BindView(R.id.im_ye)
    ImageView mImYe;
    @BindView(R.id.ll_ye)
    LinearLayout mLlYe;
    @BindView(R.id.im_ali)
    ImageView mImAli;
    @BindView(R.id.ll_ali)
    LinearLayout mLlAli;
    @BindView(R.id.im_chat)
    ImageView mImChat;
    @BindView(R.id.ll_chat)
    LinearLayout mLlChat;
    String rechargeId = "";
    List<RechargeAllBean.ListBean> lists;
    private int payType = 2;


    @Override
    public int intiLayout() {
        return R.layout.activity_pay_chong_zhi;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "充值");
//        paymentPresenter = new PaymentPresenter(this, this);
        mImAli.setSelected(true);
        backstageRechargeAll();
    }

    @Override
    public void initData() {

    }


    @OnClick({ R.id.ll_cz_1, R.id.ll_cz_2, R.id.ll_cz_3, R.id.ll_cz_4, R.id.ll_cz_5, R.id.ll_cz_6, R.id.im_ye, R.id.im_ali, R.id.im_chat, R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_cz_1:
                initUi(mLlCz1,mTvCz1,mTvCzx1,0);
                break;
            case R.id.ll_cz_2:
                initUi(mLlCz2,mTvCz2,mTvCzx2,1);
                break;
            case R.id.ll_cz_3:
                initUi(mLlCz3,mTvCz3,mTvCzx3,2);
                break;
            case R.id.ll_cz_4:
                initUi(mLlCz4,mTvCz4,mTvCzx4,3);
                break;
            case R.id.ll_cz_5:
                initUi(mLlCz5,mTvCz5,mTvCzx5,4);
                break;
            case R.id.ll_cz_6:
                initUi(mLlCz6,mTvCz6,mTvCzx6,5);
                break;
            case R.id.im_ye:
                mImYe.setSelected(true);
                mImAli.setSelected(false);
                mImChat.setSelected(false);
                break;
            case R.id.im_ali:
                mImYe.setSelected(false);
                mImAli.setSelected(true);
                mImChat.setSelected(false);
                break;
            case R.id.im_chat:
                mImYe.setSelected(false);
                mImAli.setSelected(false);
                mImChat.setSelected(true);
                break;
            case R.id.tv_commit:
                userRechargeOrder();
                break;
        }
    }
    private void initUi(LinearLayout ll,TextView tv,TextView tv1,int pos) {
        if(lists==null){
            return;
        }
        rechargeId = lists.get(pos).getId()+"";

        mLlCz1.setBackground(getResources().getDrawable(R.drawable.circle_solid_f4f4f4_5));
        mTvCz1.setTextColor(getResources().getColor(R.color.color_333333));
        mTvCzx1.setTextColor(getResources().getColor(R.color.color_666666));

        mLlCz2.setBackground(getResources().getDrawable(R.drawable.circle_solid_f4f4f4_5));
        mTvCz2.setTextColor(getResources().getColor(R.color.color_333333));
        mTvCzx2.setTextColor(getResources().getColor(R.color.color_666666));

        mLlCz3.setBackground(getResources().getDrawable(R.drawable.circle_solid_f4f4f4_5));
        mTvCz3.setTextColor(getResources().getColor(R.color.color_333333));
        mTvCzx3.setTextColor(getResources().getColor(R.color.color_666666));

        mLlCz4.setBackground(getResources().getDrawable(R.drawable.circle_solid_f4f4f4_5));
        mTvCz4.setTextColor(getResources().getColor(R.color.color_333333));
        mTvCzx4.setTextColor(getResources().getColor(R.color.color_666666));

        mLlCz5.setBackground(getResources().getDrawable(R.drawable.circle_solid_f4f4f4_5));
        mTvCz5.setTextColor(getResources().getColor(R.color.color_333333));
        mTvCzx5.setTextColor(getResources().getColor(R.color.color_666666));

        mLlCz6.setBackground(getResources().getDrawable(R.drawable.circle_solid_f4f4f4_5));
        mTvCz6.setTextColor(getResources().getColor(R.color.color_333333));
        mTvCzx6.setTextColor(getResources().getColor(R.color.color_666666));

        ll.setBackground(getResources().getDrawable(R.drawable.circle_solid_theme_5));
        tv.setTextColor(getResources().getColor(R.color.white));
        tv1.setTextColor(getResources().getColor(R.color.white));
    }
    private void userRechargeOrder() {
        RetrofitUtil.getInstance().apiService()
                .userRechargeOrder(rechargeId).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<ParamData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<ParamData> result) {
                        if(result.getCode()==0){
                            if (payType == 1) {
                                if(result.getData()!=null){
//                                    appPayZfb(result.getData().getParam());
                                }

                            } else {
//                                appPayWx(result.getData());
                            }
                        }else{
                            ToastUtils.showShort(result.getError());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
//                        dismiss();
                    }

                    @Override
                    public void onComplete() {
//                        dismiss();
                    }
                });
//
    }

    private void backstageRechargeAll() {
        RetrofitUtil.getInstance().apiService()
                .backstageRechargeAll().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<RechargeAllBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<RechargeAllBean> result) {
                        if(result.getCode()==0){
                            lists = result.getData().getList();
                            if(lists==null){
                                return;
                            }
                            for(int i=0;i<lists.size();i++){
                                switch (i){
                                    case 0:
                                        rechargeId = lists.get(i).getId()+"";
                                        mTvCz1.setText(lists.get(i).getAmount()+"");
                                        mTvCzx1.setText("赠送"+lists.get(i).getGiveAmount()+"元");
                                        break;
                                    case 1:
                                        mTvCz2.setText(lists.get(i).getAmount()+"");
                                        mTvCzx2.setText("赠送"+lists.get(i).getGiveAmount()+"元");
                                        break;
                                    case 2:
                                        mTvCz3.setText(lists.get(i).getAmount()+"");
                                        mTvCzx3.setText("赠送"+lists.get(i).getGiveAmount()+"元");
                                        break;
                                    case 3:
                                        mTvCz4.setText(lists.get(i).getAmount()+"");
                                        mTvCzx4.setText("赠送"+lists.get(i).getGiveAmount()+"元");
                                        break;
                                    case 4:
                                        mTvCz5.setText(lists.get(i).getAmount()+"");
                                        mTvCzx5.setText("赠送"+lists.get(i).getGiveAmount()+"元");
                                        break;
                                    case 5:
                                        mTvCz6.setText(lists.get(i).getAmount()+"");
                                        mTvCzx6.setText("赠送"+lists.get(i).getGiveAmount()+"元");
                                        break;
                                }

                            }
                        }else{
                            ToastUtils.showShort(result.getError());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
//                        dismiss();
                    }

                    @Override
                    public void onComplete() {
//                        dismiss();
                    }
                });
//
    }

//    private PaymentPresenter paymentPresenter;
//
//    private void appPayWx(ParamData mPayModel) {
//        boolean flag = UMShareAPI.get(this).isInstall(this, SHARE_MEDIA.WEIXIN);
//        if (flag) {
//
//            PaymentParameterBean mPaymentParameterBean = new PaymentParameterBean();
//            mPaymentParameterBean.setWxAppid(mPayModel.getAppid());
//            mPaymentParameterBean.setPartnerId(mPayModel.getPartnerid());
//            mPaymentParameterBean.setPrepayId(mPayModel.getPrepayid());
//            mPaymentParameterBean.setNonceStr(mPayModel.getNoncestr());
//            mPaymentParameterBean.setTimeStamp(mPayModel.getTimestamp());
//            mPaymentParameterBean.setPackageValue(mPayModel.getPackageX());
//            mPaymentParameterBean.setSign(mPayModel.getSign());
//            paymentPresenter.doWXPay(mPaymentParameterBean);
//
//        } else {
//            ToastUtils.showLong( "您没有安装微信客户端!");
//        }
//    }
//
//    private void appPayZfb(String data) {
//        PaymentParameterBean mPaymentParameterBean1 = new PaymentParameterBean();
//        mPaymentParameterBean1.setOrderInfo(data);
//        paymentPresenter.doAliPay(mPaymentParameterBean1);
//    }
//
//    @Override
//    public void onWXPaySuccess() {
//
//    }
//
//    @Override
//    public void onAliPaySuccess() {
//
//    }
//
//    @Override
//    public void onWxPayFailure() {
//
//    }
//
//    @Override
//    public void onAliPayFailure() {
//
//    }
//
//    @Override
//    public void showProgress() {
//
//    }
//
//    @Override
//    public void dismissProgress() {
//
//    }
}
