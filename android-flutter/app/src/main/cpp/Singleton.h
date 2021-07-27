#ifndef ANDROID_FLUTTER_SINGLETON_H
#define ANDROID_FLUTTER_SINGLETON_H

#include <stdio.h>

class Singleton {
private:
    Singleton() = default;

public:
    static Singleton *getInstance();

    static Singleton *getInstance_1();

    void printfInfo();
};


#endif //ANDROID_FLUTTER_SINGLETON_H
