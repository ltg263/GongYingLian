package com.jxxx.gyl.view.activity;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderPayOkActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    Intent mIntent;
    boolean isResult;
    String status;
    @Override
    public int intiLayout() {
        return R.layout.activity_order_pay_ok;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "支付结果");
        mIntent  = getIntent();
        isResult = mIntent.getBooleanExtra("isResult",false);
        status = mIntent.getStringExtra("status");

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:

                break;
        }
    }

}
