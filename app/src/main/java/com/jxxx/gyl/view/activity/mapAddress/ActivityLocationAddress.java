package com.jxxx.gyl.view.activity.mapAddress;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ActivityLocationAddress extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.rv_list)
    RecyclerView mMRecyclerView;
    private AdapterLocationAddress mAdapterLocationAddress;

    @Override
    public int intiLayout() {
        return R.layout.activity_refresh_list;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "选择历史地址");


        List<HistoryAddressData> had = SharedHistoryAddress.singleton().getHistoryAddressData();

        if(had!=null && had.size()>0){
            List<HistoryAddressData> hadLs = new ArrayList<>();
            for(int i=0;i<had.size();i++){
                if(!StringUtils.isEmpty(had.get(i).getAddress()) && had.get(i).getLatLng()!=null){
                    hadLs.add(had.get(i));
                }
            }
            SharedHistoryAddress.singleton().clear();
            SharedHistoryAddress.singleton().putHistoryAddressData(hadLs);
            mAdapterLocationAddress = new AdapterLocationAddress(hadLs);
            mMRecyclerView.setAdapter(mAdapterLocationAddress);
            mAdapterLocationAddress.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    List<HistoryAddressData> data = mAdapterLocationAddress.getData();
                    Intent intent = new Intent();
                    intent.putExtra("address",data.get(position).getAddress());
                    intent.putExtra("lat",data.get(position).getLatLng());
                    intent.putExtra("addressXq",data.get(position).getAddressXq());
                    setResult(1,intent);
                    finish();
                }
            });
        }


    }

    @Override
    public void initData() {

    }
}
