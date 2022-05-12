package com.example.mymedia;


import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

//视频录制
public class MediaRecordActivity extends AppCompatActivity implements View.OnClickListener {
    private TextureView textureView;
    private Button btnOpt;
    private MediaRecorder mediaRecorder;
    private Camera camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_record);
        textureView = findViewById(R.id.textureView);
        btnOpt = findViewById(R.id.btn_opt);
        btnOpt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        CharSequence text = btnOpt.getText();
        if (text.equals("开始")) {
            btnOpt.setText("结束");
            camera = Camera.open();
            Camera.Parameters parameters = camera.getParameters();
            parameters.setPreviewSize(1280, 720);
            camera.setDisplayOrientation(90);
            camera.unlock();
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setCamera(camera);
            //设置音频源   MIC表示麦克风
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            //设置视频源   CAMERA表示摄像头
            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
            //设置输出格式   mp4
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            //设置音频格式   aac
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            //设置视频格式   h264
            mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
            //设置视频角度
            mediaRecorder.setOrientationHint(90);
            //设置视频输出路径
            mediaRecorder.setOutputFile(new File(getExternalFilesDir(""),
                    "video.mp4").getAbsolutePath());
            //设置视频大小
            mediaRecorder.setVideoSize(1280, 720);
            //设置预览
            mediaRecorder.setPreviewDisplay(new Surface(textureView.getSurfaceTexture()));
            //进入录制状态
            try {
                mediaRecorder.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //开始录制
            mediaRecorder.start();
        } else {
            btnOpt.setText("开始");
            //停止录制
            mediaRecorder.stop();
            //释放资源
            mediaRecorder.release();
            camera.stopPreview();
            camera.release();
        }
    }
}