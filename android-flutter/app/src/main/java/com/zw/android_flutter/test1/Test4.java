package com.zw.android_flutter.test1;

import android.animation.IntEvaluator;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class Test4 {
    public void test() {
        try {
            Intent i = new Intent();
            Bundle extras = new Bundle();
            extras.putString("Hello", "World");
            i.putExtras(extras);

            FileOutputStream fileOutputStream = null;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(null);

            IntEvaluator intEvaluator = new IntEvaluator();
            intEvaluator.evaluate(0.5f, 1, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test1() {
        Context context = null;

        Looper.prepare();
        Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
            }
        };
        Looper.loop();
        Looper.myQueue();
        handler.post(null);

        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler(){
            @Override
            public boolean queueIdle() {
                return false;
            }
        });


        Message message = Message.obtain();
        // message.setAsynchronous(true);

        IntentService service;


        DexClassLoader dexClassLoader;
        PathClassLoader pathClassLoader;
    }

    public void test2() {
        ThreadLocal<String> local1 = new ThreadLocal<>();
        ThreadLocal<String> local2 = new ThreadLocal<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                local1.set("Hello");
                local2.set("World");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                local1.set("Hello");
                local2.set("World");
            }
        }).start();
    }

    private class MyLooperHandler implements Runnable {
        public final String TAG = MyLooperHandler.class.getSimpleName();

        private Handler mHandler;

        public void run() {
            Looper.prepare();
            mHandler = new Handler(Looper.myLooper()) {
                public void handleMessage(Message msg) {
                    Log.i(TAG, "handleMessage ......");
                }
            };
            Looper.loop();
        }
    }

    private void test3(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
    }
} 