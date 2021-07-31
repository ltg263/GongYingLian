package com.jxxx.gyl.view.activity;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.OrderHistoryDetailBean;
import com.jxxx.gyl.bean.PostOrderSubmit;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.utils.ToastUtil;
import com.jxxx.gyl.view.adapter.OrderAfterSmAdapter;
import com.jxxx.gyl.view.adapter.OrderShopAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderApplyAfterActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.rv_shop_list)
    RecyclerView mRvShopList;
    @BindView(R.id.rv_list_tksm)
    RecyclerView mRvListTksm;
    @BindView(R.id.bnt)
    TextView bnt;
    OrderShopAdapter mOrderShopAdapter;
    OrderAfterSmAdapter mOrderAfterSmAdapter;
    List<OrderHistoryDetailBean.OrderDetailListBean> orderDetailList;
    String refundDesc;
    @Override
    public int intiLayout() {
        return R.layout.activity_apply_after;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "申请退款");
        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderRefund();
            }
        });
        orderDetailList = getIntent().getParcelableArrayListExtra("orderDetailList");
    }

    @Override
    public void initData() {
        mOrderShopAdapter = new OrderShopAdapter(orderDetailList);
        mRvShopList.setAdapter(mOrderShopAdapter);

        List<String> lists = Arrays.asList(ConstValues.ORDER_REFUND);
        mOrderAfterSmAdapter = new OrderAfterSmAdapter(lists);
        mRvListTksm.setAdapter(mOrderAfterSmAdapter);
        mOrderAfterSmAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mOrderAfterSmAdapter.setCurPos(position);
                mOrderAfterSmAdapter.notifyDataSetChanged();
                refundDesc = lists.get(position);
            }
        });
    }
    private void orderRefund(){
        if(StringUtil.isBlank(refundDesc)){
            ToastUtils.showShort("请选择原因");
            return;
        }
        PostOrderSubmit.OrderCancel mOrderCancel = new PostOrderSubmit.OrderCancel();
        mOrderCancel.setRefundDesc(refundDesc);
        mOrderCancel.setInnerOrderNo(getIntent().getStringExtra("innerOrderNo"));
        RetrofitUtil.getInstance().apiService()
                .orderRefund(mOrderCancel)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(Result result) {
                        if(isResultOk(result)){
                            baseStartActivity(OrderApplyAfterListActivity.class,null);
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
