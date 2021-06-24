package com.zw.android_flutter.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ExampleService extends Service {
    private int mStartMode;       // 标识服务被杀死后的处理方式
    private IBinder mBinder;      // 用于客户端绑定的接口
    private boolean mAllowRebind; // 标识是否使用onRebind

    @Override
    public void onCreate() {
        // 服务正被创建
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 服务正在启动，由startService()调用引发
        return mStartMode;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // 客户端用bindService()绑定服务
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        // 所有的客户端都用unbindService()解除了绑定
        return mAllowRebind;
    }

    @Override
    public void onRebind(Intent intent) {
        // 某客户端正用bindService()绑定到服务,
        // 而onUnbind()已经被调用过了
    }

    @Override
    public void onDestroy() {
        // 服务用不上了，将被销毁
    }
}
