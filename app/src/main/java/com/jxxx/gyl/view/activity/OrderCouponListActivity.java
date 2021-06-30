package com.jxxx.gyl.view.activity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.adapter.HomeOrderAdapter;
import com.jxxx.gyl.view.adapter.OrderCouponAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderCouponListActivity extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private OrderCouponAdapter mOrderCouponAdapter;

    @Override
    public int intiLayout() {
        return R.layout.activity_refresh_list;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "我的优惠券");
    }

    @Override
    public void initData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        mOrderCouponAdapter = new OrderCouponAdapter(list);
        mRvList.setAdapter(mOrderCouponAdapter);

        mOrderCouponAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
    }
}
