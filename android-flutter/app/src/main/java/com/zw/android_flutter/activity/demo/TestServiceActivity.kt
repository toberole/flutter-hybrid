package com.zw.android_flutter.activity.demo

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import com.zw.android_flutter.R
import com.zw.android_flutter.service.MyService
import kotlinx.android.synthetic.main.activity_test_service.*

class TestServiceActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_service)

        btn_start.setOnClickListener(this)
        btn_stop.setOnClickListener(this)

        btn_bind1.setOnClickListener(this)
        btn_unbind1.setOnClickListener(this)

        btn_bind2.setOnClickListener(this)
        btn_unbind2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_start -> {
                var i = Intent(this@TestServiceActivity, MyService::class.java)
                startService(i)
            }

            R.id.btn_stop -> {
                var i = Intent(this@TestServiceActivity, MyService::class.java)
                stopService(i)
            }

            R.id.btn_bind1 -> {
                Log.i("MyService", "btn_bind1 ......")

                var i = Intent(this@TestServiceActivity, MyService::class.java)
                bindService(i, object : ServiceConnection {
                    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                    }

                    override fun onServiceDisconnected(name: ComponentName?) {
                    }
                }, BIND_AUTO_CREATE)
            }

            R.id.btn_unbind1 -> {

            }

            R.id.btn_bind2 -> {
                Log.i("MyService", "btn_bind2 ......")

                var i = Intent(this@TestServiceActivity, MyService::class.java)
                bindService(i, object : ServiceConnection {
                    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

                    }

                    override fun onServiceDisconnected(name: ComponentName?) {
                    }
                }, BIND_AUTO_CREATE)
            }

            R.id.btn_unbind2 -> {

            }
        }
    }
}