package com.jxxx.gyl.view.activity;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderPayActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.iv_select_wx)
    ImageView mIvSelectWx;
    @BindView(R.id.iv_select_zfb)
    ImageView mIvSelectZfb;
    @BindView(R.id.iv_select_yhk)
    ImageView mIvSelectYhk;

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

    @OnClick({R.id.iv_select_wx, R.id.iv_select_zfb, R.id.iv_select_yhk, R.id.btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_select_wx:
                mIvSelectWx.setSelected(true);
                mIvSelectZfb.setSelected(false);
                mIvSelectYhk.setSelected(false);
                break;
            case R.id.iv_select_zfb:
                mIvSelectWx.setSelected(false);
                mIvSelectZfb.setSelected(true);
                mIvSelectYhk.setSelected(false);
                break;
            case R.id.iv_select_yhk:
                mIvSelectWx.setSelected(false);
                mIvSelectZfb.setSelected(false);
                mIvSelectYhk.setSelected(true);
                break;
            case R.id.btn:
                baseStartActivity(OrderPayOkActivity.class,null);
                break;
        }
    }

}
