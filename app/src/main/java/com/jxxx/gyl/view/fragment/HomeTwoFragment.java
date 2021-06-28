package com.jxxx.gyl.view.fragment;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.base.CommodityCategory;
import com.jxxx.gyl.view.adapter.HomeCategoryChildAdapter;
import com.jxxx.gyl.view.adapter.HomeCategoryContentAdapter;
import com.jxxx.gyl.view.adapter.HomeCategoryParentAdapter;

import java.util.List;

import butterknife.BindView;
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
    HomeCategoryParentAdapter mHomeCategoryParentAdapter;
    private HomeCategoryChildAdapter mHomeCategoryChildAdapter;
    private HomeCategoryContentAdapter mHomeCategoryContentAdapter;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_two;
    }

    @Override
    protected void initView() {
        mHomeCategoryParentAdapter= new HomeCategoryParentAdapter(null);
        rvCategoryParent.setAdapter(mHomeCategoryParentAdapter);
        mHomeCategoryParentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mHomeCategoryParentAdapter.setCurPos(position);
                mHomeCategoryParentAdapter.notifyDataSetChanged();
                mHomeCategoryChildAdapter.setNewData(mHomeCategoryParentAdapter.getData().get(position).getChildren());
            }
        });

        mHomeCategoryChildAdapter= new HomeCategoryChildAdapter(null);
        rvCategoryChirld.setAdapter(mHomeCategoryChildAdapter);
        mHomeCategoryChildAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mHomeCategoryChildAdapter.setCurPos(position);
                mHomeCategoryChildAdapter.notifyDataSetChanged();
            }
        });

        mHomeCategoryContentAdapter= new HomeCategoryContentAdapter(null);
        rvContent.setAdapter(mHomeCategoryContentAdapter);
        mHomeCategoryContentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mHomeCategoryChildAdapter.setCurPos(position);
                mHomeCategoryChildAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initData() {
        RetrofitUtil.getInstance().apiService()
                .getCategoryListAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<List<CommodityCategory.ListBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<List<CommodityCategory.ListBean>> listResult) {
                        mHomeCategoryParentAdapter.setNewData(listResult.getData());
                        mHomeCategoryChildAdapter.setNewData(listResult.getData().get(0).getChildren());
                        mHomeCategoryContentAdapter.setNewData(listResult.getData().get(0).getChildren());
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