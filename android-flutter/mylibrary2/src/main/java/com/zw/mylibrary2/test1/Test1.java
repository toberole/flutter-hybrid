package com.zw.mylibrary2.test1;

import android.util.LruCache;

public class Test1 {
    public void test1() {
        LruCache<String, String> lruCache = new LruCache(100) {
            @Override
            protected int sizeOf(Object key, Object value) {
                return super.sizeOf(key, value);
            }

            @Override
            public void trimToSize(int maxSize) {
                super.trimToSize(maxSize);
            }
        };

        lruCache.put("", "");
    }
} 