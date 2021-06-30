package com.jxxx.gyl.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.activity.address.ActivityAddressList;
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

    @OnClick({R.id.rl_address, R.id.tv_invoice,R.id.tv_coupon,R.id.bnt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_address:
                ActivityAddressList.startActivity(OrderAffirmActivity.this,2);
                break;
            case R.id.tv_invoice:
                baseStartActivity(MineInvoiceActivity.class,null);
                break;
            case R.id.tv_coupon:
                baseStartActivity(OrderCouponListActivity.class,null);
                break;
            case R.id.bnt:
                baseStartActivity(OrderPayActivity.class,null);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20) {
            if (resultCode == 1) {
//                addressData = (AddressData) data.getSerializableExtra("address");
//                if (addressData == null) {
//                    tvAddress.setText("请选择收货地址");
//                } else {
//                    mTvAddressNameAndName.setText(addressData.getAcceptName()+"   "+addressData.getMobile());
//                    tvAddress.setVisibility(View.VISIBLE);
//                    tvAddress.setText(addressData.getRegions() + addressData.getLocation());
//                }
            }
        }

    }
}
