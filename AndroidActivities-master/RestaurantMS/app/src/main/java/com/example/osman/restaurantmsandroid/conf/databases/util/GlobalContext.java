package com.example.osman.restaurantmsandroid.conf.databases.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Osman on 2016-06-05.
 */
public class GlobalContext extends Application {
    public static Context context;

    private static GlobalContext singleton;

    public void onCreate() {
        super.onCreate();
        GlobalContext.context = getApplicationContext();
        singleton = this;
    }

    public static Context getAppContext() {
        return GlobalContext.context;
    }

    public static synchronized GlobalContext getInstance() {
        return singleton;
    }

}
