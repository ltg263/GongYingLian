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
    public static final String[] ORDER_CANCEL = {"拍多了，拍错了","商家营业，但不接待","商家关店、装修、转让","联系不上商家，或实地地址无此店"};
    public static final String[] ORDER_REFUND = {"买多了，买错了","商家营业，但不接待","商家关店、装修、转让","联系不上商家，或实地地址无此店"};

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
