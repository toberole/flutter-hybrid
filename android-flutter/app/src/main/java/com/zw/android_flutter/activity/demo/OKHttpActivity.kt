package com.zw.android_flutter.activity.demo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zw.android_flutter.R
import kotlinx.android.synthetic.main.activity_okhttp.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.IOException
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * OKhttp使用到的设计模式
 * 外观模式。通过okHttpClient这个外观去实现内部各种功能。
 * 建造者模式。构建不同的Request对象。
 * 工厂模式。通过OkHttpClient生产出产品RealCall。
 * 享元模式。通过线程池、连接池共享对象。
 * 责任链模式。将不同功能的拦截器形成一个链。
 *
 * websocket相关用到的观察者模式。
 * Cache集合相关的迭代器模式。
 */
class OKHttpActivity : AppCompatActivity(), View.OnClickListener {
    private var TAG = OKHttpActivity::class.java.simpleName

    private var URL = "https://www.baidu.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)

        btn_sync_get.setOnClickListener(this)
        btn_async_get.setOnClickListener(this)
        btn_sync_post.setOnClickListener(this)
        btn_async_post.setOnClickListener(this)
    }

    fun test(name: String, block: () -> Unit) {
        Log.i("net-xxx", "name: $name")
        block()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_sync_get -> {
                test("hello test") {
                    Log.i("net-xxx", "test block ......")
                }
                sync_get()
            }

            R.id.btn_async_get -> {
                async_get()
            }

            R.id.btn_sync_post -> {
                sync_post()
            }

            R.id.btn_async_post -> {
                async_post()
            }
        }
    }

    // 同步执行
    fun sync_get() {
        GlobalScope.launch(Dispatchers.IO) {
            /**
             * new OkHttpClient;
             * 构造Request对象;
             * 通过前两步中的对象构建Call对象;
             * 通过Call#execute方法来提交异步请求；
             */
            var client = OkHttpClient.Builder()
                .addInterceptor(GlobalInterceptor())
                .addNetworkInterceptor(NetworkInterceptor())
//                .cache(Cache())
//                .cache(CacheControl.Builder().build())
                .build()
            var builder = Request.Builder()
            // var str = "https://publicobject.com/helloworld.txt"
            var str = "https://www.baidu.com"
            var request = builder.url(str).get().build()

            var call = client.newCall(request)
            var response = call.execute()
            printResponse(response)

            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                }

                override fun onResponse(call: Call, response: Response) {

                }
            })

            var p = ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, LinkedBlockingQueue())

        }
    }


    private inner class NetworkInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            Log.i("net-xxx", "NetworkInterceptor $chain......")
            return chain.proceed(chain.request())
        }
    }

    private inner class GlobalInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            Log.i("net-xxx", "GlobalInterceptor $chain")
            val request = chain.request()

            val startTime = System.nanoTime()
            Log.i(
                "nex-xxx",
                java.lang.String.format(
                    "Sending request %s on %s%n%s",
                    request.url,
                    chain.connection(),
                    request.headers
                )
            )

            val response = chain.proceed(request)

            val endTime = System.nanoTime()
            Log.i(
                "nex-xxx", String.format(
                    "Received response for %s in %.1fms%n%s",
                    response.request.url, (endTime - startTime) / 1e6, response.headers
                )
            )
            return response
        }
    }

    /**
     * 推荐让 OkHttpClient 保持单例，用同一个 OkHttpClient 实例来执行你的所有请求，
     * 因为每一个OkHttpClient 实例都拥有自己的连接池和线程池，重用这些资源可以减少延时
     * 和节省资源，如果为每个请求创建一个 OkHttpClient 实例，显然就是一种资源的浪费。
     *
     * 每一个Call（其实现是RealCall）只能执行一次，否则会报异常
     */
    private fun async_post() {
        /**
         * 用户可传入的 interceptor 分为两类：
         * ① 一类是全局的 interceptor，该类 interceptor 在整个拦截器链中最早被调用，
         * 通过 OkHttpClient.Builder#addInterceptor(Interceptor) 传入；
         *
         * ② 另外一类是非网页请求的 interceptor ，这类拦截器只会在非网页请求中被调用，
         * 并且是在组装完请求之后，
         *
         * 真正发起网络请求前被调用，所有的 interceptor 被保存在
         * List<Interceptor> interceptors 集合中，按照添加顺序来逐个调用
         */
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(GlobalInterceptor())// 添加全局的拦截器
            .build()

        val mediaType = "text/x-markdown; charset=utf-8".toMediaTypeOrNull()
        val requestBody = "I am Jdqm."
        val request: Request = Request.Builder()
            .url(URL)
            .post(RequestBody.create(mediaType, requestBody))
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {

            }
        })

    }

    private fun sync_post() {

    }

    // 异步GET 请求
    fun async_get() {
        /**
         * new OkHttpClient;
         * 构造Request对象;
         * 通过前两步中的对象构建Call对象;
         * 通过Call#enqueue(Callback)方法来提交异步请求；
         */
        var client = OkHttpClient()
        var builder = Request.Builder()
        var request = builder.url(URL).get().build()
        var call = client.newCall(request)
        // 异步发起的请求会被加入到 Dispatcher 中的
        // runningAsyncCalls双端队列中通过线程池来执行
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(call.request())
            }

            override fun onResponse(call: Call, response: Response) {
                println(response.message)
                println(response.body.toString())
                println(response.code)
                println(response.headers)
            }
        })
    }

    private fun printResponse(response: Response) {
        var sb = StringBuffer()
        sb.append("${response.protocol} ${response.code} ${response.message}\n")
        val headers = response.headers
        for (i in 0 until headers.size) {
            sb.append("${headers.name(i)}: ${headers.value(i)}\n")
        }
        sb.append("\n${response.body?.string()}\n")

        Log.i("nex-xxx", "response: ${sb.toString()}")
    }
}