package com.jxxx.gyl.view.activity.payActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ActivityPayTiXianList extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private AdapterPayTiXianList mAdapterPayTiXianList;

    @Override
    public int intiLayout() {
        return R.layout.activity_refresh_list;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "提现记录");
    }

    @Override
    public void initData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        mAdapterPayTiXianList = new AdapterPayTiXianList(list);
        mRvList.setAdapter(mAdapterPayTiXianList);

        mAdapterPayTiXianList.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                baseStartActivity(ActivityPayTiXianDetails.class,null);
            }
        });
    }
}
