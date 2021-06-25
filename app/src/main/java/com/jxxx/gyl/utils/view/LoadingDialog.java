package com.jxxx.gyl.utils.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jxxx.gyl.R;


/**
 * Created by Stefan Lau on 2015/1/14.
 */
public class LoadingDialog extends Dialog {

    private ImageView imageView;

    private TextView txt;

    public LoadingDialog(Context context) {
        super(context);
        init();
    }

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
        init();
    }

    private void init() {
        this.setContentView(R.layout.dialog_loading);
        imageView = (ImageView) findViewById(R.id.iv_loading);
        txt = (TextView) findViewById(R.id.txt_message);
    }

    /**
     *
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        spinner.start();
    }

    /**
     * 设置Loading文本
     */
    public void setMessage(CharSequence message) {
        if (message != null && message.length() > 0) {
            txt.setVisibility(View.VISIBLE);
            txt.setText(message);
            txt.invalidate();
        }
    }

    /**
     * 设置Loading文本
     */
    public void setMessage(int resid) {
        txt.setVisibility(View.VISIBLE);
        txt.setText(resid);
        txt.invalidate();
    }

    /**
     * 显示Loading
     */
    public static LoadingDialog show(Context context, CharSequence message, boolean cancelable,
                                     OnCancelListener cancelListener) {
        LoadingDialog progressHUD = null;
        try {
            progressHUD = create(context, message, cancelable, cancelListener);
            progressHUD.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return progressHUD;
    }

    /**
     * 显示Loading
     */
    public static LoadingDialog show(Context context, int resId, boolean cancelable,
                                     OnCancelListener cancelListener) {
        LoadingDialog progressHUD = null;
        try {
            progressHUD = create(context, resId, cancelable, cancelListener);
            progressHUD.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return progressHUD;
    }

    /**
     * 显示Loading
     */
    public static LoadingDialog show(Context context, int message) {
        LoadingDialog progressHUD = null;
        try {
            progressHUD = show(context, context.getResources().getString(message), false, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return progressHUD;
    }

    /**
     * 显示Loading
     */
    public static LoadingDialog show(Context context, String message) {
        LoadingDialog progressHUD = null;
        try {
            progressHUD = show(context, message, false, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return progressHUD;
    }


    /**
     * 创建Loading
     */
    public static LoadingDialog create(Context context, CharSequence message, boolean cancelable,
                                       OnCancelListener cancelListener) {
        LoadingDialog dialog = new LoadingDialog(context, R.style.ProgressHUD);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle(null);
        dialog.setMessage(message);
        dialog.setCanceledOnTouchOutside(cancelable);
        dialog.setCancelable(true);
        dialog.setOnCancelListener(cancelListener);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.dimAmount = 0.1f;
        lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

    /**
     * 创建Loading
     */
    public static LoadingDialog create(Context context, int resId, boolean cancelable,
                                       OnCancelListener cancelListener) {
        LoadingDialog dialog = new LoadingDialog(context, R.style.ProgressHUD);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle(null);
        dialog.setMessage(resId);
        dialog.setCanceledOnTouchOutside(cancelable);
        dialog.setCancelable(true);
        dialog.setOnCancelListener(cancelListener);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.dimAmount = 0.1f;
        lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

}
