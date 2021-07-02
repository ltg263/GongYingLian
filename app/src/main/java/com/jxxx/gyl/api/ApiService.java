package com.jxxx.gyl.api;


import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.CommodityCategory;
import com.jxxx.gyl.base.HomeCategoryTypeData;
import com.jxxx.gyl.base.ShopInfoData;
import com.jxxx.gyl.base.ShopInfoListData;
import com.jxxx.gyl.bean.CategoryDataList;
import com.jxxx.gyl.bean.HomeActivityData;
import com.jxxx.gyl.bean.HomeBannerData;
import com.jxxx.gyl.bean.HomeCategoryData;
import com.jxxx.gyl.bean.LoginData;
import com.jxxx.gyl.bean.LoginRequest;
import com.jxxx.gyl.bean.ParamData;
import com.jxxx.gyl.bean.RechargeAllBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {

    /**
     * 全局-发送短信验证码
     * @param request
     * @return
     */
    @POST(ConstValues.BASE_URL + "api/scmp-application-mall/global/sendSms")
    Observable<Result> sendSms(@Body LoginRequest request);

    /**
     * 登录页-手机密码登录接口
     * @param request
     * @return
     */
    @POST(ConstValues.BASE_URL + "api/scmp-application-mall/authentication/pwdLogin")
    Observable<Result<LoginData>> pwdLogin(@Body LoginRequest request);

    /**
     * 登录页-手机短验登录接口
     * @param request
     * @return
     */
    @POST(ConstValues.BASE_URL + "api/scmp-application-mall/authentication/smsLogin")
    Observable<Result<LoginData>> smsLogin(@Body LoginRequest request);

    /**
     * 注册页-手机短验注册接口
     * @param request
     * @return
     */
    @POST(ConstValues.BASE_URL + "api/scmp-application-mall/register/sms")
    Observable<Result<LoginData>> smsRegister(@Body LoginRequest request);

    /**
     * 登录页-手机短验找回密码接口
     * @param request
     * @return
     */
    @POST(ConstValues.BASE_URL + "api/scmp-application-mall/findPwd/sms")
    Observable<Result> smsFindPwd(@Body LoginRequest request);

    /**
     * 设置页-登出
     * @return
     */
    @POST(ConstValues.BASE_URL + "api/scmp-application-mall/authentication/logout")
    Observable<Result> logout();

    /**
     * 主页-banner列表
     * @return
     */
    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/content/banner")
    Observable<Result<List<HomeBannerData>>> homeBanner();

    /**
     * 首页-分类列表
     * @return
     */
    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/product/listCategoryTop")
    Observable<Result<List<HomeCategoryData>>> homeListCategoryTop();

    /**
     * 首页-活动分类列表
     * @return
     */
    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/activity/listCategory")
    Observable<Result<List<CategoryDataList>>> listCategory();

    /**
     * 分类页-商品列表
     * @return
     */
    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/product/listProductByCategory")
    Observable<Result<HomeCategoryTypeData>> listProductByCategory(@Query("categoryId") String categoryId);

    /**
     * 首页-活动列表
     * @return
     */
    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/activity/list/1")
    Observable<Result<List<HomeActivityData>>> homeActivityList();
    /**
     * 商品-详情
     * @return
     */
    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/product/detail")
    Observable<Result<ShopInfoListData>> productDetail(@Query("id") String id);

    /**
     * 全局-商品搜索
     * @return
     */
    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/product/search")
    Observable<Result<List<ShopInfoData>>> productSearch(@Query("keyword") String keyword);

    /**
     * 商品页-分类列表
     * @return
     */
    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/product/listCategoryAll")
    Observable<Result<List<CommodityCategory>>> getCategoryListAll();



    /**
     * 创建充值订单
     */
    @POST("user/api/v1/user/order/recharge/create")
    Observable<Result<ParamData>> userRechargeOrder(@Query("rechargeId") String rechargeId);
    /**
     * 设置默认地址
     *
     * @return
     */

    @GET("backstage/api/v1/wallet/recharge/all")
    Observable<Result<RechargeAllBean>> backstageRechargeAll();

}
