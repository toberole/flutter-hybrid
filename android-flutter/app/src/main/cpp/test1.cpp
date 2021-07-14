#include <jni.h>

void test1() {
    JNIEnv *env = nullptr;
    jobject jobj = nullptr;
    jweak weak_obj = env->NewWeakGlobalRef(jobj);
    // 判断weak reference 对象是否被回收了
    jboolean b = env->IsSameObject(weak_obj, nullptr);
    if (b) {
        // 对象已经被回收
    } else {
        // 没有 被回收
    }
}