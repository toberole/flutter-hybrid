package com.zw.android_flutter.activity.flutter

import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel

class MethodChannelDemoActivity : FlutterActivity() {
    companion object {
        var MethodChannel_Name = "MethodChannelDemo"
        var TAG = "MethodChannelDemoActivity-xxx"
    }

    private lateinit var mc: MethodChannel

    override fun getInitialRoute(): String {
        return "MethodChannelDemo"
    }

    override fun onResume() {
        super.onResume()
        init_mc()
    }

    private fun init_mc() {
        mc = MethodChannel(flutterEngine?.dartExecutor?.binaryMessenger, MethodChannel_Name)
        mc.setMethodCallHandler { call, result ->
            Log.i(TAG, "call.method: ${call.method}")

            if ("flutter_call_native" == call.method) {
                Log.i(TAG, "flutter_call_native arguments: ${call.arguments}")
                call.arguments?.let {
                    // 打印参数具体类型
                    var args = call.arguments as java.util.ArrayList<*>
                    for (v in args) {
                        Log.i(
                            TAG,
                            "flutter_call_native arguments type: ${v::class.java.simpleName}"
                        )
                    }
                }
            } else if ("transfer_data1" == call.method) {
                var l = call.arguments as Int
                Log.i(TAG, "transfer_data1 arguments: $l")
            } else if ("transfer_data2" == call.method) {
                var l = call.arguments as Boolean
                Log.i(TAG, "transfer_data2 arguments: $l")
            } else if ("transfer_data_list" == call.method) {
                var args = call.arguments as java.util.ArrayList<*>

                for (v in args) {
                    Log.i(
                        TAG,
                        "flutter_call_native arguments type: ${v::class.java.simpleName}"
                    )
                }
            } else if ("transfer_data_map" == call.method) {
                var m = call.arguments as HashMap<*,*>
                Log.i(TAG,"transfer_data_map size: ${m.size}")
            }else if ("transfer_data_arr" == call.method) {
                var m = call.arguments as java.util.ArrayList<*>
                Log.i(TAG,"transfer_data_arr size: ${m.size}")
            }else if ("native_call_flutter" == call.method) {
               mc.invokeMethod("native_call_flutter", arrayListOf("Hello Flutter",1,false))
            }
        }
    }
}