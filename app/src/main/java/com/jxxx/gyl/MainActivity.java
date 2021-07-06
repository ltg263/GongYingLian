package com.jxxx.gyl;

import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.base.CommodityCategory;
import com.jxxx.gyl.utils.StatusBarUtil;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.view.fragment.HomeFiveFragment;
import com.jxxx.gyl.view.fragment.HomeFourFragment;
import com.jxxx.gyl.view.fragment.HomeOneFragment;
import com.jxxx.gyl.view.fragment.HomeThreeFragment;
import com.jxxx.gyl.view.fragment.HomeTwoFragment;

import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity{
    @BindView(R.id.bnv_home_navigation)
    BottomNavigationView mBnvHomeNavigation;
    private Fragment mFragment;
    private HomeTwoFragment mHomeTwoFragment;
    private HomeOneFragment mHomeOneFragment;
    private HomeThreeFragment mHomeThreeFragment;
    private HomeFourFragment mHomeFourFragment;
    private HomeFiveFragment mHomeFiveFragment;
    TextView tvNum;
    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initBottomBar();
        //获取整个的NavigationView
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) mBnvHomeNavigation.getChildAt(0);
        //这里就是获取所添加的每一个Tab(或者叫menu)，
        View tab = menuView.getChildAt(2);
        BottomNavigationItemView itemView = (BottomNavigationItemView) tab;
        //加载我们的角标View，新创建的一个布局
        View badge = LayoutInflater.from(this).inflate(R.layout.shop_car_num, menuView, false);
        //添加到Tab上
        itemView.addView(badge);
        tvNum = badge.findViewById(R.id.tv_num);
        //无消息时可以将它隐藏即可
        tvNum.setVisibility(View.GONE);
    }

    @Override
    public void initData() {
        ConstValues.SHOW_MAIN_FRAGMENT = "";
    }
    private void initBottomBar() {

        openLocation();
        mHomeOneFragment = new HomeOneFragment();
        mHomeTwoFragment = new HomeTwoFragment();
        mHomeThreeFragment = new HomeThreeFragment();
        mHomeFourFragment = new HomeFourFragment();
        mHomeFiveFragment = new HomeFiveFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameLayout, mHomeOneFragment).commit();

        mFragment = mHomeOneFragment;

        // 不使用图标默认变色
        mBnvHomeNavigation.setItemIconTintList(null);
        mBnvHomeNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_home_1:
                    switchFragment(mHomeOneFragment);
                    break;
                case R.id.menu_home_2:
                    switchFragment(mHomeTwoFragment);
                    break;
                case R.id.menu_home_3:
                    switchFragment(mHomeThreeFragment);
                    break;
                case R.id.menu_home_4:
                    switchFragment(mHomeFourFragment);
                    break;
                case R.id.menu_home_5:
                    switchFragment(mHomeFiveFragment);
                    break;
            }
            return true;
        });
        mBnvHomeNavigation.setSelectedItemId(R.id.menu_home_1);
    }
    public void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if (mFragment != fragment) {
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment).add(R.id.frameLayout, fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }

    /**
     * 开始定位（使用定位前必须请求定位权限，否则定位失败）
     */
    private void openLocation() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            Log.w("requestCode:", "requestCode:" );
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        } else {
            Log.w("requestCode:", "requestCode-----:");
            //开始定位
//            show(getActivity());
//            ZsnaviManager.getInstance(getActivity()).setOnLocationCallback(locationCallback);//设置定位回调
//            ZsnaviManager.getInstance(getActivity()).startLocation();//开启定位，该定位只会回调一次定位信息，建议使用完后调用停止定位接口
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(StringUtil.isNotBlank(ConstValues.SHOW_MAIN_FRAGMENT)){
            startFragmentTwo(ConstValues.SHOW_MAIN_FRAGMENT);
        }
    }

    public void startFragmentTwo(String type){
        switch (type){
            case "购物车":
                mBnvHomeNavigation.setSelectedItemId(R.id.menu_home_3);
                break;
            case "分类":
                mBnvHomeNavigation.setSelectedItemId(R.id.menu_home_2);
                break;
        }
        ConstValues.SHOW_MAIN_FRAGMENT = "";
//        mHomeTwoFragment.setPos(pos);
    }
    public void updateUI(){
        mHomeThreeFragment.initData();
    }

    int a = 1;
    public void setShopCarNum(String num){
        tvNum.setVisibility(View.VISIBLE);
        a++;
        tvNum.setText(a+"");
    }
}
