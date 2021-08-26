#include "GVMHolder.h"

GVMHolder::GVMHolder() {

}

GVMHolder *GVMHolder::getInstance() {
    static GVMHolder gvmHolder;
    return &gvmHolder;
}

void GVMHolder::setJavaVM(JavaVM *_vm) {
    if (_vm != nullptr && _vm != vm) {
        vm = _vm;
    }
}

JavaVM *GVMHolder::getJavaVM() {
    return vm;
}