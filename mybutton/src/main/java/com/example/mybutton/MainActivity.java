package com.example.mybutton;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private static final String TGA = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        //点击事件
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TGA,"onClick:");
            }
        });*/
        //长按事件
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.e(TGA,"onLongClick:");
                return false;
            }
        });
        //触摸事件
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /*
                * event.getAction() 获得的返回值：
                * 触摸屏幕时刻
                * case MotionEvent.ACTION_DOWN:  // = 0
                * break;
                * //触摸并移动时刻
                * case MotionEvent.ACTION_MOVE:  // = 2
                * break;
                * 终止触摸时刻
                * case MotionEvent.ACTION_UP:  // = 1
                * break;*/
                Log.e(TGA,"onTouch:" + event.getAction());
                return false;
            }
        });
    }

    public void haha(View view) {
        Log.e(TGA,"onhahaClick:");
    }
}