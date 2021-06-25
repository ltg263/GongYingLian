package com.jxxx.gyl.view.activity.mine;

import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.utils.DialogHelper;

import butterknife.BindView;

public class MineSetGyActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.tv_dqbb)
    TextView tv_dqbb;

    @Override
    public int intiLayout() {
        return R.layout.activity_mine_set_gy;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "关于我们");
        tv_dqbb.setText("V"+ DialogHelper.getVersionName(this));
    }

    @Override
    public void initData() {

    }
}
