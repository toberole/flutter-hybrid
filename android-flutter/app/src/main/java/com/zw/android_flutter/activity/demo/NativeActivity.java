package com.zw.android_flutter.activity.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zw.android_flutter.R;

public class NativeActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = NativeActivity.class.getSimpleName() + "-xxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);

        Button btn = findViewById(R.id.btn_test1);
        btn.setOnClickListener(this);
        btn = findViewById(R.id.btn_test1_register);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test1:
                Log.i(TAG, "s: " + native_test1("Hello"));
                break;
            case R.id.btn_test1_register:
                native_test1_register(1, new Object(), "Hello Register");
                break;
            default:
                break;
        }
    }

    private static native String native_test1(String s);

    private static native String native_test1_register(int i, Object b, String s);

}