package com.zw.android_flutter.test1;

import android.util.LruCache;

import java.util.LinkedHashMap;

public class CacheDemo extends LinkedHashMap<String, String> {
    private LruCache<String, String> lruCache;

    private void test() {
        lruCache.put("", "");
    }

    CacheDemo(int initialCapacity,
              float loadFactor,
              boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Entry<String, String> eldest) {
        return super.removeEldestEntry(eldest);
    }
}