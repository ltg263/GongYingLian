package com.jxxx.gyl.view.activity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderPayOkActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;

    @Override
    public int intiLayout() {
        return R.layout.activity_order_pay;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "支付成功");

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
