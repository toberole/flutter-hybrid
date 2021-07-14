#include "register.h"
#include <android/log.h>

extern JavaVM *g_vm;

jstring test_register1(void) {
    __android_log_print(ANDROID_LOG_INFO, "hello-register", "log str%s", "123");

    JNIEnv *env = nullptr;
    g_vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6);
    jstring retStr = nullptr;
    if (nullptr != env) {
        retStr = env->NewStringUTF("Hello");
    }
    return retStr;
}

/*
 * Class:     com_zw_android_flutter_activity_demo_NativeActivity
 * Method:    native_test1_register
 * Signature: (ILjava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL native_1test1_1register
        (JNIEnv *env, jclass jclazz, jint ji, jobject jobj, jstring jstr) {
    return nullptr;
}