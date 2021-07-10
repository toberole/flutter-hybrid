package com.zw.android_flutter.util;

import android.util.Log;

public class Util {
    public static final String TAG = Util.class.getSimpleName() + "-xxx";

    public static void printArr(int arr[]) {
        StringBuffer sb = new StringBuffer();
        for (int i : arr) {
            sb.append(String.valueOf(i));
        }
        Log.i(TAG, "arr: " + sb);
    }

    public static String arr2Str(int arr[]) {
        StringBuffer sb = new StringBuffer();
        for (int i : arr) {
            sb.append(String.valueOf(i));
        }
        return sb.toString();
    }
} 