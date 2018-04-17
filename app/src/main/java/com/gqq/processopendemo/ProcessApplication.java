package com.gqq.processopendemo;

import android.app.Application;
import android.util.Log;

/**
 * Created by gqq on 2018/4/17.
 */

public class ProcessApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TAG", "ProcessApplication");
    }
}
