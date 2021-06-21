package com.zw.android_flutter.service;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;

import androidx.annotation.Nullable;

public class TestIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TestIntentService(String name) {
        super(name);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        int ret = START_REDELIVER_INTENT;
        /**
         * START_NOT_STICKY，表示当Service运行的进程被Android系统强制杀掉之后，
         * 不会重新创建该Service，当然如果在其被杀掉之后一段时间又调用了startService，
         * 那么该Service又将被实例化
         */
        ret = START_NOT_STICKY;
        /**
         * 表示Service运行的进程被Android系统强制杀掉之后，Android系统会将该Service依然设置为started状态（即运行状态），
         * 但是不再保存onStartCommand方法传入的intent对象，然后Android系统会尝试再次重新创建该Service，
         * 并执行onStartCommand回调方法，但是onStartCommand回调方法的Intent参数为null，
         * 也就是onStartCommand方法虽然会执行但是获取不到intent信息。
         */
        ret = START_STICKY;

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        return super.startForegroundService(service);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}