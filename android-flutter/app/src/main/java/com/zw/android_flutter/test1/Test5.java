package com.zw.android_flutter.test1;

import android.os.Handler;
import android.os.HandlerThread;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class Test5 {
    private void test1(){
        HandlerThread handlerThread = new HandlerThread("");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        handler.sendEmptyMessage(1);

        DexClassLoader dexClassLoader;
        PathClassLoader pathClassLoader;
    }
}
