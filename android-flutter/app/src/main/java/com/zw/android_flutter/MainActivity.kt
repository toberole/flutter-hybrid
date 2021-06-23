package com.zw.android_flutter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.zw.android_flutter.activity.demo.*
import com.zw.android_flutter.activity.flutter.FlutterActivity1
import com.zw.android_flutter.activity.flutter.FlutterEngineGroupActivity
import com.zw.android_flutter.activity.flutter.MethodChannelDemoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        // 设置全屏模式
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        // 去除标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_main)

        btn_FlutterActivity1.setOnClickListener(this)
        btn_MethodChannelDemoActivity.setOnClickListener(this)
        btn_Demo1Activity.setOnClickListener(this)
        btn_Demo2Activity.setOnClickListener(this)
        btn_TestFragmentActivity.setOnClickListener(this)
        btn_TestServiceActivity.setOnClickListener(this)
        btn_LifeCycleActivity.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_LifeCycleActivity -> {
//                var i = Intent(this@MainActivity, LifeCycleActivity::class.java)
//                this@MainActivity.startActivity(i)

                var i = Intent()
                i.setAction("com.test.xxxx")
                i.addCategory("com.test.xxxx")
                this@MainActivity.startActivity(i)
            }

            R.id.btn_TestServiceActivity -> {
                var i = Intent(this@MainActivity, TestServiceActivity::class.java)
                this@MainActivity.startActivity(i)
            }

            R.id.btn_FlutterActivity1 -> {
                //val target = FlutterActivity1::class.java
                val target = getTarget()
                var i = Intent(this@MainActivity, target)
                this@MainActivity.startActivity(i)
            }

            R.id.btn_MethodChannelDemoActivity -> {
                var i = Intent(this@MainActivity, MethodChannelDemoActivity::class.java)
                this@MainActivity.startActivity(i)
            }

            R.id.btn_FlutterEngineGroupActivity -> {
                var i = Intent(this@MainActivity, FlutterEngineGroupActivity::class.java)
                this@MainActivity.startActivity(i)
            }

            R.id.btn_Demo1Activity -> {
                var i = Intent(this@MainActivity, Demo1Activity::class.java)
                this@MainActivity.startActivity(i)
            }

            R.id.btn_Demo2Activity -> {
                var i = Intent(this@MainActivity, Demo2Activity::class.java)
                this@MainActivity.startActivity(i)
            }

            R.id.btn_TestFragmentActivity -> {
                var i = Intent(this@MainActivity, TestFragmentActivity::class.java)
                this@MainActivity.startActivity(i)
            }


        }
    }

    private fun getTarget(): Class<*>? {
        return FlutterActivity1::class.java
    }
}