package com.zw.mylibrary2.activity1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import com.zw.mylibrary2.R

/**
 * lifecycle state
 * 五种状态：
 *      DESTROYED,INITIALIZED,CREATED,STARTED,RESUMED;
 *
 * 七种事件：
 *      ON_CREATE, ON_START,ON_RESUME,ON_PAUSE,ON_STOP,ON_DESTROY,ON_ANY;
 */
class MyLifecycleActivity : AppCompatActivity() {
    private var TAG = "MyLifecycleActivity-xxx"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_lifecycle)
//        lifecycle.addObserver(MyLifecycleObserver())
        lifecycle.addObserver(MyDefaultLifecycleObserver())
        Log.i(TAG, "MyLifecycleActivity#onCreate ......")

        Lifecycle.State.CREATED
        Lifecycle.Event.ON_CREATE
    }

    override fun onStart() {
        super.onStart()
//        lifecycle.addObserver(MyDefaultLifecycleObserver())
    }

    private inner class MyDefaultLifecycleObserver : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            super.onCreate(owner)
            Log.i(TAG, "MyDefaultLifecycleObserver#onCreate ......${owner.lifecycle.currentState}")
        }

        override fun onResume(owner: LifecycleOwner) {
            super.onResume(owner)
            Log.i(TAG, "MyDefaultLifecycleObserver#onResume ......${owner.lifecycle.currentState}")
        }

        override fun onStart(owner: LifecycleOwner) {
            super.onStart(owner)
            Log.i(TAG, "MyDefaultLifecycleObserver#onStart ......${owner.lifecycle.currentState}")
        }
    }

    private inner class MyLifecycleObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            Log.i(TAG, "onCreate ......")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onStart() {
            Log.i(TAG, "onStart ......")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            Log.i(TAG, "onDestroy ......")
        }
    }
}