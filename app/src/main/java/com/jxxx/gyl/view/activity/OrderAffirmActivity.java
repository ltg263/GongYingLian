package com.jxxx.gyl.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.HttpsUtils;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.base.ShopInfoData;
import com.jxxx.gyl.bean.AddressModel;
import com.jxxx.gyl.bean.ChannelsListBean;
import com.jxxx.gyl.bean.CouponTemplateData;
import com.jxxx.gyl.bean.DedicatedReceiptInfoBean;
import com.jxxx.gyl.bean.OrderPreviewBean;
import com.jxxx.gyl.bean.PostOrderSubmit;
import com.jxxx.gyl.utils.PickerViewUtils;
import com.jxxx.gyl.utils.view.PopupWindowSkus;
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
    @BindView(R.id.tv_freightAmount)
    TextView tv_freightAmount;
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
    @BindView(R.id.tv_userRemark)
    TextView tv_userRemark;
    @BindView(R.id.tv_payChannel)
    TextView tv_payChannel;
    @BindView(R.id.tv_invoice)
    TextView tv_invoice;
    private OrderPreviewBean mData;
    private List<CouponTemplateData> recommendCoupon;
    OrderPreviewBean.PreviewOrderDTOBean previewOrderDTO;
    public String userCouponId,userCouponAmount,shippingAddressId,shippingAddressNameP,shippingAddress;
    String receiptType = "0";
    DedicatedReceiptInfoBean mDedicatedReceiptInfoBean;
    @Override
    public int intiLayout() {
        return R.layout.activity_order_affirm;
    }

    @Override
    public void initView() {
        setToolbar(mMyToolbar, "确认订单");
        mShopImageAdapter = new ShopImageAdapter(null);
        mRvShopList.setAdapter(mShopImageAdapter);
        tv_payChannel.setText(payChannel);
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
                            previewOrderDTO = mData.getPreviewOrderDTO();
                            tv_totalItemNum.setText("共"+previewOrderDTO.getTotalItemNum()+"件");
                            mShopImageAdapter.setNewData(previewOrderDTO.getOrderDetailList());
                            tv_deliveryTime.setText(previewOrderDTO.getDeliveryTime());
                            tv_totalAmount.setText("￥"+previewOrderDTO.getTotalAmount());
                            tv_freightAmount.setText("￥"+previewOrderDTO.getFreightAmount());
                            tv_payableAmount.setText("商品合计：￥"+previewOrderDTO.getPayableAmount());
                            tv_payAmount.setText(previewOrderDTO.getPayAmount());
                            OrderPreviewBean.DefaultShippingAddressBean defaultShippingAddress = mData.getDefaultShippingAddress();
                            if(defaultShippingAddress!=null){
                                tv_address.setText(defaultShippingAddress.getAddress()+"-"+defaultShippingAddress.getHouseNo());
                                tv_contact_phone.setText(defaultShippingAddress.getContact()+"      "+defaultShippingAddress.getPhone());
                                shippingAddressId = defaultShippingAddress.getId();
                            }
                            recommendCoupon = mData.getUserCouponList();
                            if(mData.getRecommendCoupon()!=null){
                                tv_coupon.setText("-"+mData.getRecommendCoupon().getCouponValue());
                                userCouponId = mData.getRecommendCoupon().getId();
                                userCouponAmount = mData.getRecommendCoupon().getCouponValue();
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
        HttpsUtils.payChannelsList("PURCHASE", new HttpsUtils.PayChannelsInterface() {
            @Override
            public void getPayChannelsResult(List<ChannelsListBean> result) {
                OrderAffirmActivity.this.result = result;
               for(int i=0;i<result.size();i++){
                   listPay.add(result.get(i).getChannelName());
                   tv_payChannel.setText(result.get(0).getChannelName());
                   payChannel = result.get(0).getChannelCode();
               }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_address.setText(shippingAddress);
        tv_contact_phone.setText(shippingAddressNameP);
    }
    List<ChannelsListBean> result;
    String payChannel = "无";
    List<String> listPay = new ArrayList<>();
    @OnClick({R.id.rl_address, R.id.tv_invoice,R.id.tv_coupon,R.id.bnt,R.id.tv_totalItemNum,R.id.tv_payChannel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_address:
                ActivityAddressList.startActivity(OrderAffirmActivity.this,2);
                break;
            case R.id.tv_invoice:
                Intent mIntentInvoice = new Intent(this,MineInvoiceActivity.class);
                mIntentInvoice.putExtra("type","OrderAffirmActivity");
                mIntentInvoice.putExtra("receiptAmount",previewOrderDTO.getPayAmount());
                mIntentInvoice.putExtra("receiptContent","食品");
                startActivityForResult(mIntentInvoice, 19);
                break;
            case R.id.tv_coupon:
                if(recommendCoupon!=null && recommendCoupon.size()>0){
                    Intent mIntent = new Intent(this,OrderCouponListActivity.class);
                    Log.w("recommendCoupon","recommendCoupon"+(ArrayList<? extends Parcelable>) recommendCoupon);
                    mIntent.putParcelableArrayListExtra("recommendCoupon", (ArrayList<? extends Parcelable>) recommendCoupon);
                    startActivityForResult(mIntent, 21);
                    return;
                }
                ToastUtils.showLong("暂无可用优惠券");
                break;
            case R.id.tv_payChannel:
                if(listPay.size()==0){
                    HttpsUtils.payChannelsList("PURCHASE", new HttpsUtils.PayChannelsInterface() {
                        @Override
                        public void getPayChannelsResult(List<ChannelsListBean> result) {
                            OrderAffirmActivity.this.result = result;
                            for(int i=0;i<result.size();i++){
                                listPay.add(result.get(i).getChannelName());
                            }
                            PickerViewUtils.selectorCustom(OrderAffirmActivity.this, listPay,
                                    "选择支付方式", new PickerViewUtils.ConditionInterfacd() {
                                        @Override
                                        public void setIndex(int pos) {
                                            tv_payChannel.setText(listPay.get(pos));
                                            payChannel = result.get(pos).getChannelCode();
                                        }
                                    });
                        }
                    });
                    return;
                }
                PickerViewUtils.selectorCustom(this, listPay,
                        "选择支付方式", new PickerViewUtils.ConditionInterfacd() {
                    @Override
                    public void setIndex(int pos) {
                        tv_payChannel.setText(listPay.get(pos));
                        payChannel = result.get(pos).getChannelCode();
                    }
                });
                break;
            case R.id.tv_totalItemNum:
                popupWindw();
                break;
            case R.id.bnt:
                PostOrderSubmit mPostOrderSubmit = new PostOrderSubmit();
                if(payChannel.equals("无")){
                    ToastUtils.showLong("请选择支付方式");
                    return;
                }
                mPostOrderSubmit.setInnerOrderNo(previewOrderDTO.getInnerOrderNo());
                mPostOrderSubmit.setPayChannel(payChannel);
                mPostOrderSubmit.setShippingAddressId(shippingAddressId);
                mPostOrderSubmit.setUserCouponId(userCouponId);
                mPostOrderSubmit.setUserRemark(tv_userRemark.getText().toString());
                if(receiptType.equals("1") && mDedicatedReceiptInfoBean!=null){
                    mDedicatedReceiptInfoBean.setReceiptAmount(tv_payAmount.getText().toString());
                    mPostOrderSubmit.setGeneralReceiptInfo(mDedicatedReceiptInfoBean);
                }else if(receiptType.equals("2") && mDedicatedReceiptInfoBean!=null){
                    mDedicatedReceiptInfoBean.setReceiptAmount(tv_payAmount.getText().toString());
                    mPostOrderSubmit.setDedicatedReceiptInfo(mDedicatedReceiptInfoBean);
                }
                mPostOrderSubmit.setReceiptType(receiptType);
                OrderPayActivity.startActivityPay(this,mPostOrderSubmit);
                break;
        }
    }
    PopupWindowSkus window;

    private void popupWindw() {
        window = new PopupWindowSkus(this, previewOrderDTO.getOrderDetailList(), new PopupWindowSkus.GiveDialogInterface() {
            @Override
            public void btnConfirm(OrderPreviewBean.PreviewOrderDTOBean.OrderDetailListBean bean) {
            }
        });
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        window.setOutsideTouchable(true);
        window.showAtLocation(tv_totalItemNum, Gravity.BOTTOM, 0, 0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            if (requestCode == 19) {
                receiptType = data.getStringExtra("receiptType");
                if(receiptType.equals("1")){
                    tv_invoice.setText("电子普通发票");
                }else if(receiptType.equals("2")){
                    tv_invoice.setText("专用发票");
                }
                mDedicatedReceiptInfoBean = (DedicatedReceiptInfoBean) data.getSerializableExtra("mDedicatedReceiptInfoBean");
            }
            if (requestCode == 20) {
                shippingAddressId = data.getStringExtra("shippingAddressId");
                shippingAddress = data.getStringExtra("shippingAddress");
                shippingAddressNameP = data.getStringExtra("shippingAddressNameP");
                tv_address.setText(shippingAddress);
                tv_contact_phone.setText(shippingAddressNameP);
            }
            if (requestCode == 21) {
                userCouponAmount = data.getStringExtra("userCouponAmount");
                userCouponId = data.getStringExtra("userCouponId");
                tv_coupon.setText("-"+userCouponAmount);
                double payAmount = Double.valueOf(previewOrderDTO.getPayableAmount())-Double.valueOf(userCouponAmount);
                tv_payAmount.setText(String.valueOf(payAmount));
            }
        }
    }
}
