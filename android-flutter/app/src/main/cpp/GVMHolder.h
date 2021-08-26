#ifndef ANDROID_FLUTTER_GVMHOLDER_H
#define ANDROID_FLUTTER_GVMHOLDER_H

#include <jni.h>

class GVMHolder {
private:
    JavaVM *vm;
private:
    GVMHolder();

public:
    static GVMHolder *getInstance();

    void setJavaVM(JavaVM *vm);

    JavaVM *getJavaVM();
};


#endif //ANDROID_FLUTTER_GVMHOLDER_H
