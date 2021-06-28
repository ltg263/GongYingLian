package com.jxxx.gyl.view.fragment;


import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.gyl.R;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.view.adapter.HomeGoodsAdapter;

import java.util.Arrays;

import butterknife.BindView;

public class HomeThreeFragment extends BaseFragment {

    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    private HomeGoodsAdapter mHomeGoodsAdapter;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_three;
    }

    @Override
    protected void initView() {

        mRvList.setHasFixedSize(true);
        mHomeGoodsAdapter = new HomeGoodsAdapter(Arrays.asList(ConstValues.HOME_TYPE_NAME));
        mRvList.setAdapter(mHomeGoodsAdapter);
    }

    @Override
    protected void initData() {

    }
}



