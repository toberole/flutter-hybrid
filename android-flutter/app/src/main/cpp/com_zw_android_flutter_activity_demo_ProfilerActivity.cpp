#include "com_zw_android_flutter_activity_demo_ProfilerActivity.h"
#include <string>

/*
 * Class:     com_zw_android_flutter_activity_demo_ProfilerActivity
 * Method:    test_leak
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_zw_android_1flutter_activity_demo_ProfilerActivity_test_1leak
        (JNIEnv *env, jclass jclazz) {
    char *chs = static_cast<char *>(malloc(sizeof(char) * 1024 * 1024 * 2));
}