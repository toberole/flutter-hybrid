package com.zw.android_flutter.activity.demo

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.PixelFormat
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.zw.android_flutter.IMyAidlInterface
import com.zw.android_flutter.R
import com.zw.android_flutter.service.IMyAidlInterfaceService
import kotlinx.android.synthetic.main.activity_demo2.*


class Demo2Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binder: IMyAidlInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo2)
        btn_test1.setOnClickListener(this)
        btn_test2.setOnClickListener(this)
        btn_test3.setOnClickListener(this)

        Log.i("Demo2Activity-xxx", Build.VERSION.SDK)

        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(this)) {
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:$packageName")
                )
                startActivityForResult(intent, 1234)
            }
        } else {
            startService(
                Intent(
                    this@Demo2Activity,
                    CheckServicesForApps::class.java
                )
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1234) {
            startService(
                Intent(
                    this@Demo2Activity,
                    CheckServicesForApps::class.java
                )
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {
                var btn = Button(this@Demo2Activity)
                btn.setText("hello btn")

                val LAYOUT_FLAG: Int
                LAYOUT_FLAG = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                } else {
                    WindowManager.LayoutParams.TYPE_PHONE
                }


                var p = WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    LAYOUT_FLAG,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT
                )

                p.gravity = Gravity.TOP

                p.x = 100
                p.y = 300
                windowManager.addView(btn, p)
            }

            R.id.btn_test2 -> {
                var intent = Intent(this, IMyAidlInterfaceService::class.java)
                startService(intent)
            }

            R.id.btn_test3 -> {
                var intent = Intent(this, IMyAidlInterfaceService::class.java)
                bindService(intent, object : ServiceConnection {
                    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                        binder = IMyAidlInterface.Stub.asInterface(service)
                        var str = binder.test2()
                        Log.i("IMyAidlInterfaceService", "IMyAidlInterfaceService test2 ret: $str")
                    }

                    override fun onServiceDisconnected(name: ComponentName?) {

                    }
                }, BIND_AUTO_CREATE)
            }
        }
    }

    private fun test() {
        startActivityForResult(null, 110)
        setResult(110)
        var intent: Intent? = null
        setResult(110, intent)
    }

    @JvmName("onActivityResult1")
    protected fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}