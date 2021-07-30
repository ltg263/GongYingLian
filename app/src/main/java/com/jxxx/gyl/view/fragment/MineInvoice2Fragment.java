package com.jxxx.gyl.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
import com.jxxx.gyl.utils.AddressPickTask;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MineInvoice2Fragment extends BaseFragment {
    @BindView(R.id.et_receiptTitle)
    EditText mEtReceiptTitle;
    @BindView(R.id.et_ratepayerNo)
    EditText mEtRatepayerNo;
    @BindView(R.id.tv_receiptContent)
    TextView mTvReceiptContent;
    @BindView(R.id.tv_receiptAmount)
    TextView mTvReceiptAmount;
    @BindView(R.id.et_bank)
    EditText mEtBank;
    @BindView(R.id.et_account)
    EditText mEtAccount;
    @BindView(R.id.et_address)
    EditText mEtAddress;
    @BindView(R.id.et_bankPhone)
    EditText mEtBankPhone;
    @BindView(R.id.et_contact)
    EditText mEtContact;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.tv_region)
    TextView mTvRegion;
    @BindView(R.id.et_detailsAddress)
    EditText mEtDetailsAddress;

    String[] innerOrderNos;
    String typeS;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_mine_invoic_2;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        Log.w("bundle","bundle"+bundle);
        if(bundle!=null){
            innerOrderNos = bundle.getStringArray("innerOrderNos");
            mTvReceiptAmount.setText(bundle.getString("receiptAmount"));
            typeS = bundle.getString("type");
        }
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_region, R.id.tv_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_region:
                onAddressPicker();
                break;
            case R.id.tv_register:
                postReceiptApply();
                break;
        }
    }

    public void onAddressPicker() {
        AddressPickTask task = new AddressPickTask((Activity) mContext);
        task.setHideProvince(false);
        task.setHideCounty(false);
        task.setCallback(new AddressPickTask.Callback() {

            @Override
            public void onAddressInitFailed() {
                ToastUtils.showShort("数据初始化失败");
            }

            @Override
            public void onAddressPicked(Province province, City city, County county) {
                if (county == null) {
                    mTvRegion.setText(province.getAreaName() +","+ city.getAreaName());
//                    addressData.setLandmark(province.getAreaName() +","+ city.getAreaName());
//                    addressData.setProvinceId(province.getAreaId());
//                    addressData.setCityId(city.getAreaId());

                } else {
                    mTvRegion.setText(province.getAreaName() +","+ city.getAreaName() +","+ county.getAreaName());
//                    addressData.setLandmark(province.getAreaName() +","+ city.getAreaName() +","+ county.getAreaName());
//                    addressData.setProvinceId(province.getAreaId());
//                    addressData.setCityId(city.getAreaId());
//                    addressData.setDistrictId(county.getAreaId());
                }
            }
        });
        task.execute("北京", "北京", "北京");
    }

    private void postReceiptApply(){
        String receiptTitle = mEtReceiptTitle.getText().toString();
        String ratepayerNo = mEtRatepayerNo.getText().toString();
        String receiptContent = mTvReceiptContent.getText().toString();
        String receiptAmount = mTvReceiptAmount.getText().toString();
        String bank = mEtBank.getText().toString();
        String account = mEtAccount.getText().toString();
        String address = mEtAddress.getText().toString();
        String phone = mEtPhone.getText().toString();
        String bankPhone = mEtBankPhone.getText().toString();
        String contact = mEtContact.getText().toString();
        String region = mTvRegion.getText().toString();
        String detailsAddress = mEtDetailsAddress.getText().toString();
        if(StringUtil.isBlank(receiptTitle)||
                StringUtil.isBlank(ratepayerNo)||
                StringUtil.isBlank(receiptContent)||
                StringUtil.isBlank(receiptAmount)||
                StringUtil.isBlank(bank)||
                StringUtil.isBlank(account)||
                StringUtil.isBlank(address)||
                StringUtil.isBlank(phone)||
                StringUtil.isBlank(bankPhone)||
                StringUtil.isBlank(contact)||
                StringUtil.isBlank(region)||
                StringUtil.isBlank(detailsAddress)){
            ToastUtils.showLong("信息填写不完整");
            return;
        }

        if(StringUtil.isNotBlank(typeS) && typeS.equals("OrderAffirmActivity")){
            DedicatedReceiptInfoBean mDedicatedReceiptInfoBean = new DedicatedReceiptInfoBean(account, address, bank, phone, ratepayerNo, receiptAmount, receiptTitle, bankPhone, contact, detailsAddress, region);
            //Activity返回时传递数据，也是通过意图对象
            Intent data = new Intent();
            //把要传递的数据封装至意图对象中
            data.putExtra("receiptType","2");
            data.putExtra("mDedicatedReceiptInfoBean", mDedicatedReceiptInfoBean);
            //当前Activity销毁时，data这个意图就会传递给启动当前Activity的那个Activity
            ((Activity)mContext).setResult(1, data);
            //销毁当前Activity
            ((Activity)mContext).finish();
            return;
        }
        PostOrderSubmit.ReceiptApply mReceiptApply = new PostOrderSubmit.ReceiptApply();
        mReceiptApply.setInnerOrderNos(innerOrderNos);
        mReceiptApply.setReceiptType(2);
        mReceiptApply.setDedicatedReceiptInfo(
                new DedicatedReceiptInfoBean(account, address, bank, phone, ratepayerNo, receiptAmount, receiptTitle, bankPhone, contact, detailsAddress, region));
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
