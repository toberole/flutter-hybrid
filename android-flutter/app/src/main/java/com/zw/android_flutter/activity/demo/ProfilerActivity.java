package com.zw.android_flutter.activity.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.zw.android_flutter.R;

/**
 * Flame Chart 百分比使视图
 * <p>
 * Top Down/Bottom Up 排序视图
 * <p>
 * Flame Chart + Top Down 寻找耗时最长路径
 * <p>
 * Bottom Up 寻找性能最差方法
 */
public class ProfilerActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = ProfilerActivity.class.getSimpleName() + "-xxx";

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
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
        findViewById(R.id.btn_test1).setOnClickListener(this);
        test_leak();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Thread.dumpStack();
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test1:
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ProfilerActivity.this.test1();
                        ProfilerActivity.this.test2();
                    }
                });
                thread.setName("test-xxx");
                thread.start();
                break;
            default:
                break;
        }
    }

    private void test2() {
        try {
            Thread.sleep(1000 * 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i(TAG, "test2 ......");
    }

    private void test1() {
        try {
            Thread.sleep(1000 * 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i(TAG, "test1 ......");
    }

    private static native void test_leak();
}