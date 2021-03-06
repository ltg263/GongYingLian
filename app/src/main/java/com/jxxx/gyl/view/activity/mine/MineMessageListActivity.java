package com.jxxx.gyl.view.activity.mine;


import android.content.Intent;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.adapter.MineMessageAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class MineMessageListActivity extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvListMsg;
    private MineMessageAdapter mMineMessageAdapter;


    @Override
    public int intiLayout() {
        return R.layout.activity_refresh_list;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "个人信息");

    }

    @Override
    public void initData() {
        ArrayList<String> bannerImg = new ArrayList<>();
        bannerImg.add("https://static.howbuy.com/upload/smhyupload/HY-30218028.jpg");
        bannerImg.add("https://static.howbuy.com/upload/smhyupload/HY-30218028.jpg");
        bannerImg.add("https://static.howbuy.com/upload/smhyupload/HY-30218028.jpg");
        bannerImg.add("https://static.howbuy.com/upload/smhyupload/HY-30218028.jpg");
        mMineMessageAdapter = new MineMessageAdapter(bannerImg);
        mRvListMsg.setAdapter(mMineMessageAdapter);

        mMineMessageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
    }
}



