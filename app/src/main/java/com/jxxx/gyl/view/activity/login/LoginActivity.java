package com.jxxx.gyl.view.activity.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.HttpsUtils;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.LoginData;
import com.jxxx.gyl.bean.LoginRequest;
import com.jxxx.gyl.bean.ParamData;
import com.jxxx.gyl.utils.SharedUtils;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.utils.ToastUtil;
import com.jxxx.gyl.view.activity.mine.WebViewActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_verify)
    EditText etVerify;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.auth_code)
    TextView authCode;
    @BindView(R.id.tv_info)
    TextView tvInfo;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.ll_yzm)
    LinearLayout ll_yzm;
    @BindView(R.id.ll_password)
    LinearLayout ll_password;

    private int type = 0;//0密码登录  1验证码

    public static void startActivityLogin(Context mContext) {
        mContext.startActivity(new Intent(mContext, LoginActivity.class));
    }

    @Override
    public int intiLayout() {
        SharedUtils.singleton().put(ConstValues.TOKEN,"");
        SharedUtils.singleton().put(ConstValues.USERID,"");
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "登录");
        changeUI();
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.tv_phone, R.id.tv_code, R.id.auth_code, R.id.tv_forget, R.id.tv_register, R.id.tv_login, R.id.ll_yhxy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_phone:
                type = 0;
                changeUI();
                break;
            case R.id.tv_code:
                type = 1;
                changeUI();
                break;
            case R.id.auth_code:
                String account = etAccount.getText().toString();
                if (StringUtil.isBlank(account)) {
                    ToastUtil.showLongStrToast(this, "请输入手机号");
                    return;
                }
                HttpsUtils.getVerifyCode(this,authCode,account,"2");
                break;
            case R.id.tv_forget:
                baseStartActivity(ForgetPasswordActivity.class);
                break;
            case R.id.tv_register:
                baseStartActivity(RegisterActivity.class);
                break;
            case R.id.tv_login:
                showLoading();
                if(type==0){
                    pwdLogin();
                }else{
                    smsLogin();
                }
                break;
            case R.id.ll_yhxy:
                baseStartActivity(WebViewActivity.class);
                break;
        }
    }

    private void pwdLogin() {
        LoginRequest bean = new LoginRequest();
        bean.setPhone(etAccount.getText().toString());
        bean.setCaptchaKey(Settings.Secure.getString(getApplication().getContentResolver(), Settings.Secure.ANDROID_ID));
        bean.setPassword(etPassword.getText().toString());
        RetrofitUtil.getInstance().apiService()
                .pwdLogin(bean)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<LoginData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<LoginData> result) {
                        hideLoading();
                        if(isResultOk(result)){
                            SharedUtils.singleton().put(ConstValues.TOKENID,result.getData().getAccessToken());
                            SharedUtils.singleton().put(ConstValues.USERID,result.getData().getUserId());
                            ToastUtils.showShort("登录成功");
                            finish();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }

    private void smsLogin() {
        LoginRequest bean = new LoginRequest();
        bean.setPhone(etAccount.getText().toString());
        bean.setSmsVerificationCode(etVerify.getText().toString());
        RetrofitUtil.getInstance().apiService()
                .smsLogin(bean)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<LoginData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<LoginData> result) {
                        hideLoading();
                        if(isResultOk(result)){
                            SharedUtils.singleton().put(ConstValues.TOKENID,result.getData().getAccessToken());
                            SharedUtils.singleton().put(ConstValues.USERID,result.getData().getUserId());
                            ToastUtils.showShort("登录成功");
                            finish();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }


    private void changeUI() {
        if (type == 0) {
            tvPhone.setTextSize(22);
            tvCode.setTextSize(18);
            tvPhone.setTextColor(getResources().getColor(R.color.color_333333));
            tvCode.setTextColor(getResources().getColor(R.color.color_666666));
            ll_yzm.setVisibility(View.GONE);
            ll_password.setVisibility(View.VISIBLE);
//            etVerify.setHint("请输入密码");
//            authCode.setVisibility(View.GONE);
        } else {
            tvPhone.setTextSize(18);
            tvCode.setTextSize(22);
            tvPhone.setTextColor(getResources().getColor(R.color.color_666666));
            tvCode.setTextColor(getResources().getColor(R.color.color_333333));
            ll_yzm.setVisibility(View.VISIBLE);
            ll_password.setVisibility(View.GONE);
//            etVerify.setHint("请输入验证码");
//            authCode.setVisibility(View.VISIBLE);
        }
    }
}
