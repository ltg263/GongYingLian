package com.jxxx.gyl.view.activity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.adapter.OrderApplyAfterAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public class OrderApplyAfterListActivity extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mRvListMsg;
    private OrderApplyAfterAdapter mOrderApplyAfterAdapter;


    @Override
    public int intiLayout() {
        return R.layout.activity_refresh_list;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "售后/退款");

    }

    @Override
    public void initData() {
        ArrayList<String> bannerImg = new ArrayList<>();
        bannerImg.add("https://static.howbuy.com/upload/smhyupload/HY-30218028.jpg");
        bannerImg.add("https://static.howbuy.com/upload/smhyupload/HY-30218028.jpg");
        bannerImg.add("https://static.howbuy.com/upload/smhyupload/HY-30218028.jpg");
        bannerImg.add("https://static.howbuy.com/upload/smhyupload/HY-30218028.jpg");
        mOrderApplyAfterAdapter = new OrderApplyAfterAdapter(bannerImg);
        mRvListMsg.setAdapter(mOrderApplyAfterAdapter);

        mOrderApplyAfterAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
    }
}
