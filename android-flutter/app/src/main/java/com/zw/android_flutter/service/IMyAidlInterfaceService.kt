package com.zw.android_flutter.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * in 表示数据只能由客户端流向服务端
 * out 表示数据只能由服务端流向客户端，
 * inout 则表示数据可以在服务端与客户端之间双向流通。
 * 其中的数据流向是针对在客户端中的那个传入方法的对象而言的。
 *
 * 对于in，服务端将会收到客户端对象的完整数据，但是客户端对象不会因为服务端对传参的修改而发生变动。类似的行为在Java中的表现是，
 * 在Java方法中，对传进来的参数进行了深复制，传进来的参数不会受到深复制后的对象的影响。这和in的行为有点类似。
 * 对于out，服务端将会收到客户端对象，该对象不为空，但是它里面的字段为空，但是在服务端对该对象作任何修改之后客户端的传参对象都会同步改动
 *
 * 对于inout ，服务端将会接收到客户端传来对象的完整信息，并且客户端将会同步服务端对该对象的任何变动。
 */
class IMyAidlInterfaceService : Service() {
    companion object {
        var TAG = IMyAidlInterfaceService::class.java.simpleName
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate ......")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand ......")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        Log.i(TAG, "onBind ......")
        return IMyAidlInterfaceImpl.getInstance()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }
}