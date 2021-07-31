package com.jxxx.gyl.view.activity;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.utils.StringUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateShopResultActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.tv_r)
    TextView mTvR;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.btn)
    TextView mBtn;
    String str;
    @Override
    public int intiLayout() {
        return R.layout.activity_create_shop_result;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "审核结果");
        str = getIntent().getStringExtra(ConstValues.APPNAME_ENGLISH);
        if(StringUtil.isNotBlank(str)){
            mTvR.setText(str);
            tv.setVisibility(View.INVISIBLE);
            mBtn.setText("重新提交");
        }
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.btn)
    public void onClick() {
        if(StringUtil.isNotBlank(str)){
            baseStartActivity(CreateShopActivity.class,null);
            finish();
        }else{
            ToastUtils.showLong("去催");
        }
    }
}
