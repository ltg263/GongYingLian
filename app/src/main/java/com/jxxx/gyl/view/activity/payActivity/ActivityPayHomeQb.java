package com.jxxx.gyl.view.activity.payActivity;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.AccoutInfoBean;
import com.jxxx.gyl.bean.UserInfoUpdate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 我的钱包
 */
public class ActivityPayHomeQb extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.tv_balance)
    TextView tv_balance;
    private AdapterPayLogList mAdapterPayLogList;

    @Override
    public int intiLayout() {
        return R.layout.activity_pay_home_pb;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "我的钱包");
        getAccount();
    }

    @Override
    public void initData() {
        tv_balance.setText(getIntent().getStringExtra(ConstValues.APPNAME_ENGLISH));
        getAccount();
    }

    private void getAccount() {
        RetrofitUtil.getInstance().apiService()
                .accountInfo().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<AccoutInfoBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<AccoutInfoBean> result) {
                        if(isResultOk(result)) {

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

    @OnClick({R.id.tv_yz_tx, R.id.tv_yz_zz,R.id.ll_1,R.id.ll_2,R.id.ll_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_yz_tx:
                baseStartActivity(ActivityPayTiXian.class,null);
                break;
            case R.id.tv_yz_zz:
                baseStartActivity(ActivityPayChongZhi.class,null);
                break;
            case R.id.ll_1:

                break;
            case R.id.ll_2:
                baseStartActivity(ActivityPayHomeQk.class, getIntent().getStringExtra("owedAmount"));
                break;
            case R.id.ll_3:

                break;
        }
    }
}
