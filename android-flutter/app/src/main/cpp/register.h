#ifndef ANDROID_FLUTTER_REGISTER_H
#define ANDROID_FLUTTER_REGISTER_H
#include <jni.h>

jstring test_register1(void);

/*
 * Class:     com_zw_android_flutter_activity_demo_NativeActivity
 * Method:    native_test1_register
 * Signature: (ILjava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL native_1test1_1register
        (JNIEnv *, jclass, jint, jobject, jstring);

#endif
