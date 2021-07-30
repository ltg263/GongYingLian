package com.jxxx.gyl.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.MainActivity;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.bean.DedicatedReceiptInfoBean;
import com.jxxx.gyl.bean.PostOrderSubmit;
import com.jxxx.gyl.utils.StringUtil;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MineInvoice1Fragment extends BaseFragment {
    @BindView(R.id.iv_type_1)
    ImageView mIvType1;
    @BindView(R.id.iv_type_2)
    ImageView  mIvType2;
    @BindView(R.id.et_receiptTitle)
    EditText mEtReceiptTitle;
    @BindView(R.id.et_ratepayerNo)
    EditText mEtRatepayerNo;
    @BindView(R.id.tv_receiptContent)
    TextView mTvReceiptContent;
    @BindView(R.id.tv_receiptAmount)
    TextView mTvReceiptAmount;
    @BindView(R.id.et_email)
    EditText mEtEmail;
    @BindView(R.id.et_bank)
    EditText mEtBank;
    @BindView(R.id.et_account)
    EditText mEtAccount;
    @BindView(R.id.et_address)
    EditText mEtAddress;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    String type = "1";
    String[] innerOrderNos;
    String typeS;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_mine_invoic_1;
    }

    @Override
    protected void initView() {
        mIvType1.setSelected(true);
    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        Log.w("bundle","bundle"+bundle);
        if(bundle!=null){
            innerOrderNos = bundle.getStringArray("innerOrderNos");
            typeS = bundle.getString("type");
            mTvReceiptAmount.setText(bundle.getString("receiptAmount"));
            mTvReceiptContent.setText(bundle.getString("receiptContent"));
        }
    }

    @OnClick({R.id.iv_type_1, R.id.iv_type_2, R.id.tv_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_type_1:
                type = "1";
                mIvType1.setSelected(true);
                mIvType2.setSelected(false);
                break;
            case R.id.iv_type_2:
                mIvType1.setSelected(false);
                mIvType2.setSelected(true);
                type = "2";
                break;
            case R.id.tv_register:
                postReceiptApply();
                break;
        }
    }
    private void postReceiptApply(){
        String receiptTitle = mEtReceiptTitle.getText().toString().trim();
        String ratepayerNo = mEtRatepayerNo.getText().toString().trim();
        String receiptContent = mTvReceiptContent.getText().toString().trim();
        String receiptAmount = mTvReceiptAmount.getText().toString().trim();
        String email = mEtEmail.getText().toString().trim();
        String bank = mEtBank.getText().toString().trim();
        String account = mEtAccount.getText().toString().trim();
        String address = mEtAddress.getText().toString().trim();
        String phone = mEtPhone.getText().toString().trim();
        if(StringUtil.isBlank(receiptTitle)||
                StringUtil.isBlank(ratepayerNo)||
                StringUtil.isBlank(receiptContent)||
                StringUtil.isBlank(receiptAmount)||
                StringUtil.isBlank(email)||
                StringUtil.isBlank(bank)||
                StringUtil.isBlank(account)||
                StringUtil.isBlank(address)||
                StringUtil.isBlank(phone)){
            ToastUtils.showLong("信息填写不完整");
            return;
        }
        if(StringUtil.isNotBlank(typeS) && typeS.equals("OrderAffirmActivity")){
            DedicatedReceiptInfoBean mDedicatedReceiptInfoBean = new DedicatedReceiptInfoBean(account,address,bank,email,phone,ratepayerNo,receiptAmount,
                    receiptContent,receiptTitle,type);
            //Activity返回时传递数据，也是通过意图对象
            Intent data = new Intent();
            //把要传递的数据封装至意图对象中
            data.putExtra("receiptType","1");
            data.putExtra("mDedicatedReceiptInfoBean", mDedicatedReceiptInfoBean);
            //当前Activity销毁时，data这个意图就会传递给启动当前Activity的那个Activity
            ((Activity)mContext).setResult(1, data);
            //销毁当前Activity
            ((Activity)mContext).finish();
            return;
        }
        PostOrderSubmit.ReceiptApply mReceiptApply = new PostOrderSubmit.ReceiptApply();
        mReceiptApply.setInnerOrderNos(innerOrderNos);
        mReceiptApply.setReceiptType(1);
        mReceiptApply.setGeneralReceiptInfo(new DedicatedReceiptInfoBean(account,address,bank,email,phone,ratepayerNo,receiptAmount,
                receiptContent,receiptTitle,type));
        Log.w("mReceiptApply","mReceiptApply:"+mReceiptApply.toString());
        RetrofitUtil.getInstance().apiService()
                .postReceiptApply(mReceiptApply)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        if(result.getCode()==200) {
                            ToastUtils.showShort("提交成功");
                            baseStartActivity(MainActivity.class,null);
                        }else{

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
}
