package com.jxxx.gyl.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.view.adapter.HomeOrderAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeOrderListFragment extends BaseFragment {
    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private HomeOrderAdapter mMineListHtAdapter;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_refresh_list;
    }

    @Override
    protected void initView() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        mMineListHtAdapter = new HomeOrderAdapter(list);
        mRvList.setAdapter(mMineListHtAdapter);

        mMineListHtAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        mMineListHtAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.bnt_1:
                        break;
                    case R.id.bnt_2:
                        break;
                    case R.id.bnt_3:
                        break;

                }
            }
        });

    }

    @Override
    protected void initData() {

    }
}
