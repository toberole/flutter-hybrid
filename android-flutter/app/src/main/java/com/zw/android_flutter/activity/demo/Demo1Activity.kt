package com.zw.android_flutter.activity.demo

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.ViewConfiguration
import com.zw.android_flutter.JNITest
import com.zw.android_flutter.R
import kotlinx.android.synthetic.main.activity_demo1.*

class Demo1Activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo1)
        Log.i("Demo1Activity-xxx", "onCreate ......")
        btn_test1.setOnClickListener(this)
        testView.setOnClickListener(this)
        test()
    }

    fun test() {
        Log.i(
            "Demo1Activity-xxx",
            "scaledTouchSlop: ${ViewConfiguration.get(this).scaledTouchSlop}"
        )
    }

    override fun onStart() {
        super.onStart()
        Log.i("Demo1Activity-xxx", "onStart ......")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Demo1Activity-xxx", "onResume ......")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Demo1Activity-xxx", "onPause ......")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Demo1Activity-xxx", "onStop ......")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Demo1Activity-xxx", "onDestroy ......")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("Demo1Activity-xxx", "onRestoreInstanceState ......")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.i("Demo1Activity-xxx", "onSaveInstanceState 1 ......")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("Demo1Activity-xxx", "onSaveInstanceState 2 ......")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.i("Demo1Activity-xxx", "onNewIntent ......")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.i("Demo1Activity-xxx", "onConfigurationChanged ......")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {
                var t = JNITest()
                t.test1(0);
            }
            R.id.testView -> {
                testView.anim()
            }
        }
    }
}