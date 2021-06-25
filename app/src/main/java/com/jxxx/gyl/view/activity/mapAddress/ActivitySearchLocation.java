package com.jxxx.gyl.view.activity.mapAddress;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.widget.Toolbar;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.blankj.utilcode.util.ActivityUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ActivitySearchLocation extends BaseActivity implements AMap.OnCameraChangeListener{

    @BindView(R.id.include)
    Toolbar myToolbar;
    @BindView(R.id.map)
    MapView mMapView;
    @BindView(R.id.addressEdit)
    AutoCompleteTextView addressEdit;

    private AMap aMap;
    private AMapLocationClient locationClient;
    Marker marker;
    String addressXq;

    @Override
    public int intiLayout() {
        return R.layout.activity_search_location;
    }

    @Override
    protected void onTitleRightClickListener() {
        super.onTitleRightClickListener();
        ActivityUtils.startActivityForResult(this, ActivityLocationAddress.class,3);
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "选择地址","历史记录");
        aMap = mMapView.getMap();
        final LatLng latLng = new LatLng(29.8877248806424, 121.523712565104);

        GeoCoderUtil.getInstance(ActivitySearchLocation.this).geoAddress(new LatLngEntity(latLng.latitude, latLng.longitude), new GeoCoderUtil.GeoCoderAddressListener() {
            @Override
            public void onAddressResult(String result) {
                marker = aMap.addMarker(new MarkerOptions().position(latLng).snippet(result));
                marker.showInfoWindow();

                addressEdit.setText(result);
            }
        });
        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));

        addressEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 0) {
                    return;
                }else {
                    //高德地图的输入的自动提示，代码在后面
                    InputTipTask.getInstance(ActivitySearchLocation.this).setAdapter(addressEdit).searchTips(s.toString().trim(), "");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        addressEdit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<LocationBean> dataLists = InputTipTask.getInstance(ActivitySearchLocation.this).getBean();
                String address = dataLists.get(position).getContent();
                addressEdit.setText(dataLists.get(position).getContent());
                marker.destroy();
                marker = aMap.addMarker(new MarkerOptions().position(new LatLng(dataLists.get(position).getLat(),dataLists.get(position).getLon())).title(address));
                marker.showInfoWindow();

                aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(dataLists.get(position).getLat(),dataLists.get(position).getLon()), 16));
                addressXq = dataLists.get(position).getTitle();
//                ToastUtils.showShort(addressXq);
            }
        });

        aMap.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(final LatLng latLng) {
                marker.destroy();
                GeoCoderUtil.getInstance(ActivitySearchLocation.this).geoAddress(new LatLngEntity(latLng.latitude, latLng.longitude), new GeoCoderUtil.GeoCoderAddressListener() {
                    @Override
                    public void onAddressResult(String result) {
                        marker = aMap.addMarker(new MarkerOptions().position(latLng).snippet(result));
                        marker.showInfoWindow();

                        addressEdit.setText(result);
                    }
                });
                aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
            }
        });

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.confirm, R.id.cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.confirm:
                Intent intent = new Intent();
                intent.putExtra("address",addressEdit.getText().toString());
                intent.putExtra("lat",marker.getPosition());
                intent.putExtra("addressXq",addressXq);
                setResult(1,intent);
                finish();
                break;
            case R.id.cancel:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapView.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {

    }

    @Override
    public void onCameraChangeFinish(final CameraPosition cameraPosition) {
        LatLngEntity latLngEntity = new LatLngEntity(cameraPosition.target.latitude, cameraPosition.target.longitude);
        //地理反编码工具类，代码在后面
        GeoCoderUtil.getInstance(ActivitySearchLocation.this).geoAddress(latLngEntity, new GeoCoderUtil.GeoCoderAddressListener() {
            @Override
            public void onAddressResult(String result) {
                if(!addressEdit.getText().toString().trim().equals("")){
                    //输入地址后的点击搜索
//                    tvAddressDesc.setText(autotext.getText().toString().trim());
                    LatLng latLng = new LatLng(cameraPosition.target.latitude,cameraPosition.target.longitude);
                    marker.destroy();
                    marker = aMap.addMarker(new MarkerOptions().position(latLng).snippet(result));
                    marker.showInfoWindow();

                    aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
                }else{
                    //拖动地图
//                    tvAddressDesc.setText(result);
//                    currentLoc = new LocationBean(cameraPosition.target.longitude,cameraPosition.target.latitude,result,"");
                }
                //地图的中心点位置改变后都开始poi的附近搜索
//                PoiSearchTask.getInstance(SearchLocationActivity.this).setAdapter(poiAdapter).onSearch("", "",cameraPosition.target.latitude,cameraPosition.target.longitude);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if (resultCode == 1) {
           Intent intent = new Intent();
           intent.putExtra("address",data.getStringExtra("address"));
           intent.putExtra("lat", (LatLng) data.getParcelableExtra("lat"));
           intent.putExtra("addressXq",data.getStringExtra("addressXq"));
           setResult(1,intent);
           finish();
        }

    }
}
