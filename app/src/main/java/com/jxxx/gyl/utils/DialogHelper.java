package com.jxxx.gyl.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import androidx.appcompat.app.AlertDialog;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.PermissionUtils;

/**
 * Created by ShiXL on 2018/2/9.
 */

public class DialogHelper {

    public static void showRationaleDialog(final PermissionUtils.OnRationaleListener.ShouldRequest shouldRequest) {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) return;
        new AlertDialog.Builder(topActivity)
                .setTitle(android.R.string.dialog_alert_title)
                .setMessage("请授权此权限，否则无法正常使用功能")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        shouldRequest.again(true);
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        shouldRequest.again(false);
                    }
                })
                .setCancelable(false)
                .create()
                .show();

    }

    public static void showOpenAppSettingDialog() {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) return;
        new AlertDialog.Builder(topActivity)
                .setTitle(android.R.string.dialog_alert_title)
                .setMessage("前往系统设置打开APP权限")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PermissionUtils.launchAppDetailsSettings();
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }


    public interface UploadFileInterface{
        void succeed(String path);
        void failure();
    }
    public static void getVersionUpdating(Activity mContext,UploadFileInterface fileInterface) {
//        RetrofitManager.build().getVersionUpdating(1)
//                .compose(RxSchedulers.compose())
//                .as(RxSchedulers.bindLifecycle((LifecycleOwner) mContext))
//                .subscribe(new BaseObserver<VersionBean>() {
//                    @Override
//                    public void onHandleSuccess(BaseData<VersionBean> t){
//                        goUpdating(mContext,t.getData(),fileInterface);
//                    }
//                });
    }

//    public static void goUpdating(Context mContext, VersionBean data, UploadFileInterface fileInterface) {
//        if(data.getVersion().equals(getVersionName(mContext))){
//            fileInterface.failure();
//            return;
//        }
//        UpdateAppUtils.init(mContext);
//        UpdateConfig updateConfig = new UpdateConfig();
//        updateConfig.setCheckWifi(true);
//        updateConfig.setNeedCheckMd5(false);
//        updateConfig.setNotifyImgRes(R.mipmap.ic_app);
//        UiConfig uiConfig = new UiConfig();
//        uiConfig.setUiType(UiType.PLENTIFUL);
//        uiConfig.setUpdateLogoImgRes(R.mipmap.ic_app);
//        uiConfig.setUpdateBtnBgRes(R.drawable.btn_shape_theme);
//        UpdateAppUtils
//                .getInstance()
//                .apkUrl(data.getFileUrl())
//                .updateTitle("发现新版本:V"+data.getVersion())
//                .updateContent("更新内容:"+data.getContent())
//                .uiConfig(uiConfig)
//                .updateConfig(updateConfig)
//                .setMd5CheckResultListener(new Md5CheckResultListener() {
//                    @Override
//                    public void onResult(boolean result) {
//
//                    }
//                })
//                .setUpdateDownloadListener(new UpdateDownloadListener() {
//                    @Override
//                    public void onError(Throwable throwable) {
//
//                    }
//
//                    @Override
//                    public void onStart() {
//
//                    }
//
//                    @Override
//                    public void onDownload(int progress) {
//
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                    }
//
//                })
//                .update();
//    }

    /**
     * 获取版本名称
     *
     * @param context 上下文
     *
     * @return 版本名称
     */
    public static String getVersionName(Context context) {

        //获取包管理器
        PackageManager pm = context.getPackageManager();
        //获取包信息
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            //返回版本号
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

}
