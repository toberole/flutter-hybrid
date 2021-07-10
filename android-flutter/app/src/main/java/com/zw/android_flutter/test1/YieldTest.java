package com.zw.android_flutter.test1;

import android.util.Log;

public class YieldTest implements Runnable {
    public static final String TAG = YieldTest.class.getSimpleName();

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            Log.i(TAG, "thread name: " + Thread.currentThread().getName());
            Thread.yield();
        }
    }

    public static void test() {
        YieldTest yieldTest = new YieldTest();
        Thread thread1 = new Thread(yieldTest, "thread-one");
        Thread thread2 = new Thread(yieldTest, "thread-two");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}