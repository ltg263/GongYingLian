package com.jxxx.gyl.view.fragment;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.bean.AccoutInfoBean;
import com.jxxx.gyl.bean.UserInfoUpdate;
import com.jxxx.gyl.view.activity.MineCouponListActivity;
import com.jxxx.gyl.view.activity.MineInvoiceOrderActivity;
import com.jxxx.gyl.view.activity.OrderApplyAfterActivity;
import com.jxxx.gyl.view.activity.address.ActivityAddressList;
import com.jxxx.gyl.view.activity.login.LoginActivity;
import com.jxxx.gyl.view.activity.mine.MineMessageListActivity;
import com.jxxx.gyl.view.activity.mine.MineSetSmrzActivity;
import com.jxxx.gyl.view.activity.mine.MineSettingActivity;
import com.jxxx.gyl.view.activity.payActivity.ActivityPayHomeQb;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeFiveFragment extends BaseFragment {

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
    @BindView(R.id.ll_center_1)
    LinearLayout mLlCenter1;
    @BindView(R.id.ll_center_2)
    LinearLayout mLlCenter2;
    @BindView(R.id.ll_center_3)
    LinearLayout mLlCenter3;
    @BindView(R.id.ll_center_4)
    LinearLayout mLlCenter4;
    @BindView(R.id.ll_below_1)
    LinearLayout mLlBelow1;
    @BindView(R.id.ll_below_2)
    LinearLayout mLlBelow2;
    @BindView(R.id.ll_below_3)
    LinearLayout mLlBelow3;
    @BindView(R.id.ll_below_4)
    LinearLayout mLlBelow4;
    @BindView(R.id.tv_balance)
    TextView mTvBalance;
    @BindView(R.id.tv_owedAmount)
    TextView mTvOwedAmount;
    @BindView(R.id.tv_couponNum)
    TextView mTvCouponNum;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_five;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (!ConstValues.ISLOGIN) {
            mTvUserName.setText("请先登录");
            mTvUserInfo.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {
        RetrofitUtil.getInstance().apiService()
                .customerInfo().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<UserInfoUpdate>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<UserInfoUpdate> result) {
                        if (isResultOk(result)) {
                            UserInfoUpdate.BaseInfoBean baseInfo = result.getData().getBaseInfo();
                            mTvUserName.setText(baseInfo.getStorefrontName());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        RetrofitUtil.getInstance().apiService()
                .accountInfo().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<AccoutInfoBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<AccoutInfoBean> result) {
                        if (isResultOk(result)) {
                            mTvBalance.setText(result.getData().getBalance());
                            mTvOwedAmount.setText(result.getData().getOwedAmount());
                            mTvCouponNum.setText(result.getData().getCouponNum());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @OnClick({R.id.iv_set, R.id.iv_msg, R.id.rl_user_info, R.id.ll_top_1, R.id.ll_top_2, R.id.ll_top_3, R.id.ll_center_1,
            R.id.ll_center_2, R.id.ll_center_3, R.id.ll_center_4, R.id.ll_below_1, R.id.ll_below_2, R.id.ll_below_3, R.id.ll_below_4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_set:
                baseStartActivity(MineSettingActivity.class, null);
                break;
            case R.id.iv_msg:
                baseStartActivity(MineMessageListActivity.class, null);
                break;
            case R.id.rl_user_info:
                baseStartActivity(LoginActivity.class, null);
                break;
            case R.id.ll_top_1:
                baseStartActivity(ActivityPayHomeQb.class, null);
                break;
            case R.id.ll_top_2:
                break;
            case R.id.ll_top_3:
                baseStartActivity(MineCouponListActivity.class, null);
                break;
            case R.id.ll_center_1:
                ActivityAddressList.startActivity(getActivity(), 0);
                break;
            case R.id.ll_center_2:
                baseStartActivity(MineInvoiceOrderActivity.class, null);
                break;
            case R.id.ll_center_3:
                baseStartActivity(MineSetSmrzActivity.class, null);
                break;
            case R.id.ll_center_4:
                baseStartActivity(OrderApplyAfterActivity.class, null);
                break;
            case R.id.ll_below_1:
                break;
            case R.id.ll_below_2:
                break;
            case R.id.ll_below_3:
                break;
            case R.id.ll_below_4:
                break;
        }
    }
}



