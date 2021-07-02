package com.jxxx.gyl.view.activity;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;

public class CreateShopActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @Override
    public int intiLayout() {
        return R.layout.activity_create_shop;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "创建门店信息");
    }

    @Override
    public void initData() {

    }
}
