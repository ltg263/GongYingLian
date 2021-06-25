package com.jxxx.gyl.view.activity.mine;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.utils.DialogHelper;
import com.jxxx.gyl.utils.DialogUtils;
import com.jxxx.gyl.view.activity.login.ForgetPasswordActivity;
import com.jxxx.gyl.view.activity.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MineSettingActivity extends BaseActivity {


    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;

    @BindView(R.id.tv_dqbb)
    TextView mTvDqbb;

    @Override
    public int intiLayout() {
        return R.layout.activity_mine_setting;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "设置");
    }

    @Override
    public void initData() {
        mTvDqbb.setText("当前版本V" + DialogHelper.getVersionName(this));
    }

    @OnClick({R.id.tv_logout,R.id.ll_1,R.id.ll_2,R.id.ll_3,R.id.ll_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_logout:
                DialogUtils.showDialogHint(this, "是否退出登录", false,
                        new DialogUtils.ErrorDialogInterface() {
                    @Override
                    public void btnConfirm() {
                        baseStartActivity(LoginActivity.class,null);
                        finish();
                    }
                });
                break;
                case R.id.ll_1:
                    baseStartActivity(MineInfoActivity.class,null);
                    break;
                case R.id.ll_2:
                    readyGoActivity(ForgetPasswordActivity.class);
                    break;
                case R.id.ll_3:
                    break;
                case R.id.ll_4:
                    break;
        }
    }
}
