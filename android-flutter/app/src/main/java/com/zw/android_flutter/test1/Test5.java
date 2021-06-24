package com.zw.android_flutter.test1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

import com.zw.android_flutter.R;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class Test5 {
    private void test1(){
        HandlerThread handlerThread = new HandlerThread("com.test.zw");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        handler.sendEmptyMessage(1);

        DexClassLoader dexClassLoader;
        PathClassLoader pathClassLoader;

        Intent intent = null;

    }

    private void test2(){
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
            NotificationManager manager = (NotificationManager)  context.getSystemService(
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
}
