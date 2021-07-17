package com.zw.mylibrary2.activity1

import android.os.Bundle
import com.zw.mylibrary2.R
import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {
    private lateinit var vm: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        vm = ViewModelProvider(this).get(TestViewModel::class.java)
        vm.currentName.observe(this, {
            tv_txt.text = it
        })

        btn_test1.setOnClickListener {
            vm.getName()
        }
    }
}