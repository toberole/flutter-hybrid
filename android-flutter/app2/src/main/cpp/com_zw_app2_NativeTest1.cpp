#include "com_zw_app2_NativeTest1.h"
#include <android/log.h>

/*
 * Class:     com_zw_app2_NativeTest1
 * Method:    test1
 * Signature: ()V
 */
JNIEXPORT void JNICALL
Java_com_zw_app2_NativeTest1_test1
        (JNIEnv *env, jclass jclazz) {
    int i = 0;
    auto f = [=]() {
        __android_log_print(ANDROID_LOG_INFO, "jni-log", "i: %d", i);
    };

    f();
}
