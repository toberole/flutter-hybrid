package com.zw.android_flutter.activity.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zw.android_flutter.R;

public class CPPActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cppactivity);

        Button btn = findViewById(R.id.btn_lock);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_lock:
                lock();
                break;
        }
    }

    private static native void lock();
}