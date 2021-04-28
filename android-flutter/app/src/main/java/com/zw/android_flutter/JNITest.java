package com.zw.android_flutter;

import android.util.Log;

public class JNITest {
    static {
        System.loadLibrary("native-lib");
    }

    private long instance;

    public static final String TAG = JNITest.class.getSimpleName();

    public void callback(int errorCode, String errorMsg) {
        Log.i(TAG, "errorCode: " + errorCode + ",errorMsg: " + errorMsg);
        // int i = 1/0;
    }

    public native void test1(long instance);

    public native void callback1(int errorCode, String errorMsg);
} 