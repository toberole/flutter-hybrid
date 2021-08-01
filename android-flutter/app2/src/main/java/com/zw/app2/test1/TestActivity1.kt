package com.zw.app2.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zw.app2.NativeTest1
import com.zw.app2.R
import kotlinx.android.synthetic.main.activity_test1.*

class TestActivity1 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        btn_test1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {
                NativeTest1.test1()
            }
        }
    }
}