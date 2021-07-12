package com.jxxx.gyl.view.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.AddressModel;
import com.jxxx.gyl.bean.CouponTemplateData;
import com.jxxx.gyl.bean.OrderPreviewBean;
import com.jxxx.gyl.view.activity.address.ActivityAddressList;
import com.jxxx.gyl.view.adapter.ShopImageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderAffirmActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar mMyToolbar;
    @BindView(R.id.rv_shop_list)
    RecyclerView mRvShopList;
    ShopImageAdapter mShopImageAdapter;
    @BindView(R.id.rl_address)
    RelativeLayout mRlAddress;
    @BindView(R.id.bnt)
    TextView mBnt;
    @BindView(R.id.tv_totalItemNum)
    TextView tv_totalItemNum;
    @BindView(R.id.tv_deliveryTime)
    TextView tv_deliveryTime;
    @BindView(R.id.tv_totalAmount)
    TextView tv_totalAmount;
    @BindView(R.id.tv_payableAmount)
    TextView tv_payableAmount;
    @BindView(R.id.tv_payAmount)
    TextView tv_payAmount;
    @BindView(R.id.tv_address)
    TextView tv_address;
    @BindView(R.id.tv_coupon)
    TextView tv_coupon;
    @BindView(R.id.tv_contact_phone)
    TextView tv_contact_phone;
    private OrderPreviewBean mData;
    private List<CouponTemplateData> recommendCoupon;

    @Override
    public int intiLayout() {
        return R.layout.activity_order_affirm;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "确认订单");
        mShopImageAdapter = new ShopImageAdapter(null);
        mRvShopList.setAdapter(mShopImageAdapter);
    }

    @Override
    public void initData() {
        RetrofitUtil.getInstance().apiService()
                .getOrderPreview()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<OrderPreviewBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<OrderPreviewBean> result) {
                        if(isResultOk(result)) {
                            mData = result.getData();
                            OrderPreviewBean.PreviewOrderDTOBean previewOrderDTO = mData.getPreviewOrderDTO();
                            tv_totalItemNum.setText("共"+previewOrderDTO.getTotalItemNum()+"件");
                            mShopImageAdapter.setNewData(previewOrderDTO.getOrderDetailList());
                            tv_deliveryTime.setText(previewOrderDTO.getDeliveryTime());
                            tv_totalAmount.setText("￥"+previewOrderDTO.getTotalAmount());
                            tv_payableAmount.setText("商品合计：￥"+previewOrderDTO.getPayableAmount());
                            tv_payAmount.setText(previewOrderDTO.getPayAmount());
                            OrderPreviewBean.DefaultShippingAddressBean defaultShippingAddress = mData.getDefaultShippingAddress();
                            if(defaultShippingAddress!=null){
                                tv_address.setText(defaultShippingAddress.getAddress());
                                tv_contact_phone.setText(defaultShippingAddress.getContact()+"      "+defaultShippingAddress.getPhone());
                            }
                            recommendCoupon = mData.getUserCouponList();
                            if(mData.getRecommendCoupon()!=null){
                                tv_coupon.setText("-"+mData.getRecommendCoupon().getCouponValue());
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @OnClick({R.id.rl_address, R.id.tv_invoice,R.id.tv_coupon,R.id.bnt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_address:
                ActivityAddressList.startActivity(OrderAffirmActivity.this,2);
                break;
            case R.id.tv_invoice:
                baseStartActivity(MineInvoiceActivity.class,null);
                break;
            case R.id.tv_coupon:
                if(recommendCoupon!=null && recommendCoupon.size()>0){
                    Intent mIntent = new Intent(this,OrderCouponListActivity.class);
                    mIntent.putParcelableArrayListExtra("recommendCoupon", (ArrayList<? extends Parcelable>) recommendCoupon);
                    baseStartActivity(OrderCouponListActivity.class,null);
                    return;
                }
                ToastUtils.showLong("暂无可用优惠券");
                break;
            case R.id.bnt:
                baseStartActivity(OrderPayActivity.class,null);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20) {
            if (resultCode == 1) {
//                addressData = (AddressData) data.getSerializableExtra("address");
//                if (addressData == null) {
//                    tvAddress.setText("请选择收货地址");
//                } else {
//                    mTvAddressNameAndName.setText(addressData.getAcceptName()+"   "+addressData.getMobile());
//                    tvAddress.setVisibility(View.VISIBLE);
//                    tvAddress.setText(addressData.getRegions() + addressData.getLocation());
//                }
            }
        }

    }
}
