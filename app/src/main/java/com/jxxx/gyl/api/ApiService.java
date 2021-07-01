package com.jxxx.gyl.api;


import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.CommodityCategory;
import com.jxxx.gyl.bean.LoginData;
import com.jxxx.gyl.bean.LoginRequest;
import com.jxxx.gyl.bean.ParamData;
import com.jxxx.gyl.bean.RechargeAllBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET(ConstValues.BASE_URL + "api/v1/circle/task/query")
    Observable<Result> getTaskCircleQuery();

    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/authentication/pwdLogin")
    Observable<Result<LoginData>> pwdLogin(@Body LoginRequest request);

    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/authentication/smsLogin")
    Observable<Result<LoginData>> smsLogin(@Body LoginRequest request);

    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/global/sendSms")
    Observable<Result> sendSms(@Body LoginRequest request);

    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/register/sms")
    Observable<Result<LoginData>> smsRegister(@Body LoginRequest request);

    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/findPwd/sms")
    Observable<Result> smsFindPwd(@Body LoginRequest request);

    @GET(ConstValues.BASE_URL + "api/scmp-application-mall/product/listCategoryTop")
    Observable<Result<List<CommodityCategory.ListBean>>> getCategoryListAll();


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
