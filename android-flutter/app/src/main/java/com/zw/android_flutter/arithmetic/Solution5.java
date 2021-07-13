package com.zw.android_flutter.arithmetic;

public class Solution5 {
    public static int hammingWeight(int n) {
        if (n == 0) return 0;
        int i = 0;
        while (n / 2 != 0) {
            if (n % 2 == 1) i++;
            n = n / 2;
        }

        if (n % 2 == 1) i++;

        return i;
    }

    public int hammingWeight1(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static int hammingWeight3(int n) {
        int ret = 0;
        while (n != 0) {
            n = n & (n - 1);
            ret++;
        }

        return ret;
    }


}