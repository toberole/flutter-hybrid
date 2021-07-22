package com.zw.android_flutter.service;

import android.os.RemoteException;
import android.util.Log;

import com.zw.android_flutter.IMyAidlInterface;
import com.zw.android_flutter.Student;

public class IMyAidlInterfaceImpl extends IMyAidlInterface.Stub {
    public static final String TAG = IMyAidlInterfaceImpl.class.getSimpleName();

    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
        Log.i(TAG, "basicTypes ......");
    }

    @Override
    public void test1() throws RemoteException {
        Log.i(TAG, "test1 ......");
    }

    @Override
    public String test2() throws RemoteException {
        return "hello test2";
    }

    @Override
    public void test3(Student s) throws RemoteException {
        s.age = 11;
    }

    private static final IMyAidlInterfaceImpl ourInstance = new IMyAidlInterfaceImpl();

    public static IMyAidlInterfaceImpl getInstance() {
        return ourInstance;
    }

    private IMyAidlInterfaceImpl() {
    }
}
