#include "test2.h"
#include <cstdlib>
#include <android/log.h>

int g_n = 0;

enum Test_Enum {
    n1 = 1, n2 = 2,
};

void test2_0() {
    Test_Enum anEnum(n1);
    __android_log_print(ANDROID_LOG_INFO, "test2", "anEnum: %d", anEnum);
}

void test2_1() {
    int arr[] = {1, 2, 3, 4};

    for (int i = 0; i < 4; i++) {
        __android_log_print(ANDROID_LOG_INFO, "test2", "v: %d", arr[i]);
    }

    int arr1[4];
    for (int i = 0; i < 4; ++i) {
        arr1[i] = i;
    }
}

