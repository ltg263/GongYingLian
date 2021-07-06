package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.CouponTemplateData;

import java.util.List;

public class MineCouponListAdapter extends BaseQuickAdapter<CouponTemplateData, BaseViewHolder> {

    public MineCouponListAdapter(List<CouponTemplateData> data) {
        super(R.layout.item_mine_coupon, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CouponTemplateData item) {
        helper.setText(R.id.tv_title,item.getName()).setText(R.id.tv_1,item.getTitle())
                .setText(R.id.tv_2,"到期时间："+item.getInvalidTime()).setText(R.id.tv_5,item.getCouponValue())
                .setText(R.id.tv_3,item.getDescription());
        switch (item.getStatus()){
            case "0":
                helper.setText(R.id.tv_4,"未使用");
                break;
            case "1":
                helper.setText(R.id.tv_4,"已使用");
                break;
            case "2":
                helper.setText(R.id.tv_4,"已过期");
                break;
        }
    }

}
