package com.zw.android_flutter.activity.flutter

import io.flutter.embedding.android.FlutterActivity

class FlutterActivity1 : FlutterActivity() {
    companion object {
        // val route = "FlutterActivity1"
        val route = "Demo1Page"
    }

    override fun getInitialRoute(): String {
        return route
    }
}