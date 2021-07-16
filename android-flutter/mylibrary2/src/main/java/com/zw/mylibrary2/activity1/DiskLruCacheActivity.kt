package com.zw.mylibrary2.activity1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.jakewharton.disklrucache.DiskLruCache
import com.zw.mylibrary2.R
import kotlinx.android.synthetic.main.activity_disk_lru_cache.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

/**
 * DiskLruCache在本地有一个journal的日志文件
 *
 * libcore.io.DiskLruCache
 * 1
 * 100
 * 2
 * CLEAN 3400330d1dfc7f3f7f4b8d4d803dfcf6 832 21054
 * DIRTY 335c4c6028171cfddfbaae1a9c313c52
 * CLEAN 335c4c6028171cfddfbaae1a9c313c52 3934 2342
 * REMOVE 335c4c6028171cfddfbaae1a9c313c52
 * DIRTY 1ab96a171faeeee38496d8b330771a7a
 * CLEAN 1ab96a171faeeee38496d8b330771a7a 1600 234
 * READ 335c4c6028171cfddfbaae1a9c313c52
 *
 * 其中1表示diskCache的版本，100表示应用的版本，2表示一个key对应多少个缓存文件。
 * 接下来每一行，如
 * CLEAN 3400330d1dfc7f3f7f4b8d4d803dfcf6 832 21054
 * [状态] [key] [缓存文件1的size] [缓存文件2的size]
 *
 *  private static final String CLEAN = "CLEAN";
 *  private static final String DIRTY = "DIRTY";
 *  private static final String REMOVE = "REMOVE";
 *  private static final String READ = "READ";
 *
 *  DIRTY 创建或者修改一个缓存的时候，会有一条DIRTY记录，后面会跟一个CLEAN或REMOVE的记录。如果没有CLEAN或REMOVE，对应的缓存文件是无效的，会被删掉
 *  CLEAN 表示对应的缓存操作成功了，后面会带上缓存文件的大小
 *  REMOVE 表示对应的缓存被删除了
 *  READ 表示对应的缓存被访问了，因为LRU需要READ记录来调整缓存的顺序
 */

class DiskLruCacheActivity : AppCompatActivity(), View.OnClickListener {
    private var TAG = DiskLruCache::class.java.simpleName + "-xxx"

    private var dir = "disklrucache_test"

    private var key_1 = "test-disk_1"
    private var key_2 = "test-disk_2"

    private lateinit var diskLruCache_1: DiskLruCache
    private lateinit var diskLruCache_2: DiskLruCache

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disk_lru_cache)
        initFile()

        btn_test1.setOnClickListener(this)
        btn_test2.setOnClickListener(this)
        btn_test3.setOnClickListener(this)

        lifecycle.addObserver(MyLifecycleObserver())
    }

    private inner class MyLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun create() {
            Log.i(TAG, "create ......")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun start() {
            Log.i(TAG, "start ......")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
        fun any() {
            Log.i(TAG, "any ......")
        }
    }

    private fun initFile() {
        dir = "${Environment.getExternalStorageDirectory()}/$dir"
        var f = File(dir)
        if (!f.exists()) f.mkdirs()
        diskLruCache_1 = DiskLruCache.open(
            File(dir),
            1,
            1,
            1024 * 1024 * 128
        )

        diskLruCache_2 = DiskLruCache.open(
            File(dir),
            1,
            1,
            1024 * 1024 * 128
        )
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
        var snapshot = diskLruCache_1.get(key_1)
        var editor = diskLruCache_1.edit(key_1)
        diskLruCache_1.remove(key_1)
    }

    private fun test2() {
        GlobalScope.launch(Dispatchers.IO) {
            var snapshot = diskLruCache_1.get(key_1)
            var input = snapshot.getInputStream(0)
            var bs = input.readBytes()
            Log.i(TAG, "${String(bs)}")
            withContext(Dispatchers.Main) {
                tv_text.setText(String(bs))
            }
        }
    }

    private fun test1() {
        GlobalScope.launch(Dispatchers.IO) {
            var editor = diskLruCache_1.edit(key_1)
            var outputStream = editor.newOutputStream(0)
            var s = "Hello World!"
            outputStream.write(s.toByteArray())
            outputStream.close()
            editor.commit()

            editor = diskLruCache_1.edit(key_1)
            outputStream = editor.newOutputStream(0)
            s = "Hello World! 111111"
            outputStream.write(s.toByteArray())
            outputStream.close()
            editor.commit()

            editor = diskLruCache_2.edit(key_2)
            outputStream = editor.newOutputStream(0)
            s = "Hello World! 2 ......"
            outputStream.write(s.toByteArray())
            outputStream.close()
            editor.commit()
        }
    }
}