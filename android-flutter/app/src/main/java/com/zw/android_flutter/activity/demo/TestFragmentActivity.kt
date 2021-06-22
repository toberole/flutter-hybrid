package com.zw.android_flutter.activity.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.zw.android_flutter.R
import com.zw.android_flutter.fragment.TestFragmentXXX
import kotlinx.android.synthetic.main.activity_test_fragment.*

/**
 * Adapter对比:
 * FragmnetPageAdapter在每次切换页面时，只是将Fragment进行分离，
 * 适合页面较少的Fragment使用以保存一些内存，对系统内存不会多大影响。
 *
 * FragmentPageStateAdapter在每次切换页面的时候，是将Fragment进行回收，
 * 适合页面较多的Fragment使用，这样就不会消耗更多的内存
 */
class TestFragmentActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_fragment)
        btn_test.setOnClickListener(this)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test -> {
                var f = TestFragmentXXX()
                var b = Bundle()
                b.putString("Hello", "World")
                f.arguments = b
                val ff = supportFragmentManager.beginTransaction()
                ff.add(R.id.fl_container, f)
                ff.commit()
            }
        }
    }
}