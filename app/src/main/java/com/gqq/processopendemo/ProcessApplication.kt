package com.gqq.processopendemo

import android.app.Application
import android.content.Context
import android.util.Log

/**
 * Created by gqq on 2018/4/18.
 */
class ProcessApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.i("TAG", "ProcessApplication")
    }
}