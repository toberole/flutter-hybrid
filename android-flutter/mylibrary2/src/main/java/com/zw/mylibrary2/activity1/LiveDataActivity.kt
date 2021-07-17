package com.zw.mylibrary2.activity1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.zw.mylibrary2.R
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity(), View.OnClickListener {
    private var liveData = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        /**
         * livedata分发数据的时候 会判断当前Activity的生命周期状态
         */
        liveData.observe(this, {
            tv_txt.text = it
        })
        btn_test1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {
                liveData.postValue("hello")
                liveData.value = "123"
            }
        }
    }
}