package com.jxxx.gyl.view.activity.mine;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;

public class MineInfoActivity extends BaseActivity {

    @BindView(R.id.include)
    Toolbar myToolbar;

    @Override
    public int intiLayout() {
        return R.layout.activity_mine_info;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "个人信息");
    }

    @Override
    public void initData() {

    }
}
