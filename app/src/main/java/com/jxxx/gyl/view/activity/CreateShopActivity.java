package com.jxxx.gyl.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.CategoryTreeData;
import com.jxxx.gyl.bean.LoginRequest;
import com.jxxx.gyl.bean.PostAuditSubmitCommand;
import com.jxxx.gyl.utils.AddressPickTask;
import com.jxxx.gyl.utils.PickerViewUtils;
import com.jxxx.gyl.utils.StringUtil;
import com.jxxx.gyl.utils.ToastUtil;
import com.jxxx.gyl.view.activity.login.LoginActivity;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;
import cn.addapp.pickers.picker.AddressPicker;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CreateShopActivity extends BaseActivity {
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.et_storefrontName)
    EditText mEtStorefrontName;
    @BindView(R.id.et_subbranchName)
    EditText mEtSubbranchName;
    @BindView(R.id.tv_businessCategoryId)
    TextView mTvBusinessCategoryId;
    @BindView(R.id.tv_storefrontAddress)
    TextView mTvStorefrontAddress;
    @BindView(R.id.et_storefrontDetailedAddress)
    EditText mEtStorefrontDetailedAddress;
    @BindView(R.id.et_realName)
    EditText mEtRealName;
    @BindView(R.id.tv_businessStatus)
    TextView mTvBusinessStatus;
    @BindView(R.id.banner_storefrontImageUrl)
    Banner mBannerStorefrontImageUrl;
    @BindView(R.id.et_invitationCode)
    EditText mEtInvitationCode;
    @BindView(R.id.tv_register)
    TextView mTvRegister;

    List<String> lists = new ArrayList<>();

    private List<CategoryTreeData.CategoryListBean> mCategoryList;
    private List<List<CategoryTreeData.CategoryListBean.ChildrenBean>> mCategoryListLists;

    @Override
    public int intiLayout() {
        return R.layout.activity_create_shop;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "创建门店信息");
    }

    @Override
    public void initData() {
        businessCategoryTree();
    }

    @OnClick({R.id.tv_businessCategoryId, R.id.tv_storefrontAddress, R.id.tv_businessStatus, R.id.tv_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_businessCategoryId:
                if (mCategoryList != null && mCategoryList.size() > 0) {
                    pvOptions.show();
                }
                break;
            case R.id.tv_storefrontAddress:
                onAddressPicker();
                break;
            case R.id.tv_businessStatus:
                lists.clear();
                lists.add("正在营业");
                lists.add("尚未营业");
                PickerViewUtils.selectorCustom(this, lists, "", mTvBusinessStatus);
                break;
            case R.id.tv_register:
                postAuditSubmit();
                break;
        }
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
                    mTvStorefrontAddress.setText(province.getAreaName() + "," + city.getAreaName());
                } else {
                    mTvStorefrontAddress.setText(province.getAreaName() + "," + city.getAreaName() + "," + county.getAreaName());
                }
            }
        });
        task.execute("北京", "北京", "北京");
    }

    private void businessCategoryTree() {
        RetrofitUtil.getInstance().apiService()
                .businessCategoryTree()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<CategoryTreeData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<CategoryTreeData> result) {
                        hideLoading();
                        if (isResultOk(result)) {
                            mCategoryList = result.getData().getCategoryList();
                            mCategoryListLists = new ArrayList<>();
                            for (int i = 0; i < mCategoryList.size(); i++) {
                                mCategoryListLists.add(mCategoryList.get(i).getChildren());
                            }
                            showPicker();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }

    private OptionsPickerView pvOptions;

    private void showPicker() {

        pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                if(mCategoryList.get(options1)!=null && StringUtil.isNotBlank(mCategoryList.get(options1).getCategoryName())
                        && mCategoryListLists.get(options1)!=null
                        && mCategoryListLists.get(options1).size()> options2
                        && mCategoryListLists.get(options1).get(options2)!=null
                        && StringUtil.isNotBlank(mCategoryListLists.get(options1).get(options2).getCategoryName())){
                    mTvBusinessCategoryId.setText(mCategoryList.get(options1).getCategoryName()+"-"+mCategoryListLists.get(options1).get(options2).getCategoryName());
                    return;
                }
                if(mCategoryList.get(options1)!=null && StringUtil.isNotBlank(mCategoryList.get(options1).getCategoryName())){
                    mTvBusinessCategoryId.setText(mCategoryList.get(options1).getCategoryName());
                    return;
                }
            }
        }).setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
                    @Override
                    public void onOptionsSelectChanged(int options1, int options2, int options3) {
                    }
                })
//                .setSubmitText("确定")//确定按钮文字
//                .setCancelText("取消")//取消按钮文字
                .setTitleText("商家类目")//标题
                .setDividerColor(Color.BLACK)
                .setSubmitColor(Color.BLACK)
                .setCancelColor(Color.BLACK)
                .setTextColorCenter(getResources().getColor(R.color.color_blue_theme)) //设置选中项文字颜色
                .setContentTextSize(16)
                .build();
        pvOptions.setPicker(mCategoryList, mCategoryListLists);//添加数据源

    }

    private void postAuditSubmit() {
//        String account = etAccount.getText().toString();
//        String verify = etVerify.getText().toString();
//        String pass = etPass.getText().toString();
//        if (StringUtil.isBlank(account) || StringUtil.isBlank(verify)|| StringUtil.isBlank(pass)) {
//            ToastUtil.showLongStrToast(this, "请输入完整信息");
//            return;
//        }
        PostAuditSubmitCommand bean = new PostAuditSubmitCommand();
        RetrofitUtil.getInstance().apiService()
                .postAuditSubmit(bean)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result result) {
                        hideLoading();
                        if (isResultOk(result)) {
                            ToastUtils.showLong("注册成功");
                            baseStartActivity(LoginActivity.class, null);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }
}
