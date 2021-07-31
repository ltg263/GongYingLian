package com.jxxx.gyl.view.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.MainActivity;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.HttpsUtils;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.app.MainApplication;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.ChannelsListBean;
import com.jxxx.gyl.bean.OrderSubmitData;
import com.jxxx.gyl.bean.PostOrderSubmit;
import com.jxxx.gyl.utils.DialogUtils;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.utils.alipay.PaymentContract;
import com.jxxx.gyl.utils.alipay.PaymentParameterBean;
import com.jxxx.gyl.utils.alipay.PaymentPresenter;
import com.jxxx.gyl.view.adapter.PayChannelsAdapter;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderPayActivity extends BaseActivity implements PaymentContract.View {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.iv_select_wx)
    ImageView mIvSelectWx;
    @BindView(R.id.iv_select_zfb)
    ImageView mIvSelectZfb;
    @BindView(R.id.iv_select_yhk)
    ImageView mIvSelectYhk;
    @BindView(R.id.tv_skuPrice)
    TextView tv_skuPrice;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    PostOrderSubmit mPostOrderSubmit;
    PayChannelsAdapter mPayChannelsAdapter;
    PostOrderSubmit.PayCreate mPayCreate;
    private PaymentPresenter paymentPresenter;
    private IWXAPI api;

    boolean isPay = false;
    @Override
    public int intiLayout() {
        return R.layout.activity_order_pay;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "订单支付");

        paymentPresenter = new PaymentPresenter(this, OrderPayActivity.this);
        api = WXAPIFactory.createWXAPI(this, MainApplication.getContext().getWxId());
        mPostOrderSubmit = (PostOrderSubmit) getIntent().getSerializableExtra("mPostOrderSubmit");
        mPayChannelsAdapter = new PayChannelsAdapter(null);
        rv_list.setAdapter(mPayChannelsAdapter);
        mPayChannelsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPayChannelsAdapter.setChannelCode(mPayChannelsAdapter.getData().get(position).getChannelCode());
                mPayChannelsAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void initData() {
        if(mPostOrderSubmit==null){
            mPayCreate = new PostOrderSubmit.PayCreate();
            mPayCreate.setInnerOrderNo(getIntent().getStringExtra("innerOrderNo"));
            mPayCreate.setOrderAmount(getIntent().getStringExtra("payableAmount"));
            mPayCreate.setPayChannel(getIntent().getStringExtra("payChannel"));
            mPayCreate.setOrderType("PURCHASE");
            tv_skuPrice.setText("￥"+getIntent().getStringExtra("payableAmount"));
            HttpsUtils.payChannelsList("PURCHASE", new HttpsUtils.PayChannelsInterface() {
                @Override
                public void getPayChannelsResult(List<ChannelsListBean> result) {
                    mPayChannelsAdapter.setChannelCode(mPayCreate.getPayChannel());
                    mPayChannelsAdapter.setNewData(result);
                }
            });
            return;
        }
        Log.w("mPostOrderSubmit","mPostOrderSubmit:"+mPostOrderSubmit.toString());
        RetrofitUtil.getInstance().apiService()
                .postOrderSubmit(mPostOrderSubmit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<OrderSubmitData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<OrderSubmitData> result) {
                        if (isResultOk(result)) {
                            result.getData();
                            tv_skuPrice.setText("￥"+result.getData().getPayAmount());
                            ToastUtils.showLong(result.getData().getSubmitStatus().equals("1")?"创建成功":"创建失败");
                            if(result.getData().getSubmitStatus().equals("1")){
                                mPayCreate = new PostOrderSubmit.PayCreate();
                                mPayCreate.setInnerOrderNo(result.getData().getInnerOrderNo());
                                mPayCreate.setOrderAmount(result.getData().getPayAmount());
                                mPayCreate.setPayChannel(mPostOrderSubmit.getPayChannel());
                                mPayCreate.setOrderType("PURCHASE");
                            }
                        }else{
                            DialogUtils.showDialogHint(OrderPayActivity.this, result.getMessage(), true, new DialogUtils.ErrorDialogInterface() {
                                @Override
                                public void btnConfirm() {
                                    OrderPayActivity.this.finish();
                                }
                            });
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });

        HttpsUtils.payChannelsList("PURCHASE", new HttpsUtils.PayChannelsInterface() {
            @Override
            public void getPayChannelsResult(List<ChannelsListBean> result) {
                mPayChannelsAdapter.setChannelCode(mPostOrderSubmit.getPayChannel());
                mPayChannelsAdapter.setNewData(result);
            }
        });
    }

    @OnClick({R.id.iv_select_wx, R.id.iv_select_zfb, R.id.iv_select_yhk, R.id.btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_select_wx:
                mIvSelectWx.setSelected(true);
                mIvSelectZfb.setSelected(false);
                mIvSelectYhk.setSelected(false);
                break;
            case R.id.iv_select_zfb:
                mIvSelectWx.setSelected(false);
                mIvSelectZfb.setSelected(true);
                mIvSelectYhk.setSelected(false);
                break;
            case R.id.iv_select_yhk:
                mIvSelectWx.setSelected(false);
                mIvSelectZfb.setSelected(false);
                mIvSelectYhk.setSelected(true);
                break;
            case R.id.btn:
//                if(mPostOrderSubmit==null){
//                    HttpsUtils.shouldOverrideUrlLoading(OrderPayActivity.this,getIntent().getStringExtra("payNo"));
////                    appPayZfb(getIntent().getStringExtra("payNo"));
//                    return;
//                }
                mPayCreate.setPayChannel(mPayChannelsAdapter.getChannelCode());
                HttpsUtils.payCreate(mPayCreate, new HttpsUtils.ShoppingCartInterface() {
                    @Override
                    public void isResult(Boolean isResult, String num) {
                        isPay = true;
                        HttpsUtils.shouldOverrideUrlLoading(OrderPayActivity.this,num);
//                        appPayZfb(num);
                    }
                });
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isPay){
            HttpsUtils.payQuery(mPayCreate.getInnerOrderNo(), new HttpsUtils.ShoppingCartInterface() {
                @Override
                public void isResult(Boolean isResult, String status) {
                    ToastUtils.showShort(status);
                    baseStartActivity(MainActivity.class);
//                    Intent mIntent = new Intent(OrderPayActivity.this,OrderPayOkActivity.class);
//                    mIntent.putExtra("isResult",isResult);
//                    mIntent.putExtra("status",status);
//                    startActivity(mIntent);
                }
            });
        }
    }

    //    private void weCahtPay(PayOrderResponse.DataBean.PayStrBean payStr){
//        PayReq req = new PayReq();
//        req.appId = payStr.getAppid();
//        req.partnerId = payStr.getPartnerid();
//        req.prepayId = payStr.getPrepayid();
//        req.nonceStr = payStr.getNoncestr();
//        req.timeStamp = payStr.getTimestamp();
//        req.packageValue = payStr.getPackageValue();
//        req.sign = payStr.getSign();
//        req.extData = "app data";
//        api.sendReq(req);
//    }
    private void appPayZfb(String data) {
        PaymentParameterBean mPaymentParameterBean1 = new PaymentParameterBean();
        mPaymentParameterBean1.setOrderInfo(data);
        paymentPresenter.doAliPay(mPaymentParameterBean1);
    }

    @Override
    public void onWXPaySuccess() {

    }

    @Override
    public void onAliPaySuccess() {

        HttpsUtils.payQuery("innerOrderNo", new HttpsUtils.ShoppingCartInterface() {
            @Override
            public void isResult(Boolean isResult, String num) {
                Log.w("num","num"+num);
            }
        });
    }

    @Override
    public void onWxPayFailure() {

    }

    @Override
    public void onAliPayFailure() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }



    public static void startActivityPay(Context mContext,PostOrderSubmit mPostOrderSubmit){
        Intent mIntent = new Intent(mContext,OrderPayActivity.class);
        mIntent.putExtra("mPostOrderSubmit",mPostOrderSubmit);
        mContext.startActivity(mIntent);
    }

    public static void startActivityPayS(Context mContext,String innerOrderNo,String payableAmount,String payChannel,String payNo){
        Intent mIntent = new Intent(mContext,OrderPayActivity.class);
        mIntent.putExtra("innerOrderNo",innerOrderNo);
        mIntent.putExtra("payableAmount",payableAmount);
        mIntent.putExtra("payChannel",payChannel);
        mIntent.putExtra("payNo",payNo);
        mContext.startActivity(mIntent);
    }
}
