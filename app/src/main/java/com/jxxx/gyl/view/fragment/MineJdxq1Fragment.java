package com.jxxx.gyl.view.fragment;

import android.view.View;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseFragment;

import butterknife.OnClick;

public class MineJdxq1Fragment extends BaseFragment {
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_mine_jdxq_1;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.bnt_lxyx, R.id.bnt_qrz})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bnt_lxyx:
                break;
            case R.id.bnt_qrz:
                break;
        }
    }
}
