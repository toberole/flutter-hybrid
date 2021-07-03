package com.zw.android_flutter.activity.demo

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.zw.android_flutter.R
import androidx.appcompat.app.AppCompatActivity
import com.zw.android_flutter.fragment.ListFragment
import com.zw.android_flutter.fragment.RecyclerFragment
import kotlinx.android.synthetic.main.activity_list__recycler_.*

class List_Recycler_View_Activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list__recycler_)

        btn_listview.setOnClickListener(this)
        btn_recyclerview.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_listview -> {
                var f = ListFragment.newInstance()
                var t = supportFragmentManager.beginTransaction()
                t.replace(R.id.fl_container, f)
                t.commitAllowingStateLoss()
            }

            R.id.btn_recyclerview -> {
                var f = RecyclerFragment.newInstance()
                var t = supportFragmentManager.beginTransaction()
                t.replace(R.id.fl_container, f)
                t.commitAllowingStateLoss()
            }
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("pointerCount","pointerCount: ${ev?.pointerCount}")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)

    }
}