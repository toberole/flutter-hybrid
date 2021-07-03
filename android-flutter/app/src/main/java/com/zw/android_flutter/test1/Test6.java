package com.zw.android_flutter.test1;

import android.util.Log;

import java.util.LinkedHashMap;

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

        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(10, 0.75, tr)
        map.put("hello1", "world1");
        map.put("hello2", "world1");

    }

    private class TT<T extends Test1> {
        public T getTT(T y) {
            return y;
        }
    }
} 