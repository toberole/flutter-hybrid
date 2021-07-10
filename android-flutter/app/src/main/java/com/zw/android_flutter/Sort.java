package com.zw.android_flutter;

/**
 * 快速排序
 * 堆排序算
 * 归并排序
 * <p>
 * 二分查找算法
 * BFPRT(线性查找算法)
 * <p>
 * Dijkstra算法
 */
public class Sort {
    public static void quick_sort(int arr[]) {

    }

    public static String array2Str(Object[] objects) {
        if (objects == null || objects.length <= 0) return null;
        StringBuffer sb = new StringBuffer();
        for (Object o : objects) {
            sb.append(String.valueOf(o));
        }
        return sb.toString();
    }
} 