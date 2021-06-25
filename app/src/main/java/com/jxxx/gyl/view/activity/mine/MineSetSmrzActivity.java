package com.jxxx.gyl.view.activity.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 实名认证
 * 编号：6140
 */
public class MineSetSmrzActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.et_sgmm_jmm)
    EditText mEtSgmmJmm;
    @BindView(R.id.et_sgmm_xmm)
    EditText mEtSgmmXmm;
    @BindView(R.id.tv_sgsjh_qr)
    TextView mTvSgsjhQr;

    @Override
    public int intiLayout() {
        return R.layout.activity_mine_set_smrz;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "实名认证");
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.tv_sgsjh_qr})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_sgsjh_qr:
                baseStartActivity(MineSetSmrz2Activity.class,null);

                break;
        }
    }


}
