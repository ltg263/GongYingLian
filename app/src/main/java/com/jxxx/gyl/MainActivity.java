package com.jxxx.gyl;

import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.fragment.HomeFiveFragment;
import com.jxxx.gyl.view.fragment.HomeFourFragment;
import com.jxxx.gyl.view.fragment.HomeOneFragment;
import com.jxxx.gyl.view.fragment.HomeThreeFragment;
import com.jxxx.gyl.view.fragment.HomeTwoFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity{
    @BindView(R.id.bnv_home_navigation)
    BottomNavigationView mBnvHomeNavigation;
    private Fragment mFragment;
    private HomeTwoFragment mHomeTwoFragment;
    private HomeOneFragment mHomeOneFragment;
    private HomeThreeFragment mHomeThreeFragment;
    private HomeFourFragment mHomeFourFragment;
    private HomeFiveFragment mHomeFiveFragment;
    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initBottomBar();
    }

    @Override
    public void initData() {

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
                    switchFragment(mHomeFourFragment);
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


}
