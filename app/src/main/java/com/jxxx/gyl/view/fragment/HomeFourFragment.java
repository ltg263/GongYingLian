package com.jxxx.gyl.view.fragment;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.view.activity.login.LoginActivity;
import com.jxxx.gyl.view.activity.mine.MineHtListActivity;
import com.jxxx.gyl.view.activity.mine.MineSetGyActivity;
import com.jxxx.gyl.view.activity.mine.MineSetSmrzActivity;
import com.jxxx.gyl.view.activity.mine.MineSettingActivity;
import com.jxxx.gyl.view.activity.payActivity.ActivityPayHomeQb;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFourFragment extends BaseFragment {

    @BindView(R.id.tv_user_name)
    TextView mTvUserName;
    @BindView(R.id.tv_user_info)
    TextView mTvUserInfo;
    @BindView(R.id.tv_user_img)
    ImageView mTvUserImg;
    @BindView(R.id.rl_user_info)
    RelativeLayout mRlUserInfo;
    @BindView(R.id.ll_top_1)
    LinearLayout mLlTop1;
    @BindView(R.id.ll_top_2)
    LinearLayout mLlTop2;
    @BindView(R.id.ll_top_3)
    LinearLayout mLlTop3;
    @BindView(R.id.ll_top_4)
    LinearLayout mLlTop4;
    @BindView(R.id.ll_center_1)
    LinearLayout mLlCenter1;
    @BindView(R.id.ll_center_2)
    LinearLayout mLlCenter2;
    @BindView(R.id.ll_center_3)
    LinearLayout mLlCenter3;
    @BindView(R.id.ll_center_4)
    LinearLayout mLlCenter4;
    @BindView(R.id.ll_center_5)
    LinearLayout mLlCenter5;
    @BindView(R.id.ll_center_6)
    LinearLayout mLlCenter6;
    @BindView(R.id.ll_center_7)
    LinearLayout mLlCenter7;
    @BindView(R.id.ll_center_8)
    LinearLayout mLlCenter8;
    @BindView(R.id.ll_below_1)
    LinearLayout mLlBelow1;
    @BindView(R.id.ll_below_2)
    LinearLayout mLlBelow2;
    @BindView(R.id.ll_below_3)
    LinearLayout mLlBelow3;
    @BindView(R.id.ll_below_4)
    LinearLayout mLlBelow4;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_four;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    }

    @OnClick({R.id.rl_user_info, R.id.ll_top_1, R.id.ll_top_2, R.id.ll_top_3, R.id.ll_top_4, R.id.ll_center_1,
            R.id.ll_center_2, R.id.ll_center_3, R.id.ll_center_4, R.id.ll_center_5, R.id.ll_center_6, R.id.ll_center_7,
            R.id.ll_center_8, R.id.ll_below_1, R.id.ll_below_2, R.id.ll_below_3, R.id.ll_below_4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_user_info:
                baseStartActivity(LoginActivity.class,null);
                break;
            case R.id.ll_top_1:
                baseStartActivity(MineHtListActivity.class,null);
                break;
            case R.id.ll_top_2:
                break;
            case R.id.ll_top_3:
                break;
            case R.id.ll_top_4:
                baseStartActivity(ActivityPayHomeQb.class,null);
                break;
            case R.id.ll_center_1:
                break;
            case R.id.ll_center_2:
                break;
            case R.id.ll_center_3:
                baseStartActivity(MineSetSmrzActivity.class,null);
                break;
            case R.id.ll_center_4:
                break;
            case R.id.ll_center_5:
                break;
            case R.id.ll_center_6:
                break;
            case R.id.ll_center_7:
                break;
            case R.id.ll_center_8:
                break;
            case R.id.ll_below_1:
                baseStartActivity(MineSettingActivity.class,null);
                break;
            case R.id.ll_below_2:
                break;
            case R.id.ll_below_3:
                baseStartActivity(MineSetGyActivity.class,null);
                break;
            case R.id.ll_below_4:
                break;
        }
    }
}



