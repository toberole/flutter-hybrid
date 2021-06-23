package com.zw.android_flutter.activity.demo

import android.os.Bundle
import com.zw.android_flutter.R
import com.zw.android_flutter.activity.DemoBaseActivity

class LifeCycleActivity : DemoBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }
}