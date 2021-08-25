package com.zw.android_flutter.activity.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zw.android_flutter.R;
import com.zw.android_flutter.bean.TestBean;

public class CPPActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cppactivity);

        Button btn = findViewById(R.id.btn_lock);
        btn.setOnClickListener(this);

        btn = findViewById(R.id.btn_closure);
        btn.setOnClickListener(this);

        btn = findViewById(R.id.btn_test1);
        btn.setOnClickListener(this);

        btn = findViewById(R.id.btn_test2);
        btn.setOnClickListener(this);

        btn = findViewById(R.id.btn_test3);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(this, "click ...", Toast.LENGTH_SHORT).show();
        switch (v.getId()) {
            case R.id.btn_lock:
                lock();
                break;
            case R.id.btn_closure:
                closure();
                break;
            case R.id.btn_test1:
                btn_test1();
                break;
            case R.id.btn_test2:
                btn_test2();
            case R.id.btn_test3:
                btn_test3("Hello test3 ......");
                break;
        }
    }

    private static native void lock();

    private static native void closure();

    private static native void btn_test1();

    private static native void btn_test2();

    private static native TestBean btn_test3(String s);

}