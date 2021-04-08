package com.zw.android_flutter.test1

import android.content.Context
import io.flutter.app.FlutterPluginRegistry
import io.flutter.embedding.engine.FlutterEngine

class Test1 {
    fun test1() {
        var engine: FlutterEngine? = null
        var context: Context? = null
        var f = FlutterPluginRegistry(engine, context)
    }
}