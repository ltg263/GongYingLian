package com.jxxx.gyl.view.activity.payActivity;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;

public class ActivityPayTiXianDetails extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @Override
    public int intiLayout() {
        return R.layout.activity_pay_ti_xian_details;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "提现详情");

    }

    @Override
    public void initData() {

    }
}
