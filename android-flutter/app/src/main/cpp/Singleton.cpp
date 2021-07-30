#include "Singleton.h"
#include <mutex>

namespace {
    std::mutex mtx;
    Singleton *instance = nullptr;
}

/**
 * C++11 之前 static变量多线程会存在问题
 * @return
 */
Singleton *Singleton::getInstance() {
    if (instance == nullptr) {
        std::lock_guard<std::mutex> lockGuard(mtx);
        if (nullptr == instance) {
            static Singleton singleton;
            instance = &singleton;
        }
    }

    return instance;
}

/**
 * C++11 static变量多线程是安全的
 * @return
 */
Singleton *Singleton::getInstance_1() {
    static Singleton singleton;
    return &singleton;
}

void Singleton::printfInfo() {
    printf("Hello Singleton ......\n");
}
