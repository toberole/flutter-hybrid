#include <jni.h>
#include <string>
#include "register.h"

JavaVM *g_vm;

static JNINativeMethod method[] = {
        {
                "native_test1_register",
                "(ILjava/lang/Object;Ljava/lang/String;)Ljava/lang/String;",
                (void *) test_register1/* 注意签名和返回值 最好是一致 返回值不一致会导致各种不可控制的异常 */
        },
};

jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    g_vm = vm;

    JNIEnv *env = nullptr;
    vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6);
    if (env != nullptr) {
        jclass jclazz = env->FindClass("com/zw/android_flutter/activity/demo/NativeActivity");
        env->RegisterNatives(jclazz, method, 1);
    }
    return JNI_VERSION_1_6;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_zw_android_1flutter_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}