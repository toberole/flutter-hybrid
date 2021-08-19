package com.zw.app2;

import android.app.Application;

public class App extends Application {
    static {
        System.loadLibrary("app2-lib");


    }
}
