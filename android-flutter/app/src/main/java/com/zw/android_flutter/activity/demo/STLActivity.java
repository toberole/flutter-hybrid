package com.zw.android_flutter.activity.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zw.android_flutter.R;

public class STLActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stlactivity);

        Button btn = findViewById(R.id.btn_map);
        btn.setOnClickListener(this);
        btn = findViewById(R.id.btn_vector_list);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_map:
                test_map();
                break;
            case R.id.btn_vector_list:
                test_btn_vector_list();
                break;

            default:

        }
    }

    private static native void test_btn_vector_list();

    private static native void test_map();
}