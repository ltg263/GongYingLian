package com.jxxx.gyl.view.activity.login;


import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.activity.mine.WebViewActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_verify)
    EditText etVerify;
    @BindView(R.id.auth_code)
    TextView authCode;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.cb)
    TextView cb;
    @BindView(R.id.tv_info)
    TextView tvInfo;

    @Override
    public int intiLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "注册");
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.auth_code, R.id.tv_register, R.id.tv_forget, R.id.tv_login,R.id.ll_yhxy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.auth_code:
                getVerifyCode();
                break;
            case R.id.tv_register:
                toRegister();
                break;
            case R.id.tv_forget:
                readyGoActivity(ForgetPasswordActivity.class);
                break;
            case R.id.tv_login:
                readyGoActivity(LoginActivity.class);
                break;
            case R.id.ll_yhxy:
                readyGoActivity(WebViewActivity.class);
                break;
        }
    }

    private void toRegister() {
//        RegisterBean bean = new RegisterBean();
//        bean.setUsername(etAccount.getText().toString());
//        bean.setPassword(etPass.getText().toString());
//        bean.setVerifyCode(etVerify.getText().toString());
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), new Gson().toJson(bean));
//        RetrofitManager.build().create(UserService.class)
//                .register(requestBody)
//                .compose(RxScheduler.<BaseResponse<EmptyResponse>>observeOnMainThread())
//                .as(RxScheduler.<BaseResponse<EmptyResponse>>bindLifecycle(this))
//                .subscribe(new BaseObserver<EmptyResponse>() {
//                    @Override
//                    public void onSuccess(EmptyResponse emptyResponse) {
//                        ToastUtils.showShort("注册成功");
//                        finish();
//                        readyGoActivity(LoginActivity.class);
//                    }
//
//                    @Override
//                    public void onFail(int code, String error) {
//
//                    }
//                });
    }

    private void getVerifyCode() {
//        String account = etAccount.getText().toString();
//        if ("".equals(account)) {
//            ToastUtils.showShort("请输入手机号");
//            return;
//        }
//        RetrofitManager.build().create(UserService.class)
//                .getCode(0, account)
//                .compose(RxScheduler.<BaseResponse<EmptyResponse>>observeOnMainThread())
//                .as(RxScheduler.<BaseResponse<EmptyResponse>>bindLifecycle(this))
//                .subscribe(new BaseObserver<EmptyResponse>() {
//                    @Override
//                    public void onSuccess(EmptyResponse emptyResponse) {
//                        ToastUtils.showShort("验证码发送成功");
//                        CountDownTimerUtils count = new CountDownTimerUtils(authCode, 60000);
//                        count.start();
//                    }
//
//                    @Override
//                    public void onFail(int code, String error) {
//
//                    }
//                });
    }
}
