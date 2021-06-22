package com.zw.android_flutter.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    companion object {
        var TAG = MyService::class.java.simpleName
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate ......")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand ......")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.i(TAG, "onBind ......")
        return null
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.i(TAG, "onUnbind ......")
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        Log.i(TAG, "onRebind ......")
        super.onRebind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy ......")
    }
}