package com.jxxx.gyl.view.activity.payActivity;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的钱包
 */
public class ActivityPayHomeQb extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.rv_yz_list)
    RecyclerView mRvYzList;
    @BindView(R.id.tv_ye)
    TextView mTvYe;
    private AdapterPayLogList mAdapterPayLogList;

    @Override
    public int intiLayout() {
        return R.layout.activity_pay_home_pb;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "我的钱包");
        getAccount();
        initOrder();
    }

    @Override
    public void initData() {
        getAccount();
    }

    private void getAccount() {
//        show();
//        RetrofitUtil.getInstance().apiService()
//                .getAccount(1, StringUtil.getNyrDate())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Result<AccountBean>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Result<AccountBean> result) {
//                        if (isDataInfoSucceed(result)) {
//                            AccountBean data = result.getData();
//                            mTvYe.setText(data.getBalance()+"");
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        dismiss();
//                    }
//                });
    }

    @OnClick({R.id.tv_yz_tx, R.id.tv_yz_zz, R.id.tv_yz_rq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_yz_tx:
            case R.id.tv_yz_zz:
                baseStartActivity(ActivityPayTiXian.class,null);
                break;
            case R.id.tv_yz_rq:
//                baseStartActivity(MineWdyzDdcxActivity.class,null);
                break;
        }
    }

    private void initOrder() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        mRvYzList.setFocusable(false);
        mRvYzList.setLayoutManager(new LinearLayoutManager(this));
        mAdapterPayLogList = new AdapterPayLogList(list);
        mRvYzList.setAdapter(mAdapterPayLogList);
        mAdapterPayLogList.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                MineWdyzDetailsActivity.startIntentActivity(MineWdqbHomeActivity.this);
            }
        });
    }

}
