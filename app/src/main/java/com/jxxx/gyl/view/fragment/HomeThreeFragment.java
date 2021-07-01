package com.jxxx.gyl.view.fragment;


import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.gyl.R;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.view.adapter.HomeGoodsAdapter;
import com.jxxx.gyl.view.adapter.ShopCarGoodsAdapter;

import java.util.Arrays;

import butterknife.BindView;

public class HomeThreeFragment extends BaseFragment {

    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    @BindView(R.id.rv_shop_list)
    RecyclerView mRvShopList;
    @BindView(R.id.rl_not_shop)
    RelativeLayout mRlNotShop;
    private HomeGoodsAdapter mHomeGoodsAdapter;
    private ShopCarGoodsAdapter mShopCarGoodsAdapter;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_three;
    }

    @Override
    protected void initView() {
        mRlNotShop.setVisibility(View.GONE);
        mRvShopList.setVisibility(View.VISIBLE);
        mShopCarGoodsAdapter = new ShopCarGoodsAdapter(Arrays.asList(ConstValues.HOME_TYPE_NAME));
        mRvShopList.setAdapter(mShopCarGoodsAdapter);

        mRvList.setHasFixedSize(true);
        mHomeGoodsAdapter = new HomeGoodsAdapter(null);
        mRvList.setAdapter(mHomeGoodsAdapter);
    }

    @Override
    protected void initData() {

    }
}



