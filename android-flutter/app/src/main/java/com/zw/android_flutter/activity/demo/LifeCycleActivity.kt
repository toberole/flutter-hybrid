package com.zw.android_flutter.activity.demo

import android.os.Bundle
import com.zw.android_flutter.R
import com.zw.android_flutter.DemoBaseActivity

/**
 * 横竖屏切换的Activity 生命周期变化？
 * 不设置 Activity 的 android:configChanges 时，切屏会销毁当前Activity，然后重新加载调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次；onPause()→onStop()→onDestory()→onCreate()→onStart()→onResume()
 * 设置 Activity 的 android:configChanges=" orientation"，经过机型测试
 * 在 Android5.1 即 即 API 3 23 级别下，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次
 * 在 Android9 即 即 API 8 28 级别下，切屏不会重新调用各个生命周期，只会执行 onConfigurationChanged方法
 * 官方纠正后，原话如下
 * 如果您的应用面向 Android 2 3.2 即 即 API 级别 3 13 或更高级别（按照 minSdkVersion 和 targetSdkVersion)
 */
class LifeCycleActivity : DemoBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }
}