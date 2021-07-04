package com.zw.android_flutter.test1;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class Test6 {
    public static final String TAG = Test6.class.getSimpleName();

    public static void test1() {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        if (i1 == i2) {
            Log.i(TAG, "i1 == i2");
        } else {
            Log.i(TAG, "i1 != i2");
        }

        i1 = Integer.valueOf(1);
        i2 = Integer.valueOf(1);
        if (i1 == i2) {
            Log.i(TAG, "i1 == i2");
        } else {
            Log.i(TAG, "i1 != i2");
        }

        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("hello");
        local.get();

        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(10, 0.75f, true);
        map.put("hello1", "world1");
        map.put("hello2", "world1");

        Object o;
        Callable<String> callable = null;
        ThreadPoolExecutor threadPoolExecutor = null;
        Future<String> f = threadPoolExecutor.submit(callable);
        try {
            f.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FutureTask<String> futureTask = new FutureTask<>(callable);
        futureTask = new FutureTask<String>(new Runnable() {
            @Override
            public void run() {

            }
        }, "Hello");

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");

        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("hello");
        String s = copyOnWriteArrayList.get(0);
        System.out.println(s);
    }

    private class TT<T extends Test1> {
        public T getTT(T y) {
            return y;
        }
    }

    private void test2() {
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("Hello", "World!");
    }
} 