package com.jxxx.gyl.view.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class HomeFyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HomeFyAdapter(List<String> data) {
        super(R.layout.item_home_fy_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.getView(R.id.rl_zfxq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

}
