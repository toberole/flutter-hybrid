package com.zw.android_flutter.test1;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class Test2 {
    public void test1() {
        Object o = new Object();
        PhantomReference<Object> po = new PhantomReference<>(o, new ReferenceQueue<>());
    }
} 