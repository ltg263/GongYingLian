package com.jxxx.gyl.app;

/**
 * Created by Administrator on 2017/9/1.
 */

public class ConstValues {
    public static final String BASE_STR = "base_put";
    public static String SHOW_MAIN_FRAGMENT = "show_main_fragment";
    /**
     * 应用名称
     */
    public static String APPNAME_ENGLISH = "GongYingLian";
    public static String CATEGORY = "";

    /**sharedpreference 判断是否已登录字段*/
    public static boolean ISLOGIN = false;
    public static final String USERID = "user_id";
    public static final String[] ORDER_CANCEL = {"取消订单原因1","取消订单原因2","取消订单原因3","取消订单原因4"};
    public static final String[] HOME_TYPE_NAME_TJ = {"精选","推荐促销","丰盛午餐","红叶上新"};

    public static final String endpoint = "endpoint";
    public static final String host = "host";
    public static final String TOKENID = "tokenid";

    /**
     * 服务器后台地址
     */
    public static final String BASE_URL = "http://47.114.152.36:8000/";

//    public static final String PORT_21 = "community-service/";//社群

    //默认连接超时时间
    public static final int DEFAULT_TIMEOUT =60;
    public static final int PAGE_SIZE =10;
}
