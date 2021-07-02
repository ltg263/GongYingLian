package com.jxxx.gyl.view.fragment;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.MainActivity;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.ApiService;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.base.CommodityCategory;
import com.jxxx.gyl.bean.CategoryDataList;
import com.jxxx.gyl.bean.HomeActivityData;
import com.jxxx.gyl.bean.HomeBannerData;
import com.jxxx.gyl.bean.HomeCategoryData;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.view.activity.login.LoginActivity;
import com.jxxx.gyl.view.activity.search.SearchGoodsActivity;
import com.jxxx.gyl.view.adapter.HomeGoodsAdapter;
import com.jxxx.gyl.view.adapter.HomeTypeAdapter;
import com.jxxx.gyl.view.adapter.HomeTypeTjAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class HomeOneFragment extends BaseFragment {

    @BindView(R.id.home_banner)
    Banner mHomeBanner;
    @BindView(R.id.rv_list_type)
    RecyclerView mRvListType;
    @BindView(R.id.home_banner_gg)
    Banner mHomeBannerGg;
    @BindView(R.id.rv_list_type_tj)
    RecyclerView mRvListTypeTj;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private HomeTypeAdapter mHomeTypeAdapter;
    private HomeTypeTjAdapter mHomeTypeTjAdapter;
    private HomeGoodsAdapter mHomeGoodsAdapter;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_one;
    }


    @Override
    protected void initView() {
        mHomeTypeAdapter = new HomeTypeAdapter(null);
        mRvListType.setAdapter(mHomeTypeAdapter);
        mHomeTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                ((MainActivity)getActivity()).startFragmentTwo(position);
            }
        });

        mHomeTypeTjAdapter = new HomeTypeTjAdapter(null);
        mRvListTypeTj.setAdapter(mHomeTypeTjAdapter);
        mHomeTypeTjAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mHomeTypeTjAdapter.setCurPos(position);
                mHomeTypeTjAdapter.notifyDataSetChanged();
                homeActivityList(mHomeTypeTjAdapter.getData().get(position).getId());
            }
        });

        mRvList.setHasFixedSize(true);
        mHomeGoodsAdapter = new HomeGoodsAdapter(null);
        mRvList.setAdapter(mHomeGoodsAdapter);
    }

    @Override
    protected void initData() {
        getHomeBanner();
        homeListCategoryTop();
        listCategory();
        homeActivityList("1");
    }



    private void getHomeBanner(){
        RetrofitUtil.getInstance().apiService()
                .homeBanner()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<HomeBannerData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<HomeBannerData>> result) {
                        hideLoading();
                        if(isResultOk(result)){
                            if(result.getData()!=null){
                                bannerConfig(mHomeBanner,result.getData());
                            }
                        };
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }
    private void homeListCategoryTop(){
        RetrofitUtil.getInstance().apiService()
                .homeListCategoryTop()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<HomeCategoryData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<HomeCategoryData>> result) {
                        hideLoading();
                        if(isResultOk(result)){
                            if(result.getData()!=null){
                                mHomeTypeAdapter.setNewData(result.getData());
                            }
                        };
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }
    private void listCategory() {
        RetrofitUtil.getInstance().apiService()
                .listCategory()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<CategoryDataList>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<CategoryDataList>> result) {
                        hideLoading();
                        if(isResultOk(result)){
                            if(result.getData()!=null){
                                mHomeTypeTjAdapter.setNewData(result.getData());
                            }
                        };
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }

    private void homeActivityList(String category){
        RetrofitUtil.getInstance().apiService()
                .homeActivityList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<HomeActivityData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<HomeActivityData>> result) {
                        hideLoading();
                        if(isResultOk(result)){
                            if(result.getData()!=null){
                                mHomeGoodsAdapter.setNewData(result.getData());
                            }
                        };
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }

    @OnClick({R.id.address, R.id.tv_search,R.id.rl_include_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.address:

                break;
            case R.id.tv_search:
                baseStartActivity(SearchGoodsActivity.class,null);
                break;
            case R.id.rl_include_login:
                LoginActivity.startActivityLogin(getActivity());
                break;
        }
    }

    private void bannerConfig(Banner mBanner,List<HomeBannerData> list) {

        ArrayList<String> list_path = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list_path.add(list.get(i).getImgUrl());
        }
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器，图片加载器在下方
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片网址或地址的集合
        mBanner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        mBanner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
//        banner_theme.setBannerTitles(themeTitles);
        //设置轮播间隔时间
        mBanner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        mBanner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        mBanner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                    }
                })
                //必须最后调用的方法，启动轮播图。
                .start();
    }
}



