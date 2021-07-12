package com.jxxx.gyl.view.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.ArrayList;
import java.util.List;

public class HomeOrderAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HomeOrderAdapter(List<String> data) {
        super(R.layout.item_home_order, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.bnt_1).addOnClickListener(R.id.bnt_2).addOnClickListener(R.id.bnt_3);

        RecyclerView rvShopList = helper.getView(R.id.rv_shop_list);
        List<String> list = new ArrayList<>();
        list.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        list.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        list.add("http://img.netbian.com/file/2021/0527/1f20f9804cb7390efc842f02f4765901.jpg");
        rvShopList.setAdapter(new ShopImageAdapter(null));
    }

}
