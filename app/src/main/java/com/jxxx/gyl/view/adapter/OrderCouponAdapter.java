package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.CouponTemplateData;
import com.jxxx.gyl.utils.StringUtil;

import java.util.List;

public class OrderCouponAdapter extends BaseQuickAdapter<CouponTemplateData, BaseViewHolder> {

    public OrderCouponAdapter(List<CouponTemplateData> data) {
        super(R.layout.item_order_coupon, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CouponTemplateData item) {
        helper.setText(R.id.tv_yhq,item.getCouponValue()).setText(R.id.tv_yhq_syfs_1,item.getTitle())
                .setText(R.id.tv_yhq_bt_1,item.getName()).setText(R.id.tv_yhq_sypt_1,item.getDescription())
                .setText(R.id.tv_yhq_type_1,"立即使用")
                .setText(R.id.tv_yhq_sj_1,"有效时间："+item.getInvalidTime()).addOnClickListener(R.id.tv_yhq_type_1);

        if(StringUtil.isNotBlank(item.getIsDraw())){
            helper.setText(R.id.tv_yhq_type_1,item.getIsDraw().equals("1")?"立即使用":"去领取");
        }
    }

}
