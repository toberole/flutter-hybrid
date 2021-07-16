package com.zw.mylibrary.test1;

import android.os.Environment;
import android.util.Log;

import com.jakewharton.disklrucache.DiskLruCache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static final String TAG = Test1.class.getSimpleName();

    public void test1() {
        Log.i(TAG, "Test1 test1 ......");

        ArrayList<Object> list = new ArrayList<>();
        list.add(new Object());

        Set<String> set = new HashSet<>();
        set.add("Hello");

        Map<String, String> map = new HashMap<>();
        map.put("Hello", "World!");
    }

    public void test2() {
        try {
            DiskLruCache diskLruCache = DiskLruCache.open(Environment.getExternalStorageDirectory(),
                    1, 1, 100);
            diskLruCache.edit()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 