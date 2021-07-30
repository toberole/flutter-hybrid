package com.zw.android_flutter.test2;

import android.os.Looper;
import android.util.LruCache;
import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

public class Test1 {
    public static void test1() {

    }

    public void test() {
        Context context = null;
        Intent intent = new Intent();
        context.sendBroadcast(intent);


        HashMap<String, String> map = new HashMap<>();
        map.put("", "");
        RecyclerView recyclerView = null;

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