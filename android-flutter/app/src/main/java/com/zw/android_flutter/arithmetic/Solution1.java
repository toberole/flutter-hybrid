package com.zw.android_flutter.arithmetic;

import android.util.Log;

import com.zw.android_flutter.util.Util;

/**
 * 冒泡排序
 * <p>
 * 时间复杂度 n*n
 */
public class Solution1 {
    public static final String TAG = Solution1.class.getSimpleName();

    private static void bubbling(int arr[]) {
        if (null == arr) return;

        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            boolean b = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    b = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!b) break;
        }
    }

    public static void test() {
        System.out.println("Hello World");
        int arr[] = {5, 2, 1, 3, 4};
        Log.i(TAG, Util.arr2Str(arr));
        bubbling(arr);
        Log.i(TAG, Util.arr2Str(arr));
    }
} 