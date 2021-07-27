package com.zw.android_flutter

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.os.Environment
import android.content.Context
import android.os.Looper
import android.util.Log
import android.view.Choreographer
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import java.io.File
import kotlinx.android.synthetic.main.activity_main.*
import com.zw.android_flutter.activity.demo.*
import com.zw.android_flutter.activity.flutter.FlutterActivity1
import com.zw.android_flutter.activity.flutter.FlutterEngineGroupActivity
import com.zw.android_flutter.activity.flutter.MethodChannelDemoActivity
import com.zw.android_flutter.arithmetic.*
import com.zw.android_flutter.test1.*
import com.zw.android_flutter.test2.Test1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener, Choreographer.FrameCallback {
    companion object {
        var TAG = MainActivity::class.java.simpleName + "-xxx"
    }

    private var time: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val applicationId = BuildConfig.APPLICATION_ID

        ActivityCompat.requestPermissions(this@MainActivity, Constant.PS, 110)
//        // 设置全屏模式
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
//        // 去除标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
        App.getCtx()
        setContentView(R.layout.activity_main)

        Thread { test() }.start()
        Choreographer.getInstance().postFrameCallback(this)
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
        btn_SortActivity.setOnClickListener(this)
        btn_NativeActivity.setOnClickListener(this)
        btn_OKHttpActivity.setOnClickListener(this)
        btn_ELFActivity.setOnClickListener(this)
        btn_ProfilerActivity.setOnClickListener(this)



    }

    private fun test() {


        var i = Solution5.hammingWeight(15)
        Log.i(TAG, "i: $i")
//        Log.i(TAG, "jump2: ${ Solution4.jump2(50)}")
//        Solution4.test1()
//        Solution3.test()
//        Solution2.test()
//        Solution1.test()
//        Test6.test1()
//        Thread {
//            // Test7.test()
//            // Test8.test2()
//            // Test8.test3()
//            // Test9.test1()
//            ConTest.test()
//        }.start()

        Test1.test1()

        Log.i("test1-class", "${Test1::class.java}")
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.btn_ProfilerActivity -> {
                var i = Intent(this@MainActivity, ProfilerActivity::class.java)
                this@MainActivity.startActivity(i)
            }
            R.id.btn_ELFActivity -> {
                var i = Intent(this@MainActivity, ELFActivity::class.java)
                this@MainActivity.startActivity(i)
            }
            R.id.btn_OKHttpActivity -> {
                var i = Intent(this@MainActivity, OKHttpActivity::class.java)
                this@MainActivity.startActivity(i)
            }

            R.id.btn_NativeActivity -> {
                var i = Intent(this@MainActivity, NativeActivity::class.java)
                this@MainActivity.startActivity(i)
            }
            R.id.btn_SortActivity -> {
                var i = Intent(this@MainActivity, SortActivity::class.java)
                this@MainActivity.startActivity(i)
            }
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
                var i = Intent(this@MainActivity, LifeCycleActivity::class.java)
                this@MainActivity.startActivity(i)

//                var i = Intent()
//                i.setAction("com.test.xxxx")
//                i.addCategory("com.test.xxxx")
//                this@MainActivity.startActivity(i)
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
                var i = Intent(this@MainActivity, TestServiceActivity::class.java)
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

    override fun onStart() {
        super.onStart()

        GlobalScope.launch(Dispatchers.IO) {
            printView(sv_container)
        }
    }

    private fun test1() {
        Thread {
            Looper.prepare()
            Looper.prepare()
        }.start()
    }

    fun printView(v: View) {
        var stack = Stack<View>()
        stack.push(v)

        while (stack.size > 0) {
            var view: View? = stack.pop() ?: continue

            Log.i("view-xxx", "stack.size: ${stack.size},${view!!.javaClass.simpleName}")

            if (view is ViewGroup) {
                var vg = view as ViewGroup
                var count = vg.childCount
                for (i in 0..count) {
                    stack.push(vg.getChildAt(i))
                }
            }
        }
    }

    override fun doFrame(frameTimeNanos: Long) {
        if (time == 0L) {
            time = frameTimeNanos
        }
        var v = frameTimeNanos - time
        Log.i("postFrameCallback", "postFrameCallback ${v / 1_000_000 / 1_000}......")
        Choreographer.getInstance().postFrameCallback(this)
    }
}