package com.gzn.mvp_core;

import android.app.Application;

import com.gzn.mvp_core.app.ProjectInit;

import java.util.ArrayList;

import okhttp3.Interceptor;

/**
 * Created by jett on 2018/6/4.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ProjectInit.init(this)
                .withApiHost("")
                .withInterceptors(new ArrayList<Interceptor>())
                .configure();
    }
}
