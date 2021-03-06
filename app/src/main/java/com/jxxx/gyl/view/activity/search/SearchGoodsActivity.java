package com.jxxx.gyl.view.activity.search;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.IntentUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.view.adapter.HomeGoodsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 搜索界面
 * 编号：1200
 */
public class SearchGoodsActivity extends BaseActivity {


    @BindView(R.id.include)
    Toolbar mMyToolbar;
    @BindView(R.id.tv_top_title)
    EditText searchEt;
    @BindView(R.id.activity_search_goods_search_tv)
    TextView mSearchTv;
    @BindView(R.id.rl_actionbar)
    RelativeLayout llActionbar;
    @BindView(R.id.flowlayout)
    ShoppingFlowLayout flowLayout;
    @BindView(R.id.flowlayout_rm)
    ShoppingFlowLayout flowLayoutRm;
    @BindView(R.id.activity_search_goods_history_ll)
    LinearLayout mHistoryLl;
    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;
    private String searchStr = null;
    public static SearchGoodsActivity activity;
    private HomeGoodsAdapter mHomeFyAdapter;

    @Override
    protected void onResume() {
        super.onResume();
        setHistorySearchData();
        if(searchStr!=null){
            searchEt.setSelection(searchStr.length());//将光标移至文字末尾
            getWindow().setSoftInputMode(WindowManager.LayoutParams
                    .SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }


    @Override
    public int intiLayout() {
        return R.layout.activity_search_goods;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "搜索");
        activity = this;
//        ImmersionBar.with(this).statusBarDarkFont(true).titleBar(R.id.rl_actionbar).fitsSystemWindows(true).init();
        setHistorySearchData();
        setHistorySearchDataRm();
        searchEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if(searchEt.getText().toString().trim().length()>0){
                        searchStr = searchEt.getText().toString().trim();
                        startSearchResultActivity(searchEt.getText().toString().trim());
                    }else {
                        Toast.makeText(SearchGoodsActivity.this,"请输入搜索内容",Toast.LENGTH_LONG).show();
                    }
                    return true;
                }
                return false;
            }
        });
        initRv();
    }

    @Override
    public void initData() {

    }

    private void initRv() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mHomeFyAdapter = new HomeGoodsAdapter(null);
        mRecyclerView.setAdapter(mHomeFyAdapter);
        mHomeFyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                startSearchResultActivity(mSearchListAdapter.getData().get(position).getParkingName());
            }
        });

        searchEt.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("字符变换后", "afterTextChanged");
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("字符变换前", s + "-" + start + "-" + count + "-" + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("字符变换中", s + "-" + "-" + start + "-" + before + "-" + count);
                if(s.length()>0){
//                    String lng = SharedUtils.singleton().get("Longitude", "");
//                    String lat = SharedUtils.singleton().get("Latitude", "");
//                    getLotList(s.toString(),lng, lat);
                }else{
                    mRecyclerView.setVisibility(View.GONE);
                }
            }
        });
    }

    private void getLotList(String search,String lng, String lat) {
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
//                            mRecyclerView.setVisibility(View.GONE);
//                            if (result.getData().getList() != null && result.getData().getList().size() > 0) {
//                                mRecyclerView.setVisibility(View.VISIBLE);
//                                mSearchListAdapter.setNewData(result.getData().getList());
//                            }
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

    }
    private void setHistorySearchData() {
        List<String> mHistoryList = SearchHistorySpUtil.getSearchHistory(SearchGoodsActivity.this,"goods","goodsName");
        //往容器内添加TextView数据
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 5, 10, 5);
        if (flowLayout != null) {
            flowLayout.removeAllViews();
        }
        for (int i = 0; i < mHistoryList.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(19, 5, 19, 5);
            tv.setText(mHistoryList.get(i));
            tv.setMaxEms(10);
            tv.setSingleLine();
                    tv.setBackgroundResource(R.drawable.circle_solid_f4f4f4_10);
            tv.setLayoutParams(layoutParams);
            final String name = mHistoryList.get(i);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchStr = name;
                    searchEt.setText(name);
                    startSearchResultActivity(searchEt.getText().toString().trim());

                }
            });
            flowLayout.addView(tv, layoutParams);
        }
    }
    private void setHistorySearchDataRm() {
        List<String> list = new ArrayList<>();
        list.add("123456");
        list.add("1234");
        list.add("123455456");
        list.add("12asdfads6");
        //往容器内添加TextView数据
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 5, 10, 5);
        if (flowLayoutRm != null) {
            flowLayoutRm.removeAllViews();
        }
        for (int i = 0; i < list.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(19, 5, 19, 5);
            tv.setText(list.get(i));
            tv.setMaxEms(10);
            tv.setSingleLine();
            tv.setBackgroundResource(R.drawable.circle_solid_f4f4f4_10);
            tv.setLayoutParams(layoutParams);
            final String name = list.get(i);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchStr = name;
                    searchEt.setText(name);
                    startSearchResultActivity(searchEt.getText().toString().trim());
                }
            });
            flowLayoutRm.addView(tv, layoutParams);
        }
    }

    @OnClick({R.id.activity_search_goods_search_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_search_goods_search_tv:
                if(searchEt.getText().toString().trim().length()>0){
                    startSearchResultActivity(searchEt.getText().toString().trim());
                }else {
                    Toast.makeText(SearchGoodsActivity.this,"请输入搜索内容",Toast.LENGTH_LONG).show();

                }
                break;
                default:
        }
    }

    private void startSearchResultActivity(String inputText) {
        SearchHistorySpUtil.saveSearchHistory(SearchGoodsActivity.this, "goods", "goodsName", inputText);
        baseStartActivity(SearchResultTopicActivity.class, inputText);
    }
}
