package com.zw.android_flutter.activity.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zw.android_flutter.R;
import com.zw.android_flutter.Sort;

public class SortActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        Button btn_quick_sort = findViewById(R.id.btn_quick_sort);
        btn_quick_sort.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_quick_sort:
                int arr[] = {};
                Sort.quick_sort(arr);
                break;
            default:
                break;
        }
    }
}