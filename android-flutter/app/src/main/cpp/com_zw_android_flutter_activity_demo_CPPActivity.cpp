#include "com_zw_android_flutter_activity_demo_CPPActivity.h"

#include <android/log.h>

#include <string>
#include <mutex>
#include <thread>

extern JavaVM *g_vm;
/**
 * std::lock_guard能实现的std::unique_lock都能实现
 *
 * std::unique_lock使用更加的灵活 功能更加丰富
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

/*
 * Class:     com_zw_android_flutter_activity_demo_CPPActivity
 * Method:    closure
 * Signature: ()V
 */
JNIEXPORT void JNICALL
Java_com_zw_android_1flutter_activity_demo_CPPActivity_closure(JNIEnv *env, jclass jclazz) {
    __android_log_print(ANDROID_LOG_INFO, "jni-log", "closure ......");
}

thread_local unsigned int rage = 1;
std::mutex cout_mutex;

void increase_rage(const std::string &thread_name) {
    ++rage; // 在锁外修改 OK ；这是线程局域变量
    std::lock_guard<std::mutex> lock(cout_mutex);
    __android_log_print(ANDROID_LOG_INFO, "jni-log", "Rage counter for %s", thread_name.c_str());
}

void test() {
    thread_local int i = 0;
    __android_log_print(ANDROID_LOG_INFO, "jni-log", "id=%d, n=%d\n", std::this_thread::get_id(),
                        i);
    i++;
}

void test2() {
    test();
    test();
}

void test3() {
    std::thread a(increase_rage, "a");
    std::thread b(increase_rage, "b");
    a.join();
    b.join();

    std::thread t1(test);
    std::thread t2(test);
    t1.join();
    t2.join();

    std::thread t3(test2);
    t3.join();
}

void test4() {
    rage++;
    __android_log_print(ANDROID_LOG_INFO, "jni-log", "id=%d, rage=%d\n", std::this_thread::get_id(),
                        rage);
}

std::thread thread;
/*
 * Class:     com_zw_android_flutter_activity_demo_CPPActivity
 * Method:    btn_test1
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_zw_android_1flutter_activity_demo_CPPActivity_btn_1test1
        (JNIEnv *env, jclass jclazz) {
    // test3();

    thread = std::thread(test4);
//    thread.join();
//    thread.detach();
//
//    std::thread thread1(test4);
//    thread1.detach();
}

/*
 * Class:     com_zw_android_flutter_activity_demo_CPPActivity
 * Method:    btn_test2
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_zw_android_1flutter_activity_demo_CPPActivity_btn_1test2
        (JNIEnv *env, jclass jclazz) {
    __android_log_print(ANDROID_LOG_INFO, "jni-log", "id=%d\n", std::this_thread::get_id());

    float f = 1.0f;
    int i = f;
}

void CPPActivity_demo_test_env() {
    JNIEnv *env = nullptr;
    int ret = g_vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6);
    __android_log_print(ANDROID_LOG_INFO, "jni-log", "demo_test_env=%d\n", ret);

    if (!ret) {
        // TODO 同一条线程可以共享 JNIEnv
    } else {
        // TODO 不在同一条线程里面 使用JNIEnv的方法
        // 连接一个Native创建的线程会触发构造一个java.lang.Thread对象，
        // 然后其被添加到主线程群组（main ThreadGroup）,以让调试器可以检测到。
        // 对一个已经连接的线程使用AttachCurrentThread不做任何操作（no-op）
        ret = g_vm->AttachCurrentThread(&env, nullptr);
        if (!ret) {
            __android_log_print(ANDROID_LOG_INFO, "jni-log", "AttachCurrentThread success ......");

        }
        g_vm->DetachCurrentThread();
    }
}


/*
 * Class:     com_zw_android_flutter_activity_demo_CPPActivity
 * Method:    btn_test3
 * Signature: (Ljava/lang/String;)Lcom/zw/android_flutter/bean/TestBean;
 */
JNIEXPORT jobject JNICALL Java_com_zw_android_1flutter_activity_demo_CPPActivity_btn_1test3
        (JNIEnv *env, jclass jclazz, jstring jstr) {
    const char *chs = env->GetStringUTFChars(jstr, nullptr);
    __android_log_print(ANDROID_LOG_INFO, "jni-log", "id=%d,jstr=%s\n",
                        std::this_thread::get_id(), chs);
    env->ReleaseStringUTFChars(jstr, chs);


    std::thread thread1(CPPActivity_demo_test_env);
    thread1.detach();

    return nullptr;
}

