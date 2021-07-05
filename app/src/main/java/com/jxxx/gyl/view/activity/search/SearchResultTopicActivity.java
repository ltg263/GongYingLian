package com.jxxx.gyl.view.activity.search;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.base.ShopInfoData;
import com.jxxx.gyl.view.activity.ShopDetailsActivity;
import com.jxxx.gyl.view.adapter.HomeCategoryContentAdapter;
import com.jxxx.gyl.view.adapter.HomeGoodsAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchResultTopicActivity extends BaseActivity {


    @BindView(R.id.include)
    Toolbar mMyToolbar;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.ll_no_data)
    LinearLayout llNoData;
    @BindView(R.id.rv_shopping_cart)
    RecyclerView mRvList;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String search;
    private HomeCategoryContentAdapter mHomeCategoryContentAdapter;


    @Override
    public int intiLayout() {
        return R.layout.activity_search_result_topic;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "搜索");
        search = getIntent().getStringExtra(ConstValues.BASE_STR);
        tvTopTitle.setText(search);
        mRefreshLayout.setEnableLoadMore(false);
        mRefreshLayout.setEnableRefresh(false);

        mHomeCategoryContentAdapter = new HomeCategoryContentAdapter(null);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.setAdapter(mHomeCategoryContentAdapter);

        mHomeCategoryContentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ShopDetailsActivity.startActivityIntent(
                        SearchResultTopicActivity.this,mHomeCategoryContentAdapter.getData().get(position).getId());
            }
        });
        getAllTopic();
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.activity_search_goods_search_tv, R.id.tv_top_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_search_goods_search_tv:
            case R.id.tv_top_title:
                finish();
                break;
        }
    }

    private void getAllTopic(){
        RetrofitUtil.getInstance().apiService()
                .productSearch(search)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<ShopInfoData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<ShopInfoData>> result) {
                        if (isResultOk(result)) {
                            if(result.getData()!=null && result.getData().size()>0){
                                llNoData.setVisibility(View.GONE);
                                mRefreshLayout.setVisibility(View.VISIBLE);
                                mHomeCategoryContentAdapter.setNewData(result.getData());
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

}
