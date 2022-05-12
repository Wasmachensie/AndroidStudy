package com.example.mymedia;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO}, 100);

    }
    //录制视频
    public void record(View view) {
        Intent intent = new Intent(this, MediaRecordActivity.class);
        startActivity(intent);

    }
    //播放视频
    public void playmedia(View view) {
        Intent intent = new Intent(this, MediaPlayActivity.class);
        startActivity(intent);
    }
    //播放音乐
    public void playvideo(View view) {
        startActivity(new Intent(this, VideoViewActivity.class));
    }
}