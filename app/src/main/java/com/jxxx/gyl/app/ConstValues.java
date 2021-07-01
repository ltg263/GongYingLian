package com.jxxx.gyl.app;

/**
 * Created by Administrator on 2017/9/1.
 */

public class ConstValues {
    public static final String BASE_STR = "base_put";
    /**
     * 应用名称
     */
    public static String APPNAME_ENGLISH = "GongYingLian";

    /**sharedpreference 判断是否已登录字段*/
    public static final String ISLOGIN = "islogin";
    public static final String USERID = "user_id";
    public static final String TOKEN = "token";
    public static final String[] HOME_TYPE_NAME = {"分类0","分类1","分类2","分类3","分类4","分类5","分类6","分类7","分类8","分类9"};
    public static final String[] HOME_TYPE_NAME_TJ = {"精选","推荐促销","丰盛午餐","红叶上新"};

    public static final String endpoint = "endpoint";
    public static final String host = "host";
    public static final String TOKENID = "tokenid";

    /**
     * 服务器后台地址
     */
    public static final String BASE_URL = "http://192.168.50.246:8000/";

//    public static final String PORT_21 = "community-service/";//社群

    //默认连接超时时间
    public static final int DEFAULT_TIMEOUT =60;
    public static final int PAGE_SIZE =10;
}
