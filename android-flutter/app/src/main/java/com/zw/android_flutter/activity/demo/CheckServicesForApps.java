package com.zw.android_flutter.activity.demo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class CheckServicesForApps extends Service {
    public static final String TAG = CheckServicesForApps.class.getSimpleName();

    private WindowManager windowManager;
    private TextView imageView;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "CheckServicesForApps#onCreate ......");
        // showFloatView();
    }

    private void showFloatView() {
        imageView = new TextView(getApplicationContext());
        imageView.setVisibility(View.VISIBLE);
        imageView.setTextColor(Color.RED);
        imageView.setText("Hello Float View");

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

                params.x = ((getApplicationContext().getResources().getDisplayMetrics().widthPixels) / 2);
                params.y = ((getApplicationContext().getResources().getDisplayMetrics().heightPixels) / 2);

                windowManager.addView(imageView, params);
            } catch (Exception e) {
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
        Log.i(TAG, "CheckServicesForApps#onStartCommand ......");
        showFloatView();
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