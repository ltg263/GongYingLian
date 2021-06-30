package com.jxxx.gyl.view.activity.address;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class ActivityAddressList extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;

    @BindView(R.id.lv_not)
    LinearLayout lv_not;
    int source = 0;
    int type = 0;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    AdapterListAddress mAdapterListAddress;
    private List<AddressData> addressDataList = new ArrayList<>();

    @Override
    public int intiLayout() {
        return R.layout.activity_address_list;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "地址管理");
        source = getIntent().getIntExtra("source", 0);
        type = getIntent().getIntExtra("type", 0);
        initRv();

    }

    @Override
    public void initData() {

    }

    public static void startActivity(Context  mContext, int type) {
        Intent intent = new Intent(mContext, ActivityAddressList.class);
        intent.putExtra("type",type);//1回调，
        intent.putExtra("source", 1);
        ((Activity)mContext).startActivityForResult(intent, 20);
    }

    private void initRv() {
        rvList.setLayoutManager(new LinearLayoutManager(ActivityAddressList.this));
        rvList.setHasFixedSize(true);
        mAdapterListAddress = new AdapterListAddress(addressDataList);
        rvList.setAdapter(mAdapterListAddress);
        mAdapterListAddress.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.w("---,","source:"+source);
                if (source == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("address",addressDataList.get(position));
                    ActivityAddressEdit.startActivity(view.getContext(),bundle);
                } else {
                    if(type==1){
                        EventBus.getDefault().post(addressDataList.get(position));
                        finish();
                    }
                    if(type==2){
                        //Activity返回时传递数据，也是通过意图对象
                        Intent data = new Intent();
                        //把要传递的数据封装至意图对象中
                        data.putExtra("address", addressDataList.get(position));

                        //当前Activity销毁时，data这个意图就会传递给启动当前Activity的那个Activity
                        setResult(1, data);

                        //销毁当前Activity
                        finish();
                    }
                }
            }
        });
        mAdapterListAddress.setOnDeleteClickListener(new AdapterListAddress.OnDeleteClickLister() {
            @Override
            public void onDeleteClick(int position) {
                getDeleteAddress(addressDataList.get(position).getId()+"");
            }

            @Override
            public void onDefaultClick(int position) {
                getSetDefault(addressDataList.get(position).getId()+"");
            }
        });

    }

    @OnClick({R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                ActivityAddressEdit.startActivity(view.getContext(),null);
                break;
            default:
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        show(AddressActivity.this,"加载中");
        getUserAddress();
    }

    private void getUserAddress() {
//        RetrofitUtil.getInstance().apiService()
//                .getUserAddress("1", "100")
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<BaseResult<AddressModel>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(BaseResult<AddressModel> result) {
//                        if(result.getCode().equals("000000")){
//                            if(result.getData()!=null){
//                                addressDataList.clear();
//                                if(result.getData().getList()!=null){
//                                    lv_not.setVisibility(View.GONE);
//                                    rvList.setVisibility(View.VISIBLE);
//                                    addressDataList.addAll(result.getData().getList());
//                                    mAddressAdapter.notifyDataSetChanged();
//                                }
//                            }
//                        }
//
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onComplete() {
//                    }
//                });
    }

    /**
     * 设置默认地址
     */
    private void getSetDefault(String id) {
//        show(AddressActivity.this,"加载中");
//        RetrofitUtil.getInstance().apiService()
//                .getSetDefault(id).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<BaseResult>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(BaseResult result) {
//                        if(result.getCode().equals("000000")){
//                            getUserAddress();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        dismiss();
//                    }
//
//                    @Override
//                    public void onComplete() {
////                        dismiss();
//                    }
//                });


    }
    /**
     * 删除地址
     */
    private void getDeleteAddress(String id) {
//        show(AddressActivity.this,"加载中");
//        RetrofitUtil.getInstance().mApiService()
//                .getDeleteAddress(id).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<BaseResult>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(BaseResult result) {
//                        if(result.getCode().equals("000000")){
//                            getUserAddress();
//                        }else{
//                            ToastUtils.showShort(result.getMesg());
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
////                        dismiss();
//                    }
//
//                    @Override
//                    public void onComplete() {
////                        dismiss();
//                    }
//                });
//
    }

}
