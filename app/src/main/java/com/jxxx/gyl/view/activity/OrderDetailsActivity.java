package com.jxxx.gyl.view.activity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.adapter.OrderShopAdapter;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderDetailsActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.rv_shop_list)
    RecyclerView mRvShopList;
    OrderShopAdapter mOrderShopAdapter;
    @Override
    public int intiLayout() {
        return R.layout.activity_order_details;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "订单详情");
    }

    @Override
    public void initData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        mOrderShopAdapter = new OrderShopAdapter(list);
        mRvShopList.setAdapter(mOrderShopAdapter);
    }

}
