package com.zw.android_flutter

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import io.flutter.embedding.engine.FlutterEngineGroup

class App : Application() {
    companion object {
        var flutterEngineGroup: FlutterEngineGroup? = null
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        flutterEngineGroup = FlutterEngineGroup(this)
    }
}