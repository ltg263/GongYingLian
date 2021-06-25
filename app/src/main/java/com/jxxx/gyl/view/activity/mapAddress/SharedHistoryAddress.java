package com.jxxx.gyl.view.activity.mapAddress;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jxxx.gyl.app.MainApplication;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 作者： litongge
 * 时间： 2018/4/24 20:22
 * 邮箱；ltg263@126.com
 * 描述：SharedPreferences 的工具类
 */
public class SharedHistoryAddress {
    private static SharedHistoryAddress sharedUtils;
    public static String SHARED_PREFS_NAME = "SharedHistoryAddress";

    public static SharedHistoryAddress singleton() {
        if (sharedUtils == null) {
            sharedUtils = new SharedHistoryAddress(MainApplication.getContext(), SHARED_PREFS_NAME);
        }
        return sharedUtils;
    }

    private SharedPreferences mSharedPrefs;

    private SharedHistoryAddress(Context context, String sharedPrefsName) {
        mSharedPrefs = context.getSharedPreferences(sharedPrefsName, Context.MODE_PRIVATE);
    }

    public void putHistoryAddressData(List<HistoryAddressData> lists) {

        Editor editor = mSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(lists);
        editor.putString("str_address", json);
        editor.commit();
    }

    public List<HistoryAddressData> getHistoryAddressData() {
        Gson gson = new Gson();
        String json = mSharedPrefs.getString("str_address", null);
        Type type = new TypeToken<List<HistoryAddressData>>() {
        }.getType();
        List<HistoryAddressData> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

    public void clear() {
        Editor edit = mSharedPrefs.edit();
        edit.clear();
        edit.commit();
    }

    public void clear(String key) {
        Editor edit = mSharedPrefs.edit();
        edit.remove(key);
        edit.commit();
    }
}
