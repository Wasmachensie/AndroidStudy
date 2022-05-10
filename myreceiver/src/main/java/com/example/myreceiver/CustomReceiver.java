package com.example.myreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/05/9:42
 * @Description:
 * 广播接收者
 */
public class CustomReceiver extends BroadcastReceiver {
    private static final String TGA = CustomReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TGA,"CustomReceive onReceive 广播接收者");

    }
}
