package com.zw.android_flutter.test1;

import android.media.AudioTrack;
import android.util.Log;
import android.util.SparseArray;

public class Test11 {
    public static final String TAG = Test11.class.getSimpleName();

    public void test1() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        Object o = new Object();
        sparseArray.append(1, o);
        Log.i(TAG, "o: " + o);

        AudioTrack audioTrack;
    }
} 