package com.zw.android_flutter.activity.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;

import com.zw.android_flutter.R;

public class ProfilerActivity extends AppCompatActivity {
    public static final String TAG = ProfilerActivity.class.getSimpleName() + "-xxx";

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.i(TAG, "handleMessage ......");
            handler.sendEmptyMessageDelayed(110, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiler);
        handler.sendEmptyMessage(110);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Thread.dumpStack();
        return super.dispatchTouchEvent(ev);
    }
}