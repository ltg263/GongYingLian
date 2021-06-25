package com.jxxx.gyl.view.activity.payActivity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;

import java.util.List;

public class AdapterPayBankCardList extends BaseQuickAdapter<String, BaseViewHolder> {

    public AdapterPayBankCardList(List data) {
        super(R.layout.item_bank_card, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        helper.setText(R.id.bankName, item.getBank())
//                .setText(R.id.cardNo, item.getAccountNo());
//        helper.addOnClickListener(R.id.iv_delete).addOnClickListener(R.id.iv_mr);
//        helper.setImageResource(R.id.iv_mr, R.mipmap.ic_circle_no);
//        if (item.getStatus() == 1) {
//            helper.setImageResource(R.id.iv_mr, R.mipmap.ic_circle_yes_l);
//        }

    }

}
