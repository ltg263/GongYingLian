package com.jxxx.gyl.view.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.jxxx.gyl.R;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.utils.MagicIndicatorUtils;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.view.fragment.MineInvoice1Fragment;
import com.jxxx.gyl.view.fragment.MineInvoice2Fragment;

import net.lucode.hackware.magicindicator.MagicIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class MineInvoiceActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.magic_indicator)
    MagicIndicator mMagicIndicator;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private final String[] CHANNELS = new String[]{"电子普通发票", "专用发票"};
    private List<String> mDataList = Arrays.asList(CHANNELS);
    String[] innerOrderNos;
    String type;
    @Override
    public int intiLayout() {
        return R.layout.activity_toolbar_indicator_viewpager;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "发票信息");
        MagicIndicatorUtils.initMagicIndicator_1(this, mDataList, mMagicIndicator, mViewPager);
        initVP();
    }
    private void initVP() {
        type = getIntent().getStringExtra("type");
        if(StringUtil.isBlank(type)){
            innerOrderNos = getIntent().getStringArrayExtra("innerOrderNos");
        }
        getFragments();
        mViewPager.setOffscreenPageLimit(CHANNELS.length);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return "";
            }
        });

        mViewPager.setCurrentItem(0);
    }

    List<Fragment> fragments = new ArrayList<>();
    private List<Fragment> getFragments() {
        Log.w("innerOrderNos","innerOrderNos"+innerOrderNos);
        Bundle mBundle = new Bundle();
        mBundle.putString("type",type);
        mBundle.putStringArray("innerOrderNos",innerOrderNos);
        mBundle.putString("receiptAmount", getIntent().getStringExtra("receiptAmount"));
        mBundle.putString("receiptContent", getIntent().getStringExtra("receiptContent"));

        MineInvoice1Fragment mMineInvoice1Fragment = new MineInvoice1Fragment();
        mMineInvoice1Fragment.setArguments(mBundle);
        fragments.add(mMineInvoice1Fragment);

        MineInvoice2Fragment mMineInvoice2Fragment = new MineInvoice2Fragment();
        mMineInvoice2Fragment.setArguments(mBundle);
        fragments.add(mMineInvoice2Fragment);
        return fragments;
    }
    @Override
    public void initData() {

    }

}
