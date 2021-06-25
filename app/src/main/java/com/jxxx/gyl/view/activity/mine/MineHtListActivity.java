package com.jxxx.gyl.view.activity.mine;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.adapter.MineListHtAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MineHtListActivity extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private MineListHtAdapter mMineListHtAdapter;

    @Override
    public int intiLayout() {
        return R.layout.activity_refresh_list;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "我的合同");
    }

    @Override
    public void initData() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        mMineListHtAdapter = new MineListHtAdapter(list);
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
                    case R.id.bnt_jy:
                        break;
                    case R.id.bnt_xy:
                        break;
                    case R.id.bnt_zd:
                        break;

                }
            }
        });
    }
}
