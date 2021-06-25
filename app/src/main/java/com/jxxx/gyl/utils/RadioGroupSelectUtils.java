package com.jxxx.gyl.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jxxx.gyl.R;
import com.jxxx.gyl.utils.view.CustomPopWindow;

public class RadioGroupSelectUtils {

    public CustomPopWindow mCustomPopWindow1,mCustomPopWindow2,mCustomPopWindow3,mCustomPopWindow4;

    public void setOnChangeListener(Activity mContext , RadioGroup mMRadioGroup, RadioButton mRbHomeSelect1, RadioButton mRbHomeSelect2,
                                           RadioButton mRbHomeSelect3, RadioButton mRbHomeSelect4){
        mMRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home_select1:
                        if (mCustomPopWindow1 == null)
                            mCustomPopWindow1 = showDistancePopup(mContext,mCustomPopWindow1,mRbHomeSelect1);
                        else {
                            mCustomPopWindow1.showAsDropDown(mRbHomeSelect1);
                        }
                        break;
                    case R.id.rb_home_select2:
                        if (mCustomPopWindow2 == null)
                            mCustomPopWindow2 = showDistancePopup(mContext,mCustomPopWindow2,mRbHomeSelect2);
                        else {
                            mCustomPopWindow2.showAsDropDown(mRbHomeSelect2);
                        }
                        break;
                    case R.id.rb_home_select3:
                        if (mCustomPopWindow3 == null)
                            mCustomPopWindow3 = showDistancePopup(mContext,mCustomPopWindow3,mRbHomeSelect3);
                        else {
                            mCustomPopWindow3.showAsDropDown(mRbHomeSelect3);
                        }
                        break;
                    case R.id.rb_home_select4:
                        if (mCustomPopWindow4 == null)
                            mCustomPopWindow4 = showDistancePopup(mContext,mCustomPopWindow4,mRbHomeSelect4);
                        else {
                            mCustomPopWindow4.showAsDropDown(mRbHomeSelect4);
                        }
                        break;
                }
            }
        });
    }

    private CustomPopWindow showDistancePopup(Activity mContext,  CustomPopWindow mCustomPopWindow,RadioButton mRbHomeSelect) {
        View view = mContext.getLayoutInflater().inflate(R.layout.pop_home_select, null, false);
        //创建并显示popWindow
        mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(mContext)
                .setView(view)
                .setFocusable(true)//是否获取焦点，默认为ture
                .setOnDissmissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        mRbHomeSelect.setChecked(false);
                    }
                })
                .setOutsideTouchable(true)//是否PopupWindow 以外触摸dissmiss
                .size(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)//显示大小
                .create()//创建PopupWindow
                .showAsDropDown(mRbHomeSelect, 0, 0);//显示PopupWindow
        // 设置按钮的点击事件
        RadioGroup rgb1 = view.findViewById(R.id.rgb_sort);
        CustomPopWindow finalMCustomPopWindow = mCustomPopWindow;
        rgb1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb11://3km以内
                        mRbHomeSelect.setText("3km以内");
                        finalMCustomPopWindow.dissmiss();
                        break;
                    case R.id.rb12://5
                        mRbHomeSelect.setText("5km以内");
                        finalMCustomPopWindow.dissmiss();
                        break;
                    case R.id.rb13://10
                        mRbHomeSelect.setText("10km以内");
                        finalMCustomPopWindow.dissmiss();
                        break;
                    case R.id.rb14://不限
                        mRbHomeSelect.setText("不限");
                        finalMCustomPopWindow.dissmiss();
                        break;
                }
            }
        });
        return mCustomPopWindow;
    }
}
