package com.jxxx.gyl.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.jxxx.gyl.R;


public class DialogUtils {

    public static AlertDialog cancelDialog(Context context, String title, String content, DialogInterface.OnClickListener listener) {

        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(content)
                .setPositiveButton("确定",listener)
                .setNegativeButton("取消",null)
                .create();

    }
    public static AlertDialog donelDialog(Context context, String title, String content) {

        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(content)
                .setPositiveButton("确定",null)
                .create();

    }
    public static void showDialogHint(Context context, String title, boolean isOne, final ErrorDialogInterface dialogConfirm) {

        final Dialog dialog5 = new Dialog(context, R.style.selectorDialog);
        final View view = LayoutInflater.from(context).inflate(R.layout.common_dialog_affirm, null);
        TextView bt_ok = (TextView) view.findViewById(R.id.bt_confirm);
        TextView suanle = (TextView) view.findViewById(R.id.bt_suanle);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText(title);
        if(isOne){
            suanle.setVisibility(View.GONE);
        }
        suanle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog5.dismiss();
            }
        });
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialogConfirm!=null){
                    dialogConfirm.btnConfirm();
                }
                dialog5.dismiss();
            }
        });
        dialog5.setCancelable(false);
        dialog5.setContentView(view);
        dialog5.show();
    }

    public interface ErrorDialogInterface {
        /**
         * 确定
         */
        public void btnConfirm();
    }
}
