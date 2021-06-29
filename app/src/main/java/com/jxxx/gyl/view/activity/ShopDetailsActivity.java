package com.jxxx.gyl.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.utils.StatusBarUtil;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.view.adapter.HomeGoodsAdapter;
import com.jxxx.gyl.view.adapter.HomeGoodsGzAdapter;

import java.util.Arrays;

import butterknife.BindView;

public class ShopDetailsActivity extends BaseActivity {
    @BindView(R.id.rv_xgsp)
    RecyclerView mRvXgsp;
    @BindView(R.id.rv_gui_ze)
    RecyclerView mRvGuiZe;
    @BindView(R.id.rv_tjsp)
    RecyclerView mRvTjsp;
    @BindView(R.id.web)
    WebView mWebView;
    private HomeGoodsAdapter mHomeGoodsAdapter;
    private HomeGoodsGzAdapter mHomeGoodsGzAdapter;

    @Override
    public int intiLayout() {
        StatusBarUtil.setTranslucentStatus(this);
        return R.layout.activity_shop_details;
    }

    @Override
    public void initView() {
        initWebView("123456");
        mHomeGoodsAdapter = new HomeGoodsAdapter(Arrays.asList(ConstValues.HOME_TYPE_NAME));
        mRvXgsp.setAdapter(mHomeGoodsAdapter);
        mRvTjsp.setAdapter(mHomeGoodsAdapter);

        mHomeGoodsGzAdapter = new HomeGoodsGzAdapter(Arrays.asList(ConstValues.HOME_TYPE_NAME).subList(0,3));
        mRvGuiZe.setAdapter(mHomeGoodsGzAdapter);
        mHomeGoodsGzAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mHomeGoodsGzAdapter.setCurPos(position);
                mHomeGoodsGzAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void initData() {

    }

    private void initWebView(String details) {
        WebSettings webSettings = mWebView.getSettings();//获取webview设置属性
        webSettings.setDefaultTextEncodingName("UTF-8");//设置默认为utf-8
        webSettings.setBlockNetworkImage(false); // 解决图片不显示
        //支持javascript
//        webSettings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebView.loadData(
                StringUtil.getNewContent1(details), "text/html; charset=UTF-8", null);//这种写法可以正确解码
    }
    public static void startActivityIntent(Context mContext, String id) {
        Intent mIntent = new Intent(mContext, ShopDetailsActivity.class);
        mContext.startActivity(mIntent);
    }
}
