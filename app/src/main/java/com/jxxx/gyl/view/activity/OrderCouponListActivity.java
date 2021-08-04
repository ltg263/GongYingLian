package com.jxxx.gyl.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.CouponTemplateData;
import com.jxxx.gyl.bean.OrderInfoBean;
import com.jxxx.gyl.view.adapter.OrderCouponAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderCouponListActivity extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    @BindView(R.id.tv_not_data)
    TextView mTvNotData;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private OrderCouponAdapter mOrderCouponAdapter;
    private List<CouponTemplateData> recommendCoupon;


    @Override
    public int intiLayout() {
        return R.layout.activity_refresh_list;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "我的优惠券");

        mOrderCouponAdapter = new OrderCouponAdapter(null);
        mRvList.setAdapter(mOrderCouponAdapter);
        recommendCoupon = getIntent().getParcelableArrayListExtra("recommendCoupon");

        mRefreshLayout.setEnableLoadMore(false);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initData();
            }
        });

        mOrderCouponAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_yhq_type_1:
                        if (recommendCoupon != null) {
                            Intent data = new Intent();
                            //把要传递的数据封装至意图对象中
                            data.putExtra("userCouponId", recommendCoupon.get(position).getId());
                            data.putExtra("userCouponAmount", recommendCoupon.get(position).getCouponValue());
                            //当前Activity销毁时，data这个意图就会传递给启动当前Activity的那个Activity
                            setResult(1, data);
                            //销毁当前Activity
                            finish();
                            return;
                        }
                        if (mOrderCouponAdapter.getData().get(position).getIsDraw().equals("0")) {
                            couponTemplateReceive(mOrderCouponAdapter.getData().get(position).getId());
                        } else {
                            finish();
                        }
                        break;
                }
            }
        });
    }

    private void couponTemplateReceive(String id) {
        OrderInfoBean mOrderInfoBean = new OrderInfoBean();
        mOrderInfoBean.setCouponTemplateId(id);
        RetrofitUtil.getInstance().apiService()
                .couponTemplateReceive(mOrderInfoBean)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        hideLoading();
                        if (isResultOk(result)) {
                            initData();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }

    @Override
    public void initData() {
        if (recommendCoupon != null) {
            mOrderCouponAdapter.setNewData(recommendCoupon);
            return;
        }
        RetrofitUtil.getInstance().apiService()
                .couponTemplateList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<CouponTemplateData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<CouponTemplateData>> result) {
                        hideLoading();
                        if (isResultOk(result)) {
                            if(result.getData().size()==0){
                                mTvNotData.setVisibility(View.VISIBLE);
                                mRefreshLayout.setVisibility(View.GONE);
                                return;
                            }
                            mTvNotData.setVisibility(View.GONE);
                            mRefreshLayout.setVisibility(View.VISIBLE);
                            mOrderCouponAdapter.setNewData(result.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }
}
