package com.jxxx.gyl.view.fragment;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.view.activity.OrderDetailsActivity;
import com.jxxx.gyl.view.adapter.HomeOrderAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeOrderListFragment extends BaseFragment {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private HomeOrderAdapter mMineListHtAdapter;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_refresh_list;
    }

    @Override
    protected void initView() {
        myToolbar.setVisibility(View.GONE);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        mMineListHtAdapter = new HomeOrderAdapter(list);
        mRvList.setAdapter(mMineListHtAdapter);
        mMineListHtAdapter.addHeaderView(getTopView());
        mMineListHtAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                baseStartActivity(OrderDetailsActivity.class,null);
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
    private View getTopView(){
        View view = View.inflate(getActivity(), R.layout.item_home_order, null);
        view.findViewById(R.id.ll).setVisibility(View.VISIBLE);
        view.findViewById(R.id.rl).setVisibility(View.GONE);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showLong("去常用清单");
            }
        });
        return view;
    }
    @Override
    protected void initData() {

    }
}
