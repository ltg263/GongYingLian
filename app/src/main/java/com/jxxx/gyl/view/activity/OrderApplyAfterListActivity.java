package com.jxxx.gyl.view.activity;

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
import com.jxxx.gyl.bean.OrderHistoryBean;
import com.jxxx.gyl.bean.OrderHistoryDetailBean;
import com.jxxx.gyl.bean.OrderRefundHistoryBean;
import com.jxxx.gyl.bean.PostOrderSubmit;
import com.jxxx.gyl.view.adapter.OrderApplyAfterAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderApplyAfterListActivity extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvListMsg;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_not_data)
    TextView tv_not_data;
    private OrderApplyAfterAdapter mOrderApplyAfterAdapter;

    int current =1;
    @Override
    public int intiLayout() {
        return R.layout.activity_refresh_list;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "售后/退款");
        mOrderApplyAfterAdapter = new OrderApplyAfterAdapter(null);
        mRvListMsg.setAdapter(mOrderApplyAfterAdapter);

        mOrderApplyAfterAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                baseStartActivity(OrderDetailsActivity.class,mOrderApplyAfterAdapter.getData().get(position).getInnerOrderNo());
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                current++;
                initData();
            }
        });
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                current = 1;
                initData();
            }
        });
    }

    @Override
    public void initData() {
        PostOrderSubmit.RefundHistory mRefundHistory = new PostOrderSubmit.RefundHistory();
        mRefundHistory.setCurrent(current);
        mRefundHistory.setSize(10);
        RetrofitUtil.getInstance().apiService()
                .orderRefundHistory(mRefundHistory)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<OrderRefundHistoryBean>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<OrderRefundHistoryBean> result) {
                        if(isResultOk(result)) {
                            OrderRefundHistoryBean mData = result.getData();
                            if(mData.getTotal()==0){
                                tv_not_data.setVisibility(View.VISIBLE);
                                mRefreshLayout.setVisibility(View.GONE);
                                return;
                            }
                            tv_not_data.setVisibility(View.GONE);
                            mRefreshLayout.setVisibility(View.VISIBLE);
                            List<OrderRefundHistoryBean.RecordsBean> records = result.getData().getRecords();
                            if(current == 1){
                                mOrderApplyAfterAdapter.setNewData(records);
                            }else{
                                mOrderApplyAfterAdapter.addData(records);
                            }
                            if(mData.getTotal()<=mOrderApplyAfterAdapter.getData().size()){
                                mRefreshLayout.setNoMoreData(true);
                            }
                            mRefreshLayout.finishLoadMore();
                            mRefreshLayout.finishRefresh();
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
}
