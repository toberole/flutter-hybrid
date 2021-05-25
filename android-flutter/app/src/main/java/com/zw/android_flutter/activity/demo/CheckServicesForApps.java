package com.zw.android_flutter.activity.demo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class CheckServicesForApps extends Service {
    private Context context = null;
    private WindowManager windowManager;
    private Handler hand;
    private ImageView imageView;

    @Override
    public void onCreate() {
        super.onCreate();
        imageView = new ImageView(context);
        imageView.setVisibility(View.GONE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

                //here is all the science of params
                final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                        PixelFormat.TRANSLUCENT
                );

                windowManager.addView(imageView, params);
                hand = new Handler();

            } catch (Exception e) {
                hand = new Handler();
                e.printStackTrace();
            }
        } else {
            windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

            final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);

            params.gravity = Gravity.TOP | Gravity.CENTER;
            params.x = ((getApplicationContext().getResources().getDisplayMetrics().widthPixels) / 2);
            params.y = ((getApplicationContext().getResources().getDisplayMetrics().heightPixels) / 2);
            windowManager.addView(imageView, params);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        /* We want this service to continue running until it is explicitly
         * stopped, so return sticky.
         */
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (imageView != null) {
            try {
                windowManager.removeView(imageView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /**** added to fix the bug of view not attached to window manager ****/
    }
}