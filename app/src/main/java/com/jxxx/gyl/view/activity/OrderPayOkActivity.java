package com.jxxx.gyl.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.MainActivity;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderPayOkActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.tv_orderAmount)
    TextView tv_orderAmount;
    @BindView(R.id.btn)
    TextView btn;
    Intent mIntent;
    boolean isResult;
    String status;
    String orderAmount;
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
        orderAmount = mIntent.getStringExtra("orderAmount");
        tv_orderAmount.setText("￥"+orderAmount);
    }

    @Override
    protected void onToolbarClickListener() {
        super.onToolbarClickListener();
        baseStartActivity(MainActivity.class);
    }

    @Override
    public void initData() {
        if(!isResult){
            btn.setText("支付失败");
            return;
        }
        if(status.equals("PAYING")){
            btn.setText("支付成功");
            return;
        }
        btn.setText("支付失败");
    }

    @OnClick({R.id.btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                baseStartActivity(MainActivity.class);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        baseStartActivity(MainActivity.class);
    }
}
