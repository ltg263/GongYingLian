package com.jxxx.gyl.view.activity;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.adapter.OrderAfterSmAdapter;
import com.jxxx.gyl.view.adapter.OrderShopAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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
                baseStartActivity(OrderApplyAfterListActivity.class,null);
            }
        });
    }

    @Override
    public void initData() {
        List<String> list = new ArrayList<>();
        list.add("买多了，买错了1");
        list.add("买多了，买错了2");
        list.add("买多了，买错了3");
        list.add("买多了，买错了4");
        mOrderShopAdapter = new OrderShopAdapter(null);
        mRvShopList.setAdapter(mOrderShopAdapter);

        mOrderAfterSmAdapter = new OrderAfterSmAdapter(list);
        mRvListTksm.setAdapter(mOrderAfterSmAdapter);
        mOrderAfterSmAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mOrderAfterSmAdapter.setCurPos(position);
                mOrderAfterSmAdapter.notifyDataSetChanged();
            }
        });
    }

}
