package com.dz.elen.homeworks;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;


import com.squareup.leakcanary.LeakCanary;

public class MyApplication extends Application {
    public void onCreate() {

        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
