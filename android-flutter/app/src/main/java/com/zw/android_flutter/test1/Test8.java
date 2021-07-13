package com.zw.android_flutter.test1;

import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Test8 {
    public static final String TAG = Test8.class.getSimpleName();
    public static int n = 0;

    public static void test4() {
        ReentrantLock reentrantLock = new ReentrantLock(false);
        reentrantLock.lock();
    }

    public static void test3() {
//        Object object = new Object();
//        object.notify();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Thread.yield();
//                Log.i(TAG, "test3 ......");
//            }
//        }).start();

        YieldTest.test();

    }

    public static void test1() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50; j++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        n++;
                    }
                }).start();
            }
        }

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "n: " + n);
    }

    public synchronized static void test2() {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, "1 ......");
                countDownLatch.countDown();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "2 ......");
                countDownLatch.countDown();
            }
        }).start();

        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Log.i(TAG, "3 ......");

    }
} 