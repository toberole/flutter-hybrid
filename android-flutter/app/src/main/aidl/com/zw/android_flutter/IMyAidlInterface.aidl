// IMyAidlInterface.aidl
package com.zw.android_flutter;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean,
        float aFloat,double aDouble, String aString);

        void test1();
        String test2();
}