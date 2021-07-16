package com.zw.mylibrary2.activity1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import com.zw.mylibrary2.R

class MyLifecycleActivity : AppCompatActivity() {
    private var TAG = "MyLifecycleActivity-xxx"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_lifecycle)
        lifecycle.addObserver(MyLifecycleObserver())
        lifecycle.addObserver(MyDefaultLifecycleObserver())
        Log.i(TAG, "MyLifecycleActivity#onCreate ......")
    }

    private inner class MyDefaultLifecycleObserver : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            super.onCreate(owner)
            Log.i(TAG, "MyDefaultLifecycleObserver#onCreate ......")
        }

        override fun onStart(owner: LifecycleOwner) {
            super.onStart(owner)
            Log.i(TAG, "MyDefaultLifecycleObserver#onStart ......")
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