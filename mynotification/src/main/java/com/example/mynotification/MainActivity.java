package com.example.mynotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    private Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //版本判断
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //三个参数分别为ID,名字,重要度
            //String id,CharSequence name, int importance
            NotificationChannel channel = new NotificationChannel("Arno", "测试通知",
                    NotificationManager.IMPORTANCE_DEFAULT);
            //添加渠道
            manager.createNotificationChannel(channel);
        }

        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        notification = new NotificationCompat
                .Builder(this,"Arno")
                .setContentTitle("测试通知")//设置标题
                .setContentText("这是测试通知内容")//设置内容
                //设置小图标,注意通知栏图标不要带颜色
                .setSmallIcon(R.drawable.ic_baseline_android_24)
                //到上面已经可以了
                //设置大图标,Bitmap类型
                .setLargeIcon(BitmapFactory
                        .decodeResource(getResources(),R.drawable.ceshi1))
                //设置小图标颜色
                .setColor(Color.parseColor("#ff0000"))
                //设置点击通知后的跳转意图
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)//设置点击后取消通知,也可以通过点击触发
                //设置通知时间，一般不设置，默认为系统发出通知的时间
                //.setWhen()
                .build();
    }

    public void sendNotification(View view) {
        //发送通知 id int型就行，随便怎么写
        manager.notify(1,notification);
    }

    public void cancelNotification(View view) {
        //id要与上面的一致
        manager.cancel(1);
    }
}