package com.zw.android_flutter.activity.demo;

import android.os.AsyncTask;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class TestActivity extends AppCompatActivity {
    volatile int i = 0;

    @Override
    protected void onStart() {
        super.onStart();
        test();
    }

    private void test() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        transaction.add(fragment, "");
        transaction.commit();
        transaction.commitAllowingStateLoss();

        //Choreographer.getInstance().postFrameCallback();

        AsyncTask asyncTask;

        Handler handler = null;
        handler.sendEmptyMessage(1);

        ThreadPoolExecutor threadPoolExecutor = null;
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello");

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("", "");

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Hello", "World!");
    }
}