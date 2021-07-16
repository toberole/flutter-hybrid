package com.zw.mylibrary2.activity1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.zw.mylibrary2.R
import kotlinx.android.synthetic.main.activity_my_lifecycle_registry.*

class MyLifecycleRegistryActivity : AppCompatActivity(), View.OnClickListener {
    private var TAG = MyLifecycleRegistryActivity::class.java.simpleName

    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_lifecycle_registry)
        initLifecycleRegistry()
        btn_test1.setOnClickListener(this)
    }

    private fun initLifecycleRegistry() {
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
        lifecycleRegistry.addObserver(OB())
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {

            }
        }
    }

    private inner class OB : DefaultLifecycleObserver {
        override fun onStart(owner: LifecycleOwner) {
            super.onStart(owner)
        }
    }
}