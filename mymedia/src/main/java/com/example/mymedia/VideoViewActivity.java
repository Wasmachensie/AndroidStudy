package com.example.mymedia;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class VideoViewActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoView = findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        //控制 下一个按钮  监听器
        mediaController.setPrevNextListeners(this,this);
        videoView.setMediaController(mediaController);
        videoView.setVideoPath(new File(getExternalFilesDir(""),
                "video.mp4").getAbsolutePath());
        videoView.start();
    }

    @Override
    public void onClick(View view) {
        Log.e("VideoView","……");
    }
}