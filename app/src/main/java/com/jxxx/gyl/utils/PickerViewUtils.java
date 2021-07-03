package com.jxxx.gyl.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.bean.CategoryTreeData;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;

public class PickerViewUtils {

    /**
     * 地址选择器
     * @param mContext
     */
    public static void onAddressPicker(Activity mContext,TextView mTv) {
        AddressPickTask task = new AddressPickTask(mContext);
        task.setHideProvince(false);
        task.setHideCounty(false);
        task.setCallback(new AddressPickTask.Callback() {

            @Override
            public void onAddressInitFailed() {
                ToastUtils.showShort("数据初始化失败");
            }

            @Override
            public void onAddressPicked(Province province, City city, County county) {
                if (county == null) {
                    mTv.setText(province.getAreaName() + "," + city.getAreaName());
                } else {
                    mTv.setText(province.getAreaName() + "," + city.getAreaName() + "," + county.getAreaName());
                }
            }
        });
        task.execute("北京", "北京", "北京");
    }



    /**
     * 自定义选择器
     * @param mContext
     * @param list
     * @param title
     * @param textView
     */
    public static void selectorCustom(Context mContext, final List<String> list, String title, final TextView textView){
        OptionsPickerView pvOptions = new OptionsPickerBuilder(mContext, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3 , View v) {
                textView.setText(list.get(options1));
            }
        }) .setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
            @Override
            public void onOptionsSelectChanged(int options1, int options2, int options3) {

            }
        })
                .setTitleText(title)
                .setDividerColor(Color.BLACK)
                .setSubmitColor(Color.BLACK)
                .setCancelColor(Color.BLACK)
                .setTextColorCenter(mContext.getResources().getColor(R.color.color_blue_theme)) //设置选中项文字颜色
                .setContentTextSize(16)
                .build();

        pvOptions.setPicker(list);//添加数据源
        pvOptions.show();
    }

    /**
     * 自定义选择器
     * @param mContext
     * @param title
     * @param textView
     */
    public static void selectorCategoryList(Context mContext, List<String> list,  List<List<String>> lists,String title, final TextView textView){
        OptionsPickerView pvOptions = new OptionsPickerBuilder(mContext, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3 , View v) {
//                textView.setText(lists.get(option2).getCategoryName());
            }
        }).setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
            @Override
            public void onOptionsSelectChanged(int options1, int options2, int options3) {

            }
        })
                .setTitleText(title)
                .setDividerColor(Color.BLACK)
                .setSubmitColor(Color.BLACK)
                .setCancelColor(Color.BLACK)
                .setTextColorCenter(mContext.getResources().getColor(R.color.color_blue_theme)) //设置选中项文字颜色
                .setContentTextSize(16)
                .build();

        pvOptions.setPicker(list,lists);//添加数据源
        pvOptions.show();
    }

    public static void selectorCustom(Context mContext, final List<String> list, String title, ConditionInterfacd interfacd){
        OptionsPickerView pvOptions = new OptionsPickerBuilder(mContext, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3 , View v) {
                interfacd.setIndex(options1);
            }
        }) .setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
            @Override
            public void onOptionsSelectChanged(int options1, int options2, int options3) {

            }
        })
        .setTitleText(title)
                .setDividerColor(Color.BLACK)
                .setSubmitColor(Color.BLACK)
                .setCancelColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(16)
                .build();

        pvOptions.setPicker(list);//添加数据源
        pvOptions.show();
    }



    public interface ConditionInterfacd{
        void setIndex(int pos);
    }

    public static void selectorDate(Context mContext, boolean[] timeType,GetTimeInterface timeInterface){
        selectorDate(2000,2100,mContext,timeType,timeInterface);
    }
    /**
     * 时间选择器
     * @param mContext
     */
    public static void selectorDate(int startDateyy,int endDateyy,Context mContext, boolean[] timeType,GetTimeInterface timeInterface) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        //正确设置方式 原因：注意事项有说明
        startDate.set(startDateyy, 0, 1);
        endDate.set(endDateyy, 11, 31);
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                //Toast.makeText(MainActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                timeInterface.getTime(date);
            }
        })
                .setType(timeType)// 默认全部显示 new boolean[]{true, true, true, false, false, false};
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
//                .setTitleSize(20)//标题文字大小
                .setTitleText("请选时间")//标题文字
//                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
//                .setTitleColor(Color.BLACK)//标题文字颜色
//                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
//                .setCancelColor(Color.BLUE)//取消按钮文字颜色
//                .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
                .setDate(Calendar.getInstance())// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("年", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
//                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                .isDialog(true)//是否显示为对话框样式
                .build();
        pvTime.show();
    }
    public interface GetTimeInterface{
        void getTime(Date time);
    }

}
