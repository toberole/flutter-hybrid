package com.zw.android_flutter

import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.multidex.MultiDex
import io.flutter.embedding.engine.FlutterEngineGroup

class App : Application(), Application.ActivityLifecycleCallbacks {
    companion object {
        var TAG = App::class.java.simpleName + "-xxx"

        var flutterEngineGroup: FlutterEngineGroup? = null
        var ctx: Context? = null

        @JvmName("getCtx1")
        fun getCtx(): Context? {
            return ctx
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        flutterEngineGroup = FlutterEngineGroup(this)
        ctx = applicationContext



        registerActivityLifecycleCallbacks(this)

        test()
    }


    var list = arrayListOf<Any>()
    private fun test() {
        val manager: ActivityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val heapSize: Int = manager.getMemoryClass()
        Log.i(TAG, "heapSize: $heapSize M")

        for (i in 1..1000_000) {
            list.add("Hello-$i")
        }
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.i(TAG, "onActivityCreated: $activity")
    }

    override fun onActivityStarted(activity: Activity) {
        Log.i(TAG, "onActivityStarted: $activity")
    }

    override fun onActivityResumed(activity: Activity) {
        Log.i(TAG, "onActivityResumed: $activity")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.i(TAG, "onActivityPaused: $activity")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.i(TAG, "onActivityStopped: $activity")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.i(TAG, "onActivitySaveInstanceState: $activity")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.i(TAG, "onActivityDestroyed: $activity")
    }
}