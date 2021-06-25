package com.jxxx.gyl.view.activity.login;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPasswordActivity extends BaseActivity {


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
    @BindView(R.id.tv_done)
    TextView tvDone;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_password2)
    EditText etPassword2;

    @Override
    public int intiLayout() {
        return R.layout.activity_forget_password;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "密码修改");
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.auth_code, R.id.tv_done})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.auth_code:
                getVerifyCode();
                break;
            case R.id.tv_done:
                String pw1 = etPassword.getText().toString().trim();
                String pw2 = etPassword2.getText().toString().trim();
                String code = etVerify.getText().toString().trim();
                String username = etAccount.getText().toString().trim();
//                if (TextUtils.isEmpty(pw1) || TextUtils.isEmpty(pw2) || TextUtils.isEmpty(code)) {
//                    ToastUtils.showShort("请输入完整内容");
//                    return;
//                }
//                if (!pw1.equals(pw2)) {
//                    ToastUtils.showShort("两次密码输入不一致！");
//                    return;
//                }
//                ForgetPasswordRequest request = new ForgetPasswordRequest();
//                request.setPassword(pw1);
//                request.setSmsCode(code);
//                request.setUsername(username);
//                request.setUsernameType(1);
//                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), new Gson().toJson(request));
//                RetrofitManager.build().create(UserService.class)
//                        .forgetPassword(requestBody)
//                        .compose(RxScheduler.<BaseResponse<EmptyResponse>>observeOnMainThread())
//                        .as(RxScheduler.<BaseResponse<EmptyResponse>>bindLifecycle(this))
//                        .subscribe(new BaseObserver<EmptyResponse>() {
//                            @Override
//                            public void onSuccess(EmptyResponse emptyResponse) {
//                                ToastUtils.showShort("修改成功");
//                                finish();
//                                readyGoActivity(LoginActivity.class);
//                            }
//
//                            @Override
//                            public void onFail(int code, String error) {
//
//                            }
//                        });
                break;
        }
    }

    private void getVerifyCode() {
//        String account = etAccount.getText().toString();
//        if ("".equals(account)) {
//            ToastUtils.showShort("请输入手机号");
//            return;
//        }
//        RetrofitManager.build().create(UserService.class)
//                .getCode(1, account)
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
