package com.zw.android_flutter.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.zw.android_flutter.IMyAidlInterface

class IMyAidlInterfaceService : Service() {
    companion object {
        var TAG = IMyAidlInterfaceService::class.java.simpleName
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand ......")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        Log.i(TAG, "onBind ......")
        return IMyAidlInterfaceImpl.getInstance()
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate ......")
    }
}