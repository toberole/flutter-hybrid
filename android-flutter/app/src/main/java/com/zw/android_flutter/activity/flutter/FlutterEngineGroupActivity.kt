package com.zw.android_flutter.activity.flutter

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.zw.android_flutter.App
import com.zw.android_flutter.DemoBaseFlutterActivity
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor

/**
 * FlutterEngineGroup优化共享引擎
 */
class FlutterEngineGroupActivity : DemoBaseFlutterActivity() {
    private val TAG = "FlutterEngineGroupActivity-xxx"

    /**
     * 通过FlutterEngineGroup共享引擎
     *
     * 因为每个 Flutter 页面都是一个独立的 Engine ，
     * 由于 dart isolate 的设计理念，「每个独立 Engine 的 Flutter 页面内存是无法共享的」。
     * 当需要共享数据时，只能在原生层持有数据，然后注入或者传递到每个 Flutter 页面中
     */
    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        Log.i(TAG, "FlutterEngineGroupActivity provideFlutterEngine ......")

        /**
         * dartEntrypointFunctionName
         * dart层的入口方法
         */
        val dartEntrypointFunctionName = "main"
        val dartEntrypoint = DartExecutor.DartEntrypoint(
            FlutterInjector.instance().flutterLoader().findAppBundlePath(),
            dartEntrypointFunctionName
        )
        val engine = App.flutterEngineGroup?.createAndRunEngine(this, dartEntrypoint)
        return engine
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_flutter_engine_group)
        Log.i(TAG, "FlutterEngineGroupActivity onCreate ......")
    }
}