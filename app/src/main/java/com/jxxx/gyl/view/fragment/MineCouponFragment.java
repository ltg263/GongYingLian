package com.jxxx.gyl.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.bean.CouponTemplateData;
import com.jxxx.gyl.view.adapter.MineCouponListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MineCouponFragment extends BaseFragment {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    @BindView(R.id.tv_not_data)
    TextView mTvNotData;
    MineCouponListAdapter mMineCouponListAdapter;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    String status;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_refresh_list;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            status = bundle.getString("status");
        }
        myToolbar.setVisibility(View.GONE);
        mMineCouponListAdapter = new MineCouponListAdapter(null);
        mRvList.setAdapter(mMineCouponListAdapter);
        mRefreshLayout.setEnableLoadMore(false);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initData();
            }
        });

    }

    @Override
    protected void initData() {
        RetrofitUtil.getInstance().apiService()
                .userCouponList(status)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<CouponTemplateData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<CouponTemplateData>> result) {
                        hideLoading();
                        mRefreshLayout.finishRefresh();
                        if (isResultOk(result)) {
                            if(result.getData().size()==0){
                                mTvNotData.setVisibility(View.VISIBLE);
                                mRefreshLayout.setVisibility(View.GONE);
                                return;
                            }
                            mTvNotData.setVisibility(View.GONE);
                            mRefreshLayout.setVisibility(View.VISIBLE);

                            mMineCouponListAdapter.setNewData(result.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mRefreshLayout.finishRefresh();
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        mRefreshLayout.finishRefresh();
                        hideLoading();
                    }
                });
    }
}
