package com.zw.app2.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.zw.app2.R
import kotlinx.android.synthetic.main.activity_k_t.*
import kotlinx.coroutines.*
import java.util.concurrent.*
import kotlin.coroutines.CoroutineContext

class KTActivity : AppCompatActivity(), View.OnClickListener {
    private var TAG = "xxx-test"

    private var scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_k_t)

        btn_test1.setOnClickListener(this)
        btn_test2.setOnClickListener(this)
        btn_test3.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {
                test1()
            }
            R.id.btn_test2 -> {
                test2()
            }
            R.id.btn_test3 -> {
                test3()
            }
        }
    }

    private fun test3() {
        var threadPoolExecutor =
            ThreadPoolExecutor(8, 8, 1, TimeUnit.MINUTES, LinkedBlockingQueue())
        var coroutineDispatcher = threadPoolExecutor.asCoroutineDispatcher()

        GlobalScope.launch(coroutineDispatcher) {
            Log.i(TAG, "1 ... thread name: ${Thread.currentThread().name}")
        }

        GlobalScope.launch(coroutineDispatcher) {
            Log.i(TAG, "2 ... thread name: ${Thread.currentThread().name}")
        }

        GlobalScope.launch(coroutineDispatcher) {
            Log.i(TAG, "3 ... thread name: ${Thread.currentThread().name}")
        }
    }

    private fun test2() {
        var cv: CoroutineContext


        var coroutineContext =
            Job() + Dispatchers.Main + CoroutineExceptionHandler { coroutineContext, throwable ->
                {
                    Log.e("xxx-test", "CoroutineException: $throwable")
                }
            } + CoroutineName("asyncConcurrent")

        scope.launch(coroutineContext) {
            val job1 = async(Dispatchers.IO) {
                delay(1000)
                Log.i("xxx-test", "job1-${Thread.currentThread().name}")
                "job1-finish"
            }
            val job2 = async(Dispatchers.IO) {
                delay(2000)
                Log.i("xxx-test", "job2-${Thread.currentThread().name}")

                "job2-finish"
            }
            val job3 = async(Dispatchers.IO) {
                delay(500)
                Log.i("xxx-test", "job3-${Thread.currentThread().name}")

                "job3-finish"
            }
            //等待各job执行完 将结果合并
            Log.i("xxx-test", "job1:${job1.await()},job2:${job2.await()},job3:${job3.await()}")
        }

    }

    fun test1() {
        scope.launch(Dispatchers.Main) {
            Toast.makeText(this@KTActivity, "Hello KT", Toast.LENGTH_SHORT).show()

            withContext(Dispatchers.IO) {
                var d = async(Dispatchers.IO) {
                    "test-async ....."
                }

                Log.i("xxx-test", "${d.await()}")
            }
        }
    }
}