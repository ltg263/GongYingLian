package com.jxxx.gyl.view.activity.address;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.AddressModel;

import java.util.List;

/**
 * author : LiuJie
 * date   : 2020/5/2914:03
 */
public class AdapterListAddress extends BaseQuickAdapter<AddressModel, BaseViewHolder> {
    public AdapterListAddress(@Nullable List<AddressModel> data) {
        super(R.layout.item_address, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, AddressModel item) {
        ImageView defaultIv = helper.getView(R.id.iv_default);
        LinearLayout defaultLl = helper.getView(R.id.ll_default);
        TextView nameTv = helper.getView(R.id.tv_name);
        TextView phoneTv = helper.getView(R.id.tv_phone);
        TextView addressTv = helper.getView(R.id.tv_address);
        TextView editTv = helper.getView(R.id.tv_edit);
        TextView delTv = helper.getView(R.id.tv_del);
        nameTv.setText(item.getContact());
        phoneTv.setText(item.getPhone());
        addressTv.setText(item.getAddress()+"-"+item.getHouseNo());
        if (item.getDefaulted().equals("1")) {
            defaultIv.setSelected(true);
        } else {
            defaultIv.setSelected(false);
        }
        editTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("address", item);
                ActivityAddressEdit.startActivity(view.getContext(), bundle);
            }
        });
        delTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDeleteClickListener != null) {
                    mDeleteClickListener.onDeleteClick(helper.getLayoutPosition());
                }

            }
        });
        defaultLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDeleteClickListener != null) {
                    mDeleteClickListener.onDefaultClick(helper.getLayoutPosition());
                }
            }
        });
    }

    public void setOnDeleteClickListener(OnDeleteClickLister listener) {
        this.mDeleteClickListener = listener;
    }

    private OnDeleteClickLister mDeleteClickListener;

    public interface OnDeleteClickLister {
        void onDeleteClick(int position);

        void onDefaultClick(int position);
    }
}
