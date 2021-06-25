package com.jxxx.gyl.view.activity.search;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.adapter.HomeFyAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchResultTopicActivity extends BaseActivity {


    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.ll_no_data)
    LinearLayout llNoData;
    @BindView(R.id.rv_shopping_cart)
    RecyclerView mRvList;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String search;
    private HomeFyAdapter mHomeFyAdapter;


    @Override
    public int intiLayout() {
        return R.layout.activity_search_result_topic;
    }

    @Override
    public void initView() {
        search = getIntent().getStringExtra("search");
        tvTopTitle.setText(search);
        mRefreshLayout.setEnableLoadMore(false);
        mRefreshLayout.setEnableRefresh(false);

        mHomeFyAdapter = new HomeFyAdapter(null);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.setHasFixedSize(true);
        mRvList.setAdapter(mHomeFyAdapter);

        mHomeFyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                LotListBean.ListBean data = mBookingSpaceAdapter.getData().get(position);
//                Intent mIntent = new Intent(SearchResultTopicActivity.this, ShotCarDeActivity.class);
//                mIntent.putExtra("data", data);
//                startActivity(mIntent);
            }
        });
        getAllTopic();
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.img_top_back, R.id.tv_top_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_top_back:
            case R.id.tv_top_title:
                finish();
                break;
        }
    }

    private void getAllTopic(){
//        String lng = SharedUtils.singleton().get("Longitude", "");
//        String lat = SharedUtils.singleton().get("Latitude", "");
//        RetrofitUtil.getInstance().apiService()
//                .getLotList(null,search,lng,lat,null)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Result<LotListBean>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Result<LotListBean> result) {
//                        if (isDataInfoSucceed(result)) {
//                            if(result.getData().getList()!=null && result.getData().getList().size()>0){
//                                llNoData.setVisibility(View.GONE);
//                                mRefreshLayout.setVisibility(View.VISIBLE);
//                                mBookingSpaceAdapter.setNewData(result.getData().getList());
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onComplete() {
//                    }
//                });
    }

}
