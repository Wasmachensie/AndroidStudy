package com.example.myprogressbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.pb);
        progressBar2 = findViewById(R.id.pb2);
    }

    /*
    * android:visibility进行指定，
    * 可选值有3种：visible可见、invisible透明和gone不可见。
    *
    * Java代码中setVisibility()方法，
    * 可以传入View.VISIBLE、View.INVISIBLE和View.GONE这3种值。*/

    /*
    * View是Android中所有控件的基类，
    * 不管是简单的Button和TextView还是复杂的RelativeLayout和ListView,
    * 它们的共同基类都是View。*/
    public void ArnoClick(View view) {
        /*
        * 通过getVisibility()方法来判断ProgressBar 是否可见，
        * 如果可见就将ProgressBar 隐藏掉，
        * 如果不可见就将ProgressBar 显示出来。*/
        if (progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.INVISIBLE);
            Log.e("ArnoClick", "隐藏" + "INVISIBLE");
        } else {
            progressBar.setVisibility(View.VISIBLE);
            Log.e("ArnoClick", "可见" + "VISIBLE");
        }
    }

    public void Download(View view) {

        //通过getProgress()方法来获取ProgressBar 的当前进度
        int progress = progressBar2.getProgress();
        progress += 10;
        //通过setProgress()方法来设置ProgressBar的当前进度
        progressBar2.setProgress(progress);
        if (progress <= 100) {
            Log.e("Download", "下载" + progress);
        } else if (progress > 100){
            Log.e("Download", "下载已完成" );
        } else {
            Log.e("Download", "下载出现异常" );
        }

    }

}