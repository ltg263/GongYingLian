package com.jxxx.gyl.view.activity.payActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ActivityPayTiXian extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.iv_select_wx)
    ImageView mIvSelectWx;
    @BindView(R.id.iv_select_zfb)
    ImageView mIvSelectZfb;
    @BindView(R.id.iv_select_yhk)
    ImageView mIvSelectYhk;
    @BindView(R.id.tv_add_car)
    TextView mTvAddCar;
    @BindView(R.id.et_txyz)
    EditText mEtTxyz;
    @BindView(R.id.tv_1)
    TextView tv_1;
    @BindView(R.id.tv_ktx)
    TextView mTvKtx;
    @BindView(R.id.tv_qbtx)
    TextView mTvQbtx;

    @Override
    public int intiLayout() {
        return R.layout.activity_pay_ti_xian;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "提现","提现记录");
        mIvSelectWx.setSelected(true);
        mIvSelectZfb.setSelected(false);
        mIvSelectYhk.setSelected(false);
    }

    @Override
    protected void onTitleRightClickListener() {
        super.onTitleRightClickListener();
        baseStartActivity(ActivityPayTiXianList.class,null);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.iv_select_wx, R.id.iv_select_zfb, R.id.iv_select_yhk, R.id.tv_add_car, R.id.tv_qbtx, R.id.btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_select_wx:
                mIvSelectWx.setSelected(!mIvSelectWx.isSelected());
                mIvSelectZfb.setSelected(false);
                mIvSelectYhk.setSelected(false);
                break;
            case R.id.iv_select_zfb:
                mIvSelectZfb.setSelected(!mIvSelectZfb.isSelected());
                mIvSelectWx.setSelected(false);
                mIvSelectYhk.setSelected(false);
                break;
            case R.id.iv_select_yhk:
                mIvSelectYhk.setSelected(!mIvSelectYhk.isSelected());
                mIvSelectWx.setSelected(false);
                mIvSelectZfb.setSelected(false);
                break;
            case R.id.tv_add_car:
                baseStartActivity(ActivityPayBankCardList.class, null);
                break;
            case R.id.tv_qbtx:

                break;
            case R.id.btn:
                break;
        }
    }
}
