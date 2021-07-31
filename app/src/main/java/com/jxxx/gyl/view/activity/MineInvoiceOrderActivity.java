package com.jxxx.gyl.view.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.OrderHistoryBean;
import com.jxxx.gyl.bean.OrderHistoryDetailBean;
import com.jxxx.gyl.view.adapter.MineInvoiceOrderAdapter;
import com.jxxx.gyl.view.adapter.MineMessageAdapter;
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

public class MineInvoiceOrderActivity extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvListMsg;
    @BindView(R.id.bnt)
    TextView mBnt;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_not_data)
    TextView tv_not_data;
    @BindView(R.id.tv_je)
    TextView tv_je;
    @BindView(R.id.tv_hj)
    TextView tv_hj;
    @BindView(R.id.rl_data)
    RelativeLayout rl_data;
    @BindView(R.id.iv_select)
    ImageView iv_select;
    List<String> innerOrderNos = new ArrayList<>();
    int current = 1;
    private MineInvoiceOrderAdapter mMineInvoiceOrderAdapter;


    @Override
    public int intiLayout() {
        return R.layout.activity_mine_invoice_order;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "开发票");

        tv_je.setText("￥0.0");
        tv_hj.setText("共"+0+"个订单");
        mBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hj==0 || je==0 ||innerOrderNos.size()==0) {
                    ToastUtils.showLong("请选择开票的订单");
                    return;
                }
                String[] arr = innerOrderNos.toArray(new String[innerOrderNos.size()]);
                Intent mIntent = new Intent(MineInvoiceOrderActivity.this,MineInvoiceActivity.class);
                mIntent.putExtra("innerOrderNos",arr);
                mIntent.putExtra("receiptAmount",je+"");
                mIntent.putExtra("receiptContent","食品");
                MineInvoiceOrderActivity.this.startActivity(mIntent);
            }
        });
        iv_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<OrderHistoryDetailBean> data = mMineInvoiceOrderAdapter.getData();
                iv_select.setSelected(!iv_select.isSelected());
                for(int i=0;i<data.size();i++){
                    if(iv_select.isSelected()){
                        data.get(i).setSelect(true);
                    }else{
                        data.get(i).setSelect(false);
                    }
                }
                setUi();
            }
        });

        mMineInvoiceOrderAdapter = new MineInvoiceOrderAdapter(null);
        mRvListMsg.setAdapter(mMineInvoiceOrderAdapter);

        mMineInvoiceOrderAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                if(view.getId()==R.id.iv_select){
                    Log.w("---","-------------");
                    OrderHistoryDetailBean data = mMineInvoiceOrderAdapter.getData().get(position);
                    iv_select.setSelected(false);
                    data.setSelect(!data.isSelect());
                    setUi();
                }
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

    double je = 0.0;
    int hj = 0;
    private void setUi() {
        mMineInvoiceOrderAdapter.notifyDataSetChanged();
        List<OrderHistoryDetailBean> data = mMineInvoiceOrderAdapter.getData();
        innerOrderNos.clear();
        for(int i=0;i<data.size();i++){
            OrderHistoryDetailBean dataZ = data.get(i);
            if(dataZ.isSelect()){
                hj++;
                je +=Double.valueOf(dataZ.getPayAmount());
                innerOrderNos.add(dataZ.getInnerOrderNo());
            }
        }
        tv_je.setText("￥"+je);
        tv_hj.setText("共"+hj+"个订单");
    }

    @Override
    public void initData() {
        RetrofitUtil.getInstance().apiService()
                .getOrderHistoryList(current,10,true)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<OrderHistoryBean>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<OrderHistoryBean> result) {
                        if(isResultOk(result)) {
                            OrderHistoryBean mData = result.getData();
                            if(mData.getTotal()==0){
                                tv_not_data.setVisibility(View.VISIBLE);
                                rl_data.setVisibility(View.GONE);
                                return;
                            }
                            tv_not_data.setVisibility(View.GONE);
                            rl_data.setVisibility(View.VISIBLE);
                            List<OrderHistoryDetailBean> records = result.getData().getRecords();
                            if(current == 1){
                                mMineInvoiceOrderAdapter.setNewData(records);
                            }else{
                                mMineInvoiceOrderAdapter.addData(records);
                            }
                            if(mData.getTotal()<=mMineInvoiceOrderAdapter.getData().size()){
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
