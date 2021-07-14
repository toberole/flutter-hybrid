#include "com_zw_android_flutter_activity_demo_NativeActivity.h"

/*
 * Class:     com_zw_android_flutter_activity_demo_NativeActivity
 * Method:    native_test1
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring

JNICALL Java_com_zw_android_1flutter_activity_demo_NativeActivity_native_1test1
        (JNIEnv *env, jclass jclazz, jstring jstr) {
    const char *chs = env->GetStringUTFChars(jstr, 0);
    jstring ret = env->NewStringUTF("Hello Jni 计算机技术");
    env->ReleaseStringUTFChars(jstr, chs);

    jboolean jb = env->ExceptionCheck();
    if (jb) {
        env->ExceptionClear();
    }
    return ret;
}

