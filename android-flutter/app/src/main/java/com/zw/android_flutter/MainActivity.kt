package com.zw.android_flutter


import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.os.Environment
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import kotlinx.android.synthetic.main.activity_main.*
import com.zw.android_flutter.activity.demo.*
import com.zw.android_flutter.activity.flutter.FlutterActivity1
import com.zw.android_flutter.activity.flutter.FlutterEngineGroupActivity
import com.zw.android_flutter.activity.flutter.MethodChannelDemoActivity
import com.zw.android_flutter.test1.Test6

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BuildConfig.APPLICATION_ID
//        // 设置全屏模式
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
//        // 去除标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
        App.getCtx()
        setContentView(R.layout.activity_main)
        test()
        Test6.test1()

        btn_FlutterActivity1.setOnClickListener(this)
        btn_MethodChannelDemoActivity.setOnClickListener(this)
        btn_Demo1Activity.setOnClickListener(this)
        btn_Demo2Activity.setOnClickListener(this)
        btn_TestFragmentActivity.setOnClickListener(this)
        btn_TestServiceActivity.setOnClickListener(this)
        btn_LifeCycleActivity.setOnClickListener(this)
        btn_TaskActivity.setOnClickListener(this)
        btn_List_Recycler_Activity.setOnClickListener(this)
        btn_Demo3Activity.setOnClickListener(this)


    }

    private fun test() {

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_Demo3Activity -> {
                var i = Intent(this@MainActivity, Demo3Activity::class.java)
                this@MainActivity.startActivity(i)
            }

            R.id.btn_List_Recycler_Activity -> {
                var i = Intent(App.ctx, List_Recycler_View_Activity::class.java)
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                App.ctx?.startActivity(i)
            }

//            R.id.btn_List_Recycler_Activity -> {
//                var i = Intent(this@MainActivity, List_Recycler_View_Activity::class.java)
//                this@MainActivity.startActivity(i)
//            }

            R.id.btn_TaskActivity -> {
                var i = Intent(this@MainActivity, TaskActivity::class.java)
                this@MainActivity.startActivity(i)
            }

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


    private fun installAPK(ctx: Context, apkName: String) {
        val apkFile = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            apkName
        )
        val intent = Intent(Intent.ACTION_VIEW)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val apkUri: Uri = FileProvider.getUriForFile(
                ctx,
                ctx.getPackageName().toString() + ".provider",
                apkFile
            )
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive")
        } else {
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive")
        }
        ctx.startActivity(intent)
    }


}