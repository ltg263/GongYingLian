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
    List<CommodityCategory.ListBean> data;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_two;
    }

    @Override
    protected void initView() {
        mHomeCategoryParentAdapter= new HomeCategoryParentAdapter(data);
        mHomeCategoryParentAdapter.setCurPos(pos);
        rvCategoryParent.setAdapter(mHomeCategoryParentAdapter);
        mHomeCategoryParentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mHomeCategoryParentAdapter.setCurPos(position);
                mHomeCategoryParentAdapter.notifyDataSetChanged();
                mHomeCategoryChildAdapter.setNewData(mHomeCategoryParentAdapter.getData().get(position).getChildren());
            }
        });
        smoothMoveToPosition(rvCategoryParent,pos);
        if(data!=null && data.size()>0){
            mHomeCategoryChildAdapter= new HomeCategoryChildAdapter(data.get(pos).getChildren());
            rvCategoryChirld.setAdapter(mHomeCategoryChildAdapter);
            mHomeCategoryChildAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    mHomeCategoryChildAdapter.setCurPos(position);
                    mHomeCategoryChildAdapter.notifyDataSetChanged();
                }
            });

        }
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
        mHomeCategoryContentAdapter.setNewData(data.get(0).getChildren());
    }

    public void setData(List<CommodityCategory.ListBean> data) {
        this.data=data;
        if(mHomeCategoryParentAdapter!=null){
            mHomeCategoryParentAdapter.setNewData(data);
        }
        if(mHomeCategoryChildAdapter!=null){
            mHomeCategoryChildAdapter.setNewData(data.get(0).getChildren());
        }
    }

    int pos = 0;
    public void setPos(int pos){
        this.pos = pos;
        if(mHomeCategoryParentAdapter!=null && mHomeCategoryChildAdapter!=null){
            mHomeCategoryParentAdapter.setCurPos(pos);
            mHomeCategoryParentAdapter.notifyDataSetChanged();
            mHomeCategoryChildAdapter.setNewData(mHomeCategoryParentAdapter.getData().get(pos).getChildren());
            smoothMoveToPosition(rvCategoryParent,pos);
        }
    }

    /**
     * 滑动到指定位置
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
}