package com.zw.android_flutter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zw.android_flutter.activity.FlutterActivity1
import com.zw.android_flutter.activity.FlutterEngineGroupActivity
import com.zw.android_flutter.activity.MethodChannelDemoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_FlutterActivity1.setOnClickListener(this)
        btn_MethodChannelDemoActivity.setOnClickListener(this)
        btn_FlutterEngineGroupActivity.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_FlutterActivity1 -> {
                var i = Intent(this@MainActivity, FlutterActivity1::class.java)
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


        }
    }
}