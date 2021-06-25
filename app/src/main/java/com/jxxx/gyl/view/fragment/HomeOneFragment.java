package com.jxxx.gyl.view.fragment;


import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.utils.RadioGroupSelectUtils;
import com.jxxx.gyl.view.adapter.HomeFyAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeOneFragment extends BaseFragment {

    @BindView(R.id.home_banner)
    Banner mHomeBanner;
    @BindView(R.id.rb_home_select1)
    RadioButton mRbHomeSelect1;
    @BindView(R.id.rb_home_select2)
    RadioButton mRbHomeSelect2;
    @BindView(R.id.rb_home_select3)
    RadioButton mRbHomeSelect3;
    @BindView(R.id.rb_home_select4)
    RadioButton mRbHomeSelect4;
    @BindView(R.id.mRadioGroup)
    RadioGroup mMRadioGroup;
    @BindView(R.id.rv_home_list)
    RecyclerView mRvHomeList;
    @BindView(R.id.iv_icon)
    ImageView iv_icon;

    private HomeFyAdapter mHomeFyAdapter;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_one;
    }

    List<String> bannerImg = new ArrayList<>();
    @Override
    protected void initView() {
        GlideImageLoader.loadImageViewRadiusNoCenter(getActivity(),"http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg",iv_icon);

        bannerImg.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        bannerImg.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        bannerImg.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        bannerImg.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        bannerConfig();
        new RadioGroupSelectUtils().setOnChangeListener(getActivity(),mMRadioGroup,mRbHomeSelect1,mRbHomeSelect2,mRbHomeSelect3,mRbHomeSelect4);
    }

    @Override
    protected void initData() {

        mHomeFyAdapter = new HomeFyAdapter(bannerImg);
        mRvHomeList.setAdapter(mHomeFyAdapter);

        mHomeFyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    @OnClick({R.id.address, R.id.tv_search, R.id.ll_home_top1, R.id.ll_home_top2, R.id.ll_home_top3, R.id.ll_home_top4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.address:

                break;
            case R.id.tv_search:

                break;
            case R.id.ll_home_top1:
                break;
            case R.id.ll_home_top2:
                break;
            case R.id.ll_home_top3:
                break;
            case R.id.ll_home_top4:
                break;
        }
    }

    private void bannerConfig() {

        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        mHomeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器，图片加载器在下方
        mHomeBanner.setImageLoader(new GlideImageLoader());
        //设置图片网址或地址的集合
        mHomeBanner.setImages(bannerImg);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        mHomeBanner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
//        banner_theme.setBannerTitles(themeTitles);
        //设置轮播间隔时间
        mHomeBanner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        mHomeBanner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        mHomeBanner.setIndicatorGravity(BannerConfig.CENTER)
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



