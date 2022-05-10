package com.example.derry;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/05/9:17
 * @Description:
 */
public class MyService extends Service {

    private static final String TGA = MyService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TGA,"onCreate……");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TGA,"onStart……");
    }

    //代替上面的onStart()方法
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TGA,"onStartCommand……");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TGA,"onDestroy……");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TGA,"onBind……");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TGA,"onUnbind……");
        return super.onUnbind(intent);
    }
}
