package com.jxxx.gyl.view.activity.payActivity;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class AdapterPayLogList extends BaseQuickAdapter<String, BaseViewHolder> {
    public AdapterPayLogList(@Nullable List<String> data) {
        super(R.layout.item_cash_history, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        helper.setGone(R.id.iv_icon_type, false)
//                .setGone(R.id.tv_status, false)
//                .setText(R.id.tv_name, item.getType().equals("2")?"余额钱包":"现金钱包")
//                .setText(R.id.tv_date, item.getCreateTime())
//                .setText(R.id.tv_money, item.getInOrOut().equals("1") ? "+" + item.getAmount() : "-" + item.getAmount());
    }
}
