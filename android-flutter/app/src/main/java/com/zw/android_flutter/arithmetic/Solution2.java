package com.zw.android_flutter.arithmetic;

import com.zw.android_flutter.util.Util;

/**
 * 从数组的左右两边界向中间进行遍历，定义两个指针 i 和 j，i 最开始指向数组的第一个元素，j 最开始指向数组的最后一个元素。
 * 指针 i 从左向右移动，指针 j 从右向左移动。先移动 j 指针（从右忘左移），当 j 指向的数大于基准数时，
 * 略过，j 继续往左移动，直到遇到小于等于基准数的数arr[j]，将arr[j]填入arr[i]中；再移动 i 指针，
 * 当 i 指向的数小于等于基准数时，略过，i 继续往右移动，直到遇到不比基准数小的数arr[i]，
 * 将arr[i]填入arr[j]中；再移动 i 指针，再移动 j 指针...(轮换移动)，直到 i 和 j 指针相遇，
 * 此时将temp（基准数）填入arr[i]中即完成算法的第2个步骤。
 * 接下来分别将基准数左边和右边的数组按照以上方法进行聚合，直到每个子集只有一个元素，即排序完成。
 */

/**
 * 快速排序时间复杂度 nlogn
 */
public class Solution2 {
    public static void quickSort(int[] arr, int begin, int end) {
        if (arr == null || arr.length < 2 || begin >= end) return;

        int temp = arr[begin]; //将区间的第一个数作为基准数
        int i = begin; //从左到右进行查找时的“指针”，指示当前左位置
        int j = end; //从右到左进行查找时的“指针”，指示当前右位置
        //不重复遍历
        while (i < j) {
            //当右边的数大于基准数时，略过，继续向左查找
            //不满足条件时跳出循环，此时的j对应的元素是小于基准元素的
            while (i < j && arr[j] > temp) j--;
            //将右边小于等于基准元素的数填入右边相应位置
            arr[i] = arr[j];
            //当左边的数小于等于基准数时，略过，继续向右查找
            //(重复的基准元素集合到左区间)
            //不满足条件时跳出循环，此时的i对应的元素是大于等于基准元素的
            while (i < j && arr[i] <= temp) i++;
            //将左边大于基准元素的数填入左边相应位置
            arr[j] = arr[i];
        }
        //将基准元素填入相应位置
        arr[i] = temp;
        //此时的i即为基准元素的位置
        //对基准元素的左边子区间进行相似的快速排序
        quickSort(arr, begin, i - 1);
        //对基准元素的右边子区间进行相似的快速排序
        quickSort(arr, i + 1, end);

    }

    public static void test() {
        Util.printArr(Data.arr);
        quickSort(Data.arr, 0, Data.arr.length - 1);
        Util.printArr(Data.arr);
    }
} 