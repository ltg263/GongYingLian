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
import com.jxxx.gyl.base.CommodityCategory;
import com.jxxx.gyl.base.HomeCategoryTypeData;
import com.jxxx.gyl.view.activity.ShopDetailsActivity;
import com.jxxx.gyl.view.activity.login.LoginActivity;
import com.jxxx.gyl.view.activity.search.SearchGoodsActivity;
import com.jxxx.gyl.view.adapter.HomeCategoryChildAdapter;
import com.jxxx.gyl.view.adapter.HomeCategoryContentAdapter;
import com.jxxx.gyl.view.adapter.HomeCategoryParentAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 1000D 订单管理
 */
public class HomeTwoFragment extends BaseFragment {
    @BindView(R.id.rv_category_parent)
    RecyclerView rvCategoryParent;
    @BindView(R.id.rv_category_child)
    RecyclerView rvCategoryChirld;
    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    @BindView(R.id.rl_include_login)
    RelativeLayout rl_include_login;
    private HomeCategoryParentAdapter mHomeCategoryParentAdapter;
    private HomeCategoryChildAdapter mHomeCategoryChildAdapter;
    private HomeCategoryContentAdapter mHomeCategoryContentAdapter;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_two;
    }

    @Override
    protected void initView() {
        mHomeCategoryParentAdapter = new HomeCategoryParentAdapter(null);
        mHomeCategoryParentAdapter.setCurPos(0);
        rvCategoryParent.setAdapter(mHomeCategoryParentAdapter);
        mHomeCategoryParentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mHomeCategoryParentAdapter.setCurPos(position);
                mHomeCategoryParentAdapter.notifyDataSetChanged();
                mHomeCategoryChildAdapter.setCurPos(0);
                mHomeCategoryChildAdapter.setNewData(mHomeCategoryParentAdapter.getData().get(position).getSubList());
                listProductByCategory(mHomeCategoryChildAdapter.getData().get(0).getId());
            }
        });
        mHomeCategoryChildAdapter = new HomeCategoryChildAdapter(null);
        rvCategoryChirld.setAdapter(mHomeCategoryChildAdapter);
        mHomeCategoryChildAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mHomeCategoryChildAdapter.setCurPos(position);
                mHomeCategoryChildAdapter.notifyDataSetChanged();
                listProductByCategory(mHomeCategoryChildAdapter.getData().get(position).getId());
            }
        });
        mHomeCategoryContentAdapter = new HomeCategoryContentAdapter(null);
        rvContent.setAdapter(mHomeCategoryContentAdapter);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            initData();
        }
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
    @Override
    protected void initData() {
        RetrofitUtil.getInstance().apiService()
                .getCategoryListAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<CommodityCategory>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<CommodityCategory>> result) {
                        hideLoading();
                        if(isResultOk(result)){
                            if(result.getData()!=null){
                                mHomeCategoryParentAdapter.setNewData(result.getData());
                                if(result.getData().size()>0){
                                    mHomeCategoryChildAdapter.setCurPos(0);
                                    mHomeCategoryChildAdapter.setNewData(result.getData().get(0).getSubList());
                                    listProductByCategory(mHomeCategoryChildAdapter.getData().get(0).getId());
                                }
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

    private void listProductByCategory(String id) {
        RetrofitUtil.getInstance().apiService()
                .listProductByCategory(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<HomeCategoryTypeData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<HomeCategoryTypeData> result) {
                        hideLoading();
                        if(isResultOk(result)){
                            if(result.getData()!=null){
                                if(result.getData().getSpuList()!=null){
                                    mHomeCategoryContentAdapter.setNewData(result.getData().getSpuList());
                                }
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
//    int pos = 0;
//
//    public void setPos(int pos) {
//        this.pos = pos;
//        if (mHomeCategoryParentAdapter != null && mHomeCategoryChildAdapter != null) {
//            mHomeCategoryParentAdapter.setCurPos(pos);
//            mHomeCategoryParentAdapter.notifyDataSetChanged();
//            mHomeCategoryChildAdapter.setNewData(mHomeCategoryParentAdapter.getData().get(pos).getChildren());
//            smoothMoveToPosition(rvCategoryParent, pos);
//        }
//    }

    /**
     * 滑动到指定位置
     *
     * @param mRecyclerView
     * @param position
     */
    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));

        if (position < firstItem) {
            // 如果跳转位置在第一个可见位置之前，就smoothScrollToPosition可以直接跳转
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 跳转位置在第一个可见项之后，最后一个可见项之前
            // smoothScrollToPosition根本不会动，此时调用smoothScrollBy来滑动到指定位置
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 如果要跳转的位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
        }
    }

    @OnClick({R.id.tv_search, R.id.rl_include_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:
                baseStartActivity(SearchGoodsActivity.class,null);
                break;
            case R.id.rl_include_login:
                LoginActivity.startActivityLogin(getActivity());
                break;
        }
    }
}