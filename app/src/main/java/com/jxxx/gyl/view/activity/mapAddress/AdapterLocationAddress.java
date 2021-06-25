package com.jxxx.gyl.view.activity.mapAddress;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class AdapterLocationAddress extends BaseQuickAdapter<HistoryAddressData, BaseViewHolder> {

    public AdapterLocationAddress(List data) {
        super(R.layout.item_address_location, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HistoryAddressData item) {
        helper.setText(R.id.tv_name,item.getAddress()).setText(R.id.tv_namexq,item.getAddressXq());
    }

}
