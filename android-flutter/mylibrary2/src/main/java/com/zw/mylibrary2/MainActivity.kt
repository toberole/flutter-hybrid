package com.zw.mylibrary2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import com.zw.mylibrary2.activity1.DiskLruCacheActivity
import com.zw.mylibrary2.activity1.GlideActivity
import com.zw.mylibrary2.activity1.MyLifecycleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(
            this, arrayOf(
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.INTERNET,
            ), 110
        )

        btn_GlideActivity.setOnClickListener(this)
        btn_DiskLruCacheActivity.setOnClickListener(this)
        btn_MyLifecycleActivity.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_GlideActivity -> {
                var i = Intent(this, GlideActivity::class.java)
                startActivity(i)
            }

            R.id.btn_DiskLruCacheActivity -> {
                var i = Intent(this, DiskLruCacheActivity::class.java)
                startActivity(i)
            }

            R.id.btn_MyLifecycleActivity -> {
                var i = Intent(this, MyLifecycleActivity::class.java)
                startActivity(i)
            }


        }
    }
}