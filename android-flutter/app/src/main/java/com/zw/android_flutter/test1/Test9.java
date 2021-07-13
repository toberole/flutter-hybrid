package com.zw.android_flutter.test1;

import android.util.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test9 {
    public static final String TAG = Test9.class.getSimpleName();

    private volatile static int i = 0;
    private volatile static int n = 0;

    private static final ReentrantLock reentrantLock = new ReentrantLock();
    private static final Condition condition1 = reentrantLock.newCondition();
    private static final Condition condition2 = reentrantLock.newCondition();

    public static void test1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run1 time: " + System.currentTimeMillis());
                try {
                    reentrantLock.lock();
                    while (i == 0) {
                        try {
                            condition1.await();
                            Log.i(TAG, "i: " + i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    Log.i(TAG, "run2 time: " + System.currentTimeMillis());
                    i = 1;
                    condition1.signalAll();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run3 time: " + System.currentTimeMillis());
                try {
                    reentrantLock.lock();
                    while (n == 0) {
                        try {
                            condition2.await();
                            Log.i(TAG, "n: " + n);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    Log.i(TAG, "run4 time: " + System.currentTimeMillis());
                    n = 1;
                    condition2.signalAll();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }).start();
    }
} 