package com.zw.android_flutter.test1;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityManagerCompat;

import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 死锁Demo
 */
public class Test7 {
    public static final String TAG = Test7.class.getSimpleName();

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    static {
        Log.i(TAG, "thread: " + Thread.currentThread().getName());
    }

    public static void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                test2();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test3();
            }
        }).start();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void test1() {
        ViewGroup viewGroup = null;
        viewGroup.requestLayout();
        viewGroup.invalidate();
        viewGroup.postInvalidate();

        LockSupport.park();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("Hello", "World!");
        Context context = null;
        @SuppressLint("ServiceCast") ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> infos = activityManager.getRunningTasks(20);

    }

    private static void test2() {
        Log.i(TAG, "test2 ......");
        synchronized (lock1) {
            try {
                boolean b = Thread.holdsLock(lock1);
                Log.i(TAG, "test2 b ......" + b);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock2) {
                Log.i(TAG, "lock2 ......");
            }
        }
    }

    private static void test3() {
        Log.i(TAG, "test3 ......");

        synchronized (lock2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock1) {
                Log.i(TAG, "lock1 ......");
            }
        }
    }
} 