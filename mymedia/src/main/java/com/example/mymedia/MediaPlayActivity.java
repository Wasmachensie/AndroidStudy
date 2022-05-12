package com.example.mymedia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class MediaPlayActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private TextureView textureView;
    private Button btnOpt;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_play);
        textureView = findViewById(R.id.textureView);
        btnOpt = findViewById(R.id.btn_opt);
        btnOpt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        CharSequence text = btnOpt.getText();
        if (text.equals("播放")) {
            btnOpt.setText("结束");
            mediaPlayer = new MediaPlayer();
            //mediaPlayer.setDataSource(true);使音频循环播放
            //准备监听
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnCompletionListener(this);

            try {
                //设置播放源
                mediaPlayer.setDataSource(new File(getExternalFilesDir(""),
                        "video.mp4").getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //设置画布
            mediaPlayer.setSurface(new Surface(textureView.getSurfaceTexture()));
            //准备播放 异步准备
            mediaPlayer.prepareAsync();
        } else if (text.equals("结束")) {
            btnOpt.setText("播放");
            //结束播放
            mediaPlayer.stop();
            //释放资源
            mediaPlayer.release();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        //准备完成后开始播放
        mediaPlayer.start();
    }

    //监听是否已经播放完
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        btnOpt.setText("开始");
        mediaPlayer.release();
    }
}