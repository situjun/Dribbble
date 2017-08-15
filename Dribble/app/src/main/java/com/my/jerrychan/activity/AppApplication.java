package com.my.jerrychan.activity;

import android.app.Application;
import android.content.Context;

/**
 * Created by linchen on 16/2/21.
 * github:https://github.com/JerryChan123
 * e-mail:linchen0922@163.com
 */
public class AppApplication extends Application {

    private static Application application;
    public static Context getInstance(){
        if (application==null){
            return new Application();
        }
        return application;
    }
}
