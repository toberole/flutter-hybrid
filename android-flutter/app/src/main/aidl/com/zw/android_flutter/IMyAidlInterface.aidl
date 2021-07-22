// IMyAidlInterface.aidl
package com.zw.android_flutter;

import com.zw.android_flutter.Student;

interface IMyAidlInterface {
    void basicTypes(
        int anInt, long aLong,
        boolean aBoolean,float aFloat,
        double aDouble, String aString
    );

    void test1();

    String test2();

    void test3(out Student s);
}