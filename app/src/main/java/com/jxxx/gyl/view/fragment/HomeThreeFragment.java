package com.jxxx.gyl.view.fragment;


import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.MainActivity;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.HttpsUtils;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseFragment;
import com.jxxx.gyl.bean.OrderInfoBean;
import com.jxxx.gyl.bean.ShoppingCartListBean;
import com.jxxx.gyl.utils.ToastUtil;
import com.jxxx.gyl.utils.view.AddandView;
import com.jxxx.gyl.view.activity.login.LoginActivity;
import com.jxxx.gyl.view.adapter.HomeGoodsAdapter;
import com.jxxx.gyl.view.adapter.ShopCarGoodsAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeThreeFragment extends BaseFragment {

    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    @BindView(R.id.rv_shop_list)
    RecyclerView mRvShopList;
    @BindView(R.id.rl_not_shop)
    RelativeLayout mRlNotShop;
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    private HomeGoodsAdapter mHomeGoodsAdapter;
    private ShopCarGoodsAdapter mShopCarGoodsAdapter;

    private List<Integer> checkedSkuIdList = new ArrayList<>();
    private List<Integer> unCheckedSkuIdList = new ArrayList<>();
    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home_three;
    }

    @Override
    protected void initView() {
        mShopCarGoodsAdapter = new ShopCarGoodsAdapter(null);
        mRvShopList.setAdapter(mShopCarGoodsAdapter);
        mShopCarGoodsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ShoppingCartListBean.ItemListBean mItemListBean = mShopCarGoodsAdapter.getData().get(position);
                checkedSkuIdList.clear();
                unCheckedSkuIdList.clear();
                for(int i=0;i<mShopCarGoodsAdapter.getData().size();i++){
                    if(mShopCarGoodsAdapter.getData().get(i).getChecked().equals("1")){
                        checkedSkuIdList.add(Integer.valueOf(mShopCarGoodsAdapter.getData().get(i).getCartSpuDTO().getCartSkuDTO().getId()));
                    }
                    if(mShopCarGoodsAdapter.getData().get(i).getChecked().equals("0")){
                        unCheckedSkuIdList.add(Integer.valueOf(mShopCarGoodsAdapter.getData().get(i).getCartSpuDTO().getCartSkuDTO().getId()));
                    }
                }
                if(mItemListBean.getChecked().equals("1")){
                    checkedSkuIdList.remove(Integer.valueOf(mItemListBean.getCartSpuDTO().getCartSkuDTO().getId()));
                    unCheckedSkuIdList.add(Integer.valueOf(mItemListBean.getCartSpuDTO().getCartSkuDTO().getId()));
                }else{
                    checkedSkuIdList.add(Integer.valueOf(mItemListBean.getCartSpuDTO().getCartSkuDTO().getId()));
                    unCheckedSkuIdList.remove(Integer.valueOf(mItemListBean.getCartSpuDTO().getCartSkuDTO().getId()));
                }
                seleShop();
            }
        });

        mRvList.setHasFixedSize(true);
        mHomeGoodsAdapter = new HomeGoodsAdapter(null);
        mRvList.setAdapter(mHomeGoodsAdapter);


        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(mTvLogin.getText().toString().equals("去登录")){
                     LoginActivity.startActivityLogin(getActivity());
                     return;
                 }
                ((MainActivity)getActivity()).startFragmentTwo();
            }
        });
    }

    private void seleShop() {
        OrderInfoBean mOrderInfoBean = new OrderInfoBean();

        mOrderInfoBean.setShopCartChecked(checkedSkuIdList.toArray(new Integer[checkedSkuIdList.size()])
                ,unCheckedSkuIdList.toArray(new Integer[unCheckedSkuIdList.size()]));
        Log.e("mOrderInfoBean","mOrderInfoBean"+mOrderInfoBean.toString());
        RetrofitUtil.getInstance().apiService()
                .shoppingChecked(mOrderInfoBean)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<ShoppingCartListBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<ShoppingCartListBean> result) {
                        if(isResultOk(result)) {
                            mRlNotShop.setVisibility(View.GONE);
                            mRvShopList.setVisibility(View.VISIBLE);
                            mShopCarGoodsAdapter.setNewData(result.getData().getItemList());
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
        mTvLogin.setText("去购买");
        if(!ConstValues.ISLOGIN){
            mRlNotShop.setVisibility(View.VISIBLE);
            mRvShopList.setVisibility(View.GONE);
            mTvLogin.setText("去登录");
        }else {
            initData();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            initData();
        }
    }

    @Override
    public void initData() {
        RetrofitUtil.getInstance().apiService()
                .shoppingCartList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<ShoppingCartListBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<ShoppingCartListBean> result) {
                        if(isResultOk(result)) {
                            if(result.getData()!=null && result.getData().getItemList()!=null && result.getData().getItemList().size()>0){
                                mRlNotShop.setVisibility(View.GONE);
                                mRvShopList.setVisibility(View.VISIBLE);
                                mShopCarGoodsAdapter.setNewData(result.getData().getItemList());
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
}



