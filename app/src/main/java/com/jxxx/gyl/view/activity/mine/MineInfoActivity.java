package com.jxxx.gyl.view.activity.mine;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.jxxx.gyl.R;
import com.jxxx.gyl.api.Result;
import com.jxxx.gyl.api.RetrofitUtil;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.bean.AccoutInfoBean;
import com.jxxx.gyl.bean.UserInfoUpdate;
import com.jxxx.gyl.utils.GlideImageLoader;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MineInfoActivity extends BaseActivity {

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;
    @BindView(R.id.head_icon)
    ImageView mHeadIcon;
    @BindView(R.id.tv_realName)
    TextView mTvRealName;
    @BindView(R.id.tv_storefrontName)
    TextView mTvStorefrontName;
    @BindView(R.id.tv_subbranchName)
    TextView mTvSubbranchName;

    @Override
    public int intiLayout() {
        return R.layout.activity_mine_info;
    }

    @Override
    public void initView() {
        setToolbar(myToolbar, "个人信息");
    }

    @Override
    public void initData() {
        RetrofitUtil.getInstance().apiService()
                .customerInfo().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Result<UserInfoUpdate>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<UserInfoUpdate> result) {
                        if (isResultOk(result)) {
                            UserInfoUpdate.BaseInfoBean baseInfo = result.getData().getBaseInfo();
                            GlideImageLoader.loadImageViewRadius(MineInfoActivity.this,baseInfo.getStorefrontImageUrl(),mHeadIcon);
                            mTvRealName.setText(baseInfo.getRealName());
                            mTvStorefrontName.setText(baseInfo.getStorefrontName());
                            mTvSubbranchName.setText(baseInfo.getSubbranchName());
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
}
