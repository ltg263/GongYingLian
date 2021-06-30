package com.jxxx.gyl.view.fragment;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.view.adapter.MineCouponListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MineCouponFragment extends BaseFragment {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    MineCouponListAdapter mMineCouponListAdapter;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_refresh_list;
    }

    @Override
    protected void initView() {
        myToolbar.setVisibility(View.GONE);
    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        mMineCouponListAdapter = new MineCouponListAdapter(list);
        mRvList.setAdapter(mMineCouponListAdapter);

    }
}
