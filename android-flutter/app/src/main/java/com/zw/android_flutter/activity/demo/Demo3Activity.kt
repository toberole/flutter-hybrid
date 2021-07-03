package com.zw.android_flutter.activity.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.TextView
import com.zw.android_flutter.R
import kotlinx.android.synthetic.main.activity_demo3.*

class Demo3Activity : AppCompatActivity(), View.OnClickListener {
    companion object {
        var TAG = Demo3Activity::class.java.simpleName + "-xxx"
    }

    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo3)

        handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                Log.i(TAG, "handleMessage ......")
                handler.sendEmptyMessageDelayed(11, 1000 * 4)
            }
        }

        handler.sendEmptyMessageDelayed(11, 500)
        btn_test.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test -> {
                var v = viewstub.inflate()
                Log.i(TAG, "v: $v")
                var tv_txt = v.findViewById<TextView>(R.id.tv_txt)
                tv_txt.setText("${System.currentTimeMillis()}")

                var v1 = findViewById<View>(R.id.include_test)
                Log.i(TAG, "v1: $v1")
            }
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.i(TAG, "onTrimMemory level: $level")
    }
}