package com.zw.android_flutter.activity.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zw.android_flutter.R;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskActivity extends AppCompatActivity implements View.OnClickListener {
    private static ThreadPoolExecutor poolExecutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        poolExecutor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        Button btn = findViewById(R.id.btn1);
        btn.setOnClickListener(this);

        btn = findViewById(R.id.btn2);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                Callable callable = new Callable() {
                    @Override
                    public Object call() throws Exception {
                        Log.i("task-xxx", "call() ......");
                        return "";
                    }
                };

                FutureTask<Object> futureTask = new FutureTask<Object>(callable) {
                    @Override
                    protected void done() {
                        super.done();
                        Log.i("task-xxx", "done() ......");
                    }
                };

                // call ---> done
                poolExecutor.execute(futureTask);
                poolExecutor.submit(callable);
                break;
            default:
                break;
        }
    }
}