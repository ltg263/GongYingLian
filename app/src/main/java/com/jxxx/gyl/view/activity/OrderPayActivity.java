package com.jxxx.gyl.view.activity;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;

public class OrderPayActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @Override
    public int intiLayout() {
        return R.layout.activity_order_pay;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "订单支付");

    }

    @Override
    public void initData() {

    }
}
