package com.jxxx.gyl.view.activity.payActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ActivityPayBankCardAdd extends BaseActivity {


    @BindView(R.id.include)
    Toolbar toolbar;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.cardNo)
    EditText cardNo;
    @BindView(R.id.bankName)
    EditText bankName;
    @BindView(R.id.iv)
    ImageView mIv;

    int status = 1;
    boolean isUpdate = false;
    int id;
//    BankCardRequest request = new BankCardRequest();

    @Override
    public int intiLayout() {
        return R.layout.activity_pay_bank_card_add;
    }

    @Override
    public void initView() {
        setToolbar(toolbar,"添加银行卡");

        isUpdate = getIntent().getBooleanExtra("isUpdate",false);
        id = getIntent().getIntExtra("id",0);
    }

    @Override
    public void initData() {
        if (isUpdate) {
//            RetrofitManager.build().create(UserService.class).getAcconunt(id+"")
//                    .compose(RxScheduler.observeOnMainThread())
//                    .as(RxScheduler.bindLifecycle(this))
//                    .subscribe(new BaseObserver<AccountLists.ListBean>() {
//                        @Override
//                        public void onSuccess(AccountLists.ListBean request) {
//                            hideLoading();
//                            username.setText(request.getName());
//                            phone.setText(request.getMobile());
//                            cardNo.setText(request.getAccountNo());
//                            bankName.setText(request.getBank());
//                            status = request.getStatus();
//                            if(request.getStatus()==1){
//                                mIv.setImageDrawable(getResources().getDrawable(R.mipmap.ic_circle_yes_l));
//                            }
////                            GlideImageLoader.loadImageAndDefault(AddBankCardActivity.this,request.getImgUrl(),cardImage);
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            super.onError(e);
//                            hideLoading();
//                        }
//                    });
        }
    }

    @OnClick({R.id.btnSubmit,R.id.iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv:
                if(status == 1){
                    status = 2;
                    mIv.setImageDrawable(getResources().getDrawable(R.mipmap.ic_circle_no));
                }else{
                    status = 1;
                    mIv.setImageDrawable(getResources().getDrawable(R.mipmap.ic_circle_yes_l));
                }
                break;
            case R.id.btnSubmit:
//                String mobile = phone.getText().toString();
////                String idCard = cardNo.getText().toString();
//                String realName = username.getText().toString();
//                String accountNo = cardNo.getText().toString();
//                int accountType = 2;
//                String bank = bankName.getText().toString();
//                if (StringUtils.isEmpty(mobile) ||
////                        StringUtils.isEmpty(idCard) ||
//                        StringUtils.isEmpty(realName)
//                        ||StringUtils.isEmpty(bank)
//                        ||StringUtils.isEmpty(accountNo)
////                        ||StringUtils.isEmpty(request.getImgUrl())
//                ){
//                    ToastUtils.showShort("请填写完整的信息");
//                    return;
//                }
//                request.setMobile(mobile);
//                request.setStatus(status);
//                request.setName(realName);
//                request.setAccountNo(accountNo);
//                request.setBank(bank);
//                request.setCashOutType(1);
//                request.setId(id);
////                request.setImgUrl(request.getImgUrl());
////                if (isUpdate)
////                    request.setId(id);
//
//                Log.w("--->>>","new Gson().toJson(request):"+new Gson().toJson(request));
//                RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),new Gson().toJson(request));
//                if (isUpdate) {
//                    showLoading();
//                    RetrofitManager.build().create(UserService.class).addCardUpdate(body)
//                            .compose(RxScheduler.observeOnMainThread())
//                            .as(RxScheduler.bindLifecycle(this))
//                            .subscribe(new BaseObserver<EmptyResponse>() {
//                                @Override
//                                public void onSuccess(EmptyResponse emptyResponse) {
//                                    hideLoading();
//                                    ToastUtils.showShort("添加成功");
//                                    finish();
//                                }
//
//                                @Override
//                                public void onError(Throwable e) {
//                                    super.onError(e);
//                                    hideLoading();
//                                }
//                            });
//
//                } else {
//                    showLoading();
//                    RetrofitManager.build().create(UserService.class).addCard(request.getAccountNo(),request.getBank(),
//                            request.getMobile(),request.getName(),request.getStatus()+"",1+"")
//                            .compose(RxScheduler.observeOnMainThread())
//                            .as(RxScheduler.bindLifecycle(this))
//                            .subscribe(new BaseObserver<EmptyResponse>() {
//                                @Override
//                                public void onSuccess(EmptyResponse emptyResponse) {
//                                    hideLoading();
//                                    ToastUtils.showShort("添加成功");
//                                    finish();
//                                }
//
//                                @Override
//                                public void onError(Throwable e) {
//                                    super.onError(e);
//                                    hideLoading();
//                                }
//                            });
//                }
//                break;
        }
    }
}
