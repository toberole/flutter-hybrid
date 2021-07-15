package com.zw.android_flutter.test2;

import android.os.Looper;
import android.util.LruCache;

public class Test1 {
    public void test() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Hello");
        String s = threadLocal.get();

        Looper.prepare();

        LruCache<String, String> lrucache = new LruCache<String, String>(100) {
            @Override
            protected int sizeOf(String key, String value) {
                return super.sizeOf(key, value);
            }

            @Override
            protected void entryRemoved(boolean evicted, String key, String oldValue, String newValue) {
                super.entryRemoved(evicted, key, oldValue, newValue);
            }
        };
        lrucache.put("Hello", "World!");

    }
}
