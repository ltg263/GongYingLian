package com.jxxx.gyl.view.activity.address;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.utils.AddressPickTask;
import com.jxxx.gyl.utils.IntentUtils;
import com.jxxx.gyl.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ActivityAddressEdit extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_address_dw)
    TextView tvAddressDw;
    @BindView(R.id.tv_address_ktwz)
    TextView tvAddressKtwz;
    @BindView(R.id.et_detailaddress)
    EditText etDetailaddress;
    @BindView(R.id.iv_szmr)
    ImageView iv_szmr;
    AddressData addressData;
    private int placeId = 0;
    private int flag = 1;
//    public static PoiInfo NEW_CURRENT_ADDRESS = null;

    @Override
    public int intiLayout() {
        return R.layout.activity_address_edit;
    }

    @Override
    public void initView() {
        if (getIntent().getBundleExtra("address") != null) {
            setToolbar(myToolbar, "修改地址");
            flag = 2;
            addressData = (AddressData) getIntent().getBundleExtra("address").getSerializable("address");
            etName.setText(addressData.getAcceptName());
            etPhone.setText("" + addressData.getMobile());
            Object[] str = null;
            if(addressData.getLocation().contains(addressData.getRegions()+" ")){
                str = StringUtil.deleteSubString(addressData.getLocation(), addressData.getRegions() + " ");
            }
            String newDz = "";
            String xxdz = "";
            if(str !=null && !TextUtils.isEmpty(str[0]+"")){
                if((str[0]+"").contains("-")){
                    newDz = str[0]+"".substring(0,(str[0]+"").indexOf("-"));
                    xxdz = str[0]+"".substring(newDz.length()+1, (str[0]+"").length());
                }else{
                    newDz = str[0]+"";
                }
                tvAddressDw.setText(newDz);
            }else{
                if((addressData.getLocation()).contains("-")){
                    newDz = addressData.getLocation().substring(0,addressData.getLocation().indexOf("-"));

                    xxdz = addressData.getLocation().substring(newDz.length()+1, addressData.getLocation().length());
                }else{
                    newDz = addressData.getLocation();
                }
                tvAddressDw.setText(newDz);
            }

            tvAddressKtwz.setText(addressData.getPlace());
            tvAddress.setText("" + addressData.getRegions());
            etDetailaddress.setText(xxdz);
        } else {
            flag = 1;
            addressData = new AddressData();
            setToolbar(myToolbar, "新增地址");
        }
    }

    @Override
    public void initData() {

    }


    public static void startActivity(Context mContext, Bundle mBundle) {
        IntentUtils.getInstence().intent(mContext, ActivityAddressEdit.class,"address",mBundle);
    }
    public void onAddressPicker() {
        AddressPickTask task = new AddressPickTask(this);
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
                    tvAddress.setText(province.getAreaName() +","+ city.getAreaName());
                    addressData.setRegions(province.getAreaName() +","+ city.getAreaName());
                    addressData.setProvinceId(province.getAreaId());
                    addressData.setCityId(city.getAreaId());

                } else {
                    tvAddress.setText(province.getAreaName() +","+ city.getAreaName() +","+ county.getAreaName());
                    addressData.setRegions(province.getAreaName() +","+ city.getAreaName() +","+ county.getAreaName());
                    addressData.setProvinceId(province.getAreaId());
                    addressData.setCityId(city.getAreaId());
                    addressData.setDistrictId(county.getAreaId());
                }
            }
        });
        task.execute("北京", "北京", "北京");
    }


    @OnClick({R.id.btn_save,R.id.tv_address,R.id.iv_szmr,R.id.tv_address_dw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_address:
                onAddressPicker();
                break;
            case R.id.tv_address_dw:
//                IntentUtils.getInstence().intent(this, AddressByMapActivity.class);
                break;
            case R.id.iv_szmr:
                if(iv_szmr.isSelected()){
                    iv_szmr.setSelected(false);
                }else{
                    iv_szmr.setSelected(true);
                }
                break;
            case R.id.btn_save:
                String consigneeName = etName.getText().toString();
                if (consigneeName == null) {
                    ToastUtils.showShort( "请填写收货人姓名");
                    return;
                }
                addressData.setAcceptName(consigneeName);
                String ktwz = tvAddressKtwz.getText().toString();
                if (ktwz == null || placeId == 0) {
                    ToastUtils.showShort(  "请选择开通位置");
                    return;
                }
                addressData.setPlaceId(placeId);
                addressData.setPlace(ktwz);
                String phone = etPhone.getText().toString();
                if (phone == null) {
                    ToastUtils.showShort(  "请填写收货人手机号");
                    return;
                }
                if (phone.trim().length() < 11) {
                    ToastUtils.showShort(  "请填写11位手机号");
                    return;
                }
                addressData.setMobile(phone);
                if (addressData.getRegions() == null) {
                    ToastUtils.showShort( "请选择城市");
                    return;
                }
                String address = tvAddressDw.getText().toString();
                if (address == null) {
                    ToastUtils.showShort( "请填写详细收货地址");
                    return;
                }
                addressData.setLocation(address+"-"+etDetailaddress.getText().toString());
//                show();
                if(flag==1){
                    getAddAddress(addressData);
                }else {
                    getUpdateAddress(addressData);
                }
                break;
            default:
        }
    }

    /**
     * 添加地址
     * {
     *   "acceptName": "string",
     *   "cityId": 0,
     *   "default": true,
     *   "districtId": 0,
     *   "lat": 0,
     *   "lng": 0,
     *   "location": "string",
     *   "mobile": "string",
     *   "place": "string",
     *   "placeId": 0,
     *   "provinceId": 0,
     *   "regions": "string",
     *   "streetId": 0
     * }
     */
    private void getAddAddress(AddressData addressData) {
        addressData.setId(null);
        Log.w("-->>","addressData："+addressData.toString());
//        RetrofitUtil.getInstance().mApiService()
//                .getAddAddress(addressData).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<BaseResult>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(BaseResult result) {
//                        if(result.getCode().equals("000000")){
//                            ToastUtils.showShort("添加成功");
//                            finish();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
////                        dismiss();
//                    }
//
//                    @Override
//                    public void onComplete() {
////                        dismiss();
//                    }
//                });

    }
    /**
     * 更新地址
     */
    private void getUpdateAddress(AddressData addressData) {
//        RetrofitUtil.getInstance().apiService()
//                .getUpdateAddress(addressData).observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<BaseResult>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(BaseResult result) {
//                        if(result.getCode().equals("000000")){
//                            ToastUtils.showShort("修改成功");
//                            finish();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
////                        dismiss();
//                    }
//
//                    @Override
//                    public void onComplete() {
////                        dismiss();
//                    }
//                });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if(NEW_CURRENT_ADDRESS!=null){
//            tvAddressDw.setText(NEW_CURRENT_ADDRESS.getName());
//            addressData.setLocation(NEW_CURRENT_ADDRESS.getName());
//            addressData.setLng(NEW_CURRENT_ADDRESS.getLocation().latitude);
//            addressData.setLat(NEW_CURRENT_ADDRESS.getLocation().longitude);
//            NEW_CURRENT_ADDRESS = null;
//        }
    }
}
