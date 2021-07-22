package com.zw.mylibrary2.activity1

import android.os.Bundle
import android.util.Log
import android.view.View
import com.zw.mylibrary2.R
import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity(), View.OnClickListener {
    private var TAG = ViewModelActivity::class.java.simpleName + "-xxx"

    private lateinit var vm: TestViewModel

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        if (!this::vm.isInitialized) {
            vm = ViewModelProvider(this@ViewModelActivity).get(TestViewModel::class.java)
            vm.currentName.observe(this@ViewModelActivity, {
                tv_txt.text = it
            })

            vm.currentAddress.observe(this@ViewModelActivity, {
                tv_txt.text = it
            })
        }

        Log.i(TAG, "vm: $vm ......")
        Log.i(TAG, "ViewModelActivity: $this ......")

        btn_test1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {
                if (i++ % 2 == 0) {
                    vm.getName()
                } else {
                    vm.getAddress()
                }
            }
        }
    }
}