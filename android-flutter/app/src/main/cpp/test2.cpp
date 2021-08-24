#include "test2.h"
#include <cstdlib>
#include <android/log.h>
#include <memory>
#include "Demo.h"

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

void test2_2() {
    std::shared_ptr<Demo> d = std::make_shared<Demo>(1);
    std::weak_ptr<Demo> wd = d;
    // 如果当前 weak_ptr 已经过期，
    // 则该函数会返回一个空的 shared_ptr 指针；
    // 反之，该函数返回一个和当前 weak_ptr 指向相同的 shared_ptr 指针,背引用对象计数+1。
    // TODO 使用lock是线程安全的 一般建议使用该方法
    std::shared_ptr<Demo> sd = wd.lock();
    if (sd) {
        // TODO
        sd->print();
    }

    // 判断当前 weak_ptr 指针为否过期（指针为空，或者指向的堆内存已经被释放）
    if (wd.expired()) {
        // TODO 非线程安全的 多线程情况下有可能expired判断可用，但是使用的却已经不可用了
        // 注意此时wd.lock()可能出问题
        std::shared_ptr<Demo> sd = wd.lock();

    }
}

