package com.jxxx.gyl.view.fragment;


import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.bean.CategoryDataList;
import com.jxxx.gyl.bean.GlobalAdconfigBean;
import com.jxxx.gyl.bean.HomeActivityData;
import com.jxxx.gyl.bean.HomeBannerData;
import com.jxxx.gyl.bean.HomeCategoryData;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.utils.StatusBarUtil;
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
    @BindView(R.id.rl_include_login)
    RelativeLayout rl_include_login;

    private HomeTypeAdapter mHomeTypeAdapter;
    private HomeTypeTjAdapter mHomeTypeTjAdapter;
    private HomeGoodsAdapter mHomeGoodsAdapter;
    @Override
    protected int setLayoutResourceID() {
        StatusBarUtil.setStatusBarMode(getActivity(), true, R.color.color_2E6DFB);
        return R.layout.fragment_home_one;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
            StatusBarUtil.setStatusBarMode(getActivity(), true, R.color.white);
        }else {
            initData();
            StatusBarUtil.setStatusBarMode(getActivity(), true, R.color.color_2E6DFB);
        }
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
        globalAdConfig();
        listCategory();
        homeActivityList("1");
    }

    private void globalAdConfig() {

        RetrofitUtil.getInstance().apiService()
                .globalAdConfig()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<GlobalAdconfigBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<GlobalAdconfigBean> result) {
                        if(isResultOk(result)) {
                            GlobalAdconfigBean.IndexPageBean indexPage = result.getData().getIndexPage();
                            if(indexPage.getStatus().equals("1")){
                                mHomeBannerGg.setVisibility(View.VISIBLE);
                                ArrayList<String> list_path = new ArrayList<>();
                                list_path.add(result.getData().getIndexPage().getImageUrl());
                                bannerConfig(mHomeBannerGg,list_path);

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

    @Override
    public void onResume() {
        super.onResume();
        rl_include_login.setVisibility(View.VISIBLE);
        if(ConstValues.ISLOGIN){
            rl_include_login.setVisibility(View.GONE);
        }
        initData();
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
                                ArrayList<String> list_path = new ArrayList<>();
                                for (int i = 0; i < result.getData().size(); i++) {
                                    list_path.add(result.getData().get(i).getImgUrl());
                                }
                                bannerConfig(mHomeBanner,list_path);
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
        String url = "api/scmp-application-mall/activity/list/"+category;
        RetrofitUtil.getInstance().apiService()
                .homeActivityList(url)
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

    private void bannerConfig(Banner mBanner,List<String> list_path) {

        //???????????????????????????????????????????????????????????????????????????
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //????????????????????????????????????????????????
        mBanner.setImageLoader(new GlideImageLoader());
        //????????????????????????????????????
        mBanner.setImages(list_path);
        //?????????????????????????????????????????????????????????????????????????????????????????????
        mBanner.setBannerAnimation(Transformer.Default);
        //??????????????????????????????
//        banner_theme.setBannerTitles(themeTitles);
        //????????????????????????
        mBanner.setDelayTime(3000);
        //???????????????????????????????????????????????????
        mBanner.isAutoPlay(true);
        //???????????????????????????????????????????????????
        mBanner.setIndicatorGravity(BannerConfig.CENTER)
                //???????????????????????????????????????????????????????????????????????????????????????????????????
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                    }
                })
                //????????????????????????????????????????????????
                .start();
    }
}



