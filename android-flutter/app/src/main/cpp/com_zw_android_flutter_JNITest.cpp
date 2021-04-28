#include "com_zw_android_flutter_JNITest.h"

/*
 * Class:     com_zw_android_flutter_JNITest
 * Method:    test1
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_zw_android_1flutter_JNITest_test1
(JNIEnv *env, jobject jobj, jlong jinstance){
    jclass jclazz = env->GetObjectClass(jobj);
    jmethodID method = env->GetMethodID(jclazz,"callback","(ILjava/lang/String;)V");
    jstring s = env->NewStringUTF("error msg");
    env->CallVoidMethod(jobj,method,110,s);

    // 检测jni方法是否发生异常
    if (env->ExceptionCheck()){
        env->ExceptionDescribe();
        env->ExceptionClear();
        env->ThrowNew(env->FindClass("java/lang/Exception"),"JNI抛出的异常！");
    }
}
