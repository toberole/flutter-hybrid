package com.zw.android_flutter.test1;

import android.util.SparseArray;

public class Test10 {
    public void test() {
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.append(1, "Hello");
        sparseArray.delete(1);

    }
} 