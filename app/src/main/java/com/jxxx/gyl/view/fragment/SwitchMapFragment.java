package com.jxxx.gyl.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.services.core.PoiItem;
import com.blankj.utilcode.util.AppUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jxxx.gyl.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Create by Sxl on 2021/1/26.
 */
public class SwitchMapFragment extends BottomSheetDialogFragment {

    PoiItem poiItem;
    Intent naviIntent;
    @BindView(R.id.gaodeTv)
    TextView gaodeTv;
    @BindView(R.id.baiduTv)
    TextView baiduTv;
    @BindView(R.id.txTv)
    TextView txTv;

    private Context context;
    Unbinder unbinder;

    public SwitchMapFragment() {
        // Required empty public constructor
    }

    public static SwitchMapFragment newInstance(PoiItem poiItem) {

        Bundle args = new Bundle();
        args.putParcelable("poiItem", poiItem);
        SwitchMapFragment fragment = new SwitchMapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != getArguments()) {
            poiItem = getArguments().getParcelable("poiItem");
        }
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_switch_map, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!AppUtils.isAppInstalled("com.autonavi.minimap"))
            gaodeTv.setVisibility(View.GONE);
        if (!AppUtils.isAppInstalled("com.baidu.BaiduMap"))
            baiduTv.setVisibility(View.GONE);
        if (!AppUtils.isAppInstalled("com.tencent.map"))
            txTv.setVisibility(View.GONE);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = new BottomSheetDialog(getContext(), R.style.translucent);
//        dialog.setCancelable(false);
//        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.gaodeTv, R.id.baiduTv, R.id.txTv, R.id.cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gaodeTv:
                //                Toast.makeText(this, AppUtils.isInstallApp("com.autonavi.minimap") ? "高德已安装" : "高德未安装", Toast.LENGTH_SHORT).show();
                if (AppUtils.isAppInstalled("com.autonavi.minimap")) {
                    naviIntent = new Intent("android.intent.action.VIEW", Uri.parse("androidamap://route?sourceApplication=appName&slat=&slon=&sname=我的位置&dlat=" +
                            poiItem.getLatLonPoint().getLatitude() + "&dlon=" + poiItem.getLatLonPoint().getLongitude() + "&dname="+poiItem.getPoiId()+"&dev=0&t=2"));
                    context.startActivity(naviIntent);
                } else Toast.makeText(context, "高德地图未安装", Toast.LENGTH_SHORT).show();
                break;
            case R.id.baiduTv:
                if (AppUtils.isAppInstalled("com.baidu.BaiduMap")) {
                    double[] bd_lat_lon = gaoDeToBaidu(poiItem.getLatLonPoint().getLongitude(), poiItem.getLatLonPoint().getLatitude());
                    naviIntent = new Intent("android.intent.action.VIEW", Uri.parse("baidumap://map/geocoder?location=" + bd_lat_lon[1] + "," + bd_lat_lon[0]));
                    context.startActivity(naviIntent);
                } else Toast.makeText(context, "百度地图未安装", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txTv:
                if (AppUtils.isAppInstalled("com.tencent.map")) {
                    naviIntent = new Intent("android.intent.action.VIEW", Uri.parse("qqmap://map/routeplan?type=drive&from=&fromcoord=&to=&tocoord=" + poiItem.getLatLonPoint().getLatitude() + "," + poiItem.getLatLonPoint().getLongitude() + "&policy=0&referer=appName"));
                    context.startActivity(naviIntent);
                } else Toast.makeText(context, "腾讯地图未安装", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel:
                this.dismiss();
                break;
        }
    }

    private double[] gaoDeToBaidu(double gd_lon, double gd_lat) {
        double[] bd_lat_lon = new double[2];
        double PI = 3.14159265358979324 * 3000.0 / 180.0;
        double x = gd_lon, y = gd_lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * PI);
        bd_lat_lon[0] = z * Math.cos(theta) + 0.0065;
        bd_lat_lon[1] = z * Math.sin(theta) + 0.006;
        return bd_lat_lon;
    }

}