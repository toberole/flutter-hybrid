package com.zw.android_flutter.mv_x.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zw.android_flutter.R
import kotlinx.android.synthetic.main.activity_m_v_p.*

/**
 * MVP模式下 Activity相当于View了
 *  Activity 与 Presenter相互持有
 */
class MVPActivity : AppCompatActivity(), View.OnClickListener, OnLoginListener {
    private lateinit var u_p: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_m_v_p)
        u_p = UserPresenter(this)
        btn_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        u_p.login(User(et_name.text.toString()))
    }

    override fun onLogin(user: User) {
        Toast.makeText(this, user.name, Toast.LENGTH_SHORT).show()
    }
}