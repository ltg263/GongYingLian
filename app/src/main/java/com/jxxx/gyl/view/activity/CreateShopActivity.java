package com.jxxx.gyl.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.HttpsUtils;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.CategoryTreeData;
import com.jxxx.gyl.bean.LoginData;
import com.jxxx.gyl.bean.PostAuditSubmitCommand;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.utils.PickerViewUtils;
import com.jxxx.gyl.utils.PictureSelectorUtils;
import com.jxxx.gyl.utils.SharedUtils;
import com.jxxx.gyl.utils.StringUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
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
    @BindView(R.id.show_storefrontImageUrl)
    ImageView mShowStorefrontImageUrl;
    @BindView(R.id.rl_storefrontImageUrl)
    RelativeLayout mRlStorefrontImageUrl;
    @BindView(R.id.et_invitationCode)
    EditText mEtInvitationCode;
    @BindView(R.id.tv_register)
    TextView mTvRegister;

    List<String> lists = new ArrayList<>();

    private List<CategoryTreeData.CategoryListBean> mCategoryList;
    private List<List<CategoryTreeData.CategoryListBean.ChildrenBean>> mCategoryListLists;
    String businessCategoryId ;

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

    @OnClick({R.id.rl_storefrontImageUrl,R.id.show_storefrontImageUrl,R.id.tv_businessCategoryId, R.id.tv_storefrontAddress, R.id.tv_businessStatus, R.id.tv_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_storefrontImageUrl:
            case R.id.show_storefrontImageUrl:
                PictureSelectorUtils.selectImage(CreateShopActivity.this,1);
                break;
            case R.id.tv_businessCategoryId:
                if (pvOptions!=null && mCategoryList != null && mCategoryList.size() > 0) {
                    pvOptions.show();
                }
                break;
            case R.id.tv_storefrontAddress:
                PickerViewUtils.onAddressPicker(this,mTvStorefrontAddress);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    if(selectList!=null){
                        mRlStorefrontImageUrl.setVisibility(View.GONE);
                        mShowStorefrontImageUrl.setVisibility(View.VISIBLE);
                        GlideImageLoader.loadImageViewRadius(CreateShopActivity.this,
                                selectList.get(0).getCompressPath(),15,mShowStorefrontImageUrl);
                        HttpsUtils.uploadFiles(selectList.get(0).getCompressPath(), new HttpsUtils.UploadFileInterface() {
                            @Override
                            public void succeed(String path) {

                            }

                            @Override
                            public void failure() {

                            }
                        });
                    }
                    break;
                default:
            }
        }
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
                    businessCategoryId = mCategoryListLists.get(options1).get(options2).getId();
                    mTvBusinessCategoryId.setText(mCategoryList.get(options1).getCategoryName()+"-"+mCategoryListLists.get(options1).get(options2).getCategoryName());
                    return;
                }
                if(mCategoryList.get(options1)!=null && StringUtil.isNotBlank(mCategoryList.get(options1).getCategoryName())){
                    mTvBusinessCategoryId.setText(mCategoryList.get(options1).getCategoryName());
                    businessCategoryId = mCategoryList.get(options1).getId();
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
        PostAuditSubmitCommand bean = new PostAuditSubmitCommand();
        bean.setBusinessCategoryId(businessCategoryId);
        bean.setBusinessStatus(mTvBusinessStatus.getText().toString().equals("尚未营业")?"0":"1");
        bean.setInvitationCode(mEtInvitationCode.getText().toString());
        bean.setRealName(mEtRealName.getText().toString());
        bean.setStorefrontAddress(mTvStorefrontAddress.getText().toString());
        bean.setStorefrontDetailedAddress(mEtStorefrontDetailedAddress.getText().toString());
        bean.setStorefrontImageUrl("https://exp-picture.cdn.bcebos.com/d4071b96b814f4d09fec8166cdfe474ec3832347.jpg?x-bce-process=image%2Fresize%2Cm_lfit%2Cw_500%2Climit_1%2Fquality%2Cq_80");
        bean.setStorefrontName(mEtStorefrontName.getText().toString());
        bean.setSubbranchName(mEtSubbranchName.getText().toString());
        bean.setUserId(SharedUtils.getUserId());
        RetrofitUtil.getInstance().apiService()
                .postAuditSubmit(bean)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<LoginData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<LoginData> result) {
                        hideLoading();
                        if (isResultOk(result)) {
                            startActivityLoinOk(result.getData());
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


    private void startActivityLoinOk(LoginData mData) {
        if(mData.getAccessToken()!=null){
            SharedUtils.singleton().put(ConstValues.TOKENID,mData.getAccessToken().getAccessToken());
        }
        if(StringUtil.isNotBlank(mData.getUserId())){
            SharedUtils.singleton().put(ConstValues.USERID,mData.getUserId());
        }
        //0未提交 1审核通过 2审核失败 3审核中
        switch (mData.getAuditStatus()){
            case "0":
                baseStartActivity(CreateShopActivity.class,null);
                finish();
                break;
            case "1":
                ToastUtils.showShort("登录成功");
                finish();
                break;
            case "2":
                baseStartActivity(CreateShopResultActivity.class,mData.getFailureReason());
                finish();
                break;
            case "3":
                baseStartActivity(CreateShopResultActivity.class,null);
                finish();
                break;
        }
    }
}
