#include "com_zw_android_flutter_activity_demo_CPPActivity.h"

#include <android/log.h>

#include <mutex>
#include <thread>

/**
 * std::lock_guard能实现的std::unique_lock都能实现
 *
 * std::unique_lock使用更加的灵活
 */
namespace {
    int lock_i = 0;
    std::mutex mtx;
}

void lock_test1() {
    for (int i = 0; i < 100; ++i) {
        std::unique_lock<std::mutex> lock(mtx);
        //std::lock(lock);
        lock_i++;
    }
}

void lock_test2() {
    for (int i = 0; i < 100; ++i) {
        std::unique_lock<std::mutex> lock(mtx);
        //std::lock(lock);
        lock_i++;
    }
}
/*
 * Class:     com_zw_android_flutter_activity_demo_CPPActivity
 * Method:    lock
 * Signature: ()V
 */
JNIEXPORT void JNICALL
Java_com_zw_android_1flutter_activity_demo_CPPActivity_lock(JNIEnv *env, jclass jclazz) {
    std::thread task1(lock_test1);
    std::thread task2(lock_test2);

    task1.join();
    task2.join();

    __android_log_print(ANDROID_LOG_INFO, "jni-log", "lock_i: %d", lock_i);
}
