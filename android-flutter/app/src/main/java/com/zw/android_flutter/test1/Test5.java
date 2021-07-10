package com.zw.android_flutter.test1;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.zw.android_flutter.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class Test5 {
    private void test3() {
        ConstraintLayout constraintLayout = null;
    }

    private void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        HandlerThread handlerThread = new HandlerThread("com.test.zw");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        handler.sendEmptyMessage(1);

        DexClassLoader dexClassLoader;
        PathClassLoader pathClassLoader;

        Intent intent = null;

        Activity activity = null;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });

        View v = null;
        v.post(new Runnable() {
            @Override
            public void run() {

            }
        });

        View.OnTouchListener onTouchListener;

        Context context = null;
//        context.getContentResolver().update()

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
        // myAsyncTask.executeOnExecutor()

        Looper.myLooper();
        Looper.prepare();
        Looper.loop();
        Handler handler1 = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
            }
        };
        handler.post(null);
        Message message = Message.obtain();
        //


    }

    private void test2() {
//        Context context = null;
//        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
//            context.startForegroundService(new Intent(this, null));
//        }else {
//            context.startService(new Intent(this, BottomBarService.class));
//        }
    }

    private void startNotificationForeground(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String CHANNEL_ID = "NFCService";
            NotificationManager manager = (NotificationManager) context.getSystemService(
                    Context.NOTIFICATION_SERVICE);
            NotificationChannel Channel = new NotificationChannel(CHANNEL_ID, "主服务", NotificationManager.IMPORTANCE_HIGH);
            Channel.enableLights(true);//设置提示灯
            Channel.setLightColor(Color.RED);//设置提示灯颜色
            Channel.setShowBadge(true);//显示logo
            Channel.setDescription("bottombar notification");//设置描述
            Channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC); //设置锁屏可见 VISIBILITY_PUBLIC=可见
            if (manager != null) {
                manager.createNotificationChannel(Channel);
            }

            Notification notification = new Notification.Builder(context)
                    .setChannelId(CHANNEL_ID)
                    .setAutoCancel(false)
                    .setContentTitle("主服务")//标题
                    .setContentText("运行中...")//内容
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ic_launcher)//小图标一定需要设置,否则会报错(如果不设置它启动服务前台化不会报错,但是你会发现这个通知不会启动),如果是普通通知,不设置必然报错
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                    .build();
            // context.startForeground(1, notification);//服务前台化只能使用startForeground()方法,不能使用 notificationManager.notify(1,notification); 这个只是启动通知使用的,使用这个方法你只需要等待几秒就会发现报错了
        }
    }

    class MyAsyncTask extends AsyncTask<String, Integer, String> {
        public MyAsyncTask() {
            super();
        }

        @Override
        protected void onPreExecute() {// MainThread
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);// MainThread
        }

        @Override
        protected String doInBackground(String... strings) {// WorkerThread
            return null;
        }

        @Override
        protected void onPostExecute(String s) {// MainThread
            super.onPostExecute(s);
        }

        @Override
        protected void onCancelled() {// MainThread
            super.onCancelled();
        }
    }
}
