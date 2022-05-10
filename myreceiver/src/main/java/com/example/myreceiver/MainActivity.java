package com.example.myreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //第二部发送给接收者
    //静态发送广播 给 接收者
    public void sendAction(View view) {
        Intent intent = new Intent();
        //ActionUtils.ACTION_EQUES_UPDATE_IP 与注册时的Action一致
        intent.setAction(ActionUtils.ACTION_FLAG);
        sendBroadcast(intent);
    }

}