package com.jxxx.gyl.view.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.adapter.ShopImageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderAffirmActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.rv_shop_list)
    RecyclerView mRvShopList;
    ShopImageAdapter mShopImageAdapter;
    @BindView(R.id.rl_address)
    RelativeLayout mRlAddress;
    @BindView(R.id.bnt)
    TextView mBnt;

    @Override
    public int intiLayout() {
        return R.layout.activity_order_affirm;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "确定订单");
        List<String> list = new ArrayList<>();
        list.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        list.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        list.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        list.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        list.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        list.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        mShopImageAdapter = new ShopImageAdapter(list);
        mRvShopList.setAdapter(mShopImageAdapter);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.rl_address, R.id.bnt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_address:
                break;
            case R.id.bnt:
                baseStartActivity(OrderPayActivity.class,null);
                break;
        }
    }
}
