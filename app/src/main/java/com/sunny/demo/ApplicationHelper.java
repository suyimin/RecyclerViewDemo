package com.sunny.demo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by suym on 2016/6/15.
 */
public class ApplicationHelper extends Application {

    public static ApplicationHelper instance;
    public static List<Activity> atyList = new ArrayList<Activity>();
    public static Map loginMap;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    /**
     * 添加Activity，统一管理
     */
    public static void add(Activity aty) {
        atyList.add(aty);
    }

    /**
     * 退出应用
     */
    public static void exit() {
        for (Activity aty : atyList) {
            if (!aty.isFinishing()) aty.finish();
        }
        loginMap = null;
    }
}
