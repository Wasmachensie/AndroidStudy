package com.example.myintent.simple01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myintent.R;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //接收携带来的数据
        //这里的intent等价于MainActivity1中的intent
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        char sex = intent.getCharExtra("sex", ' ');
        /*
         * Toast:是一个类，主要管理消息的提示。
         * makeText()，Toast的一个方法，用来显示信息，分别有三个参数。
         * 第一个参数：this，是上下文参数，指当前页面显示
         * 第二个参数：“string string string ”是你想要显示的内容，这个是随便定义的，显示你想要显示的内容。
         * 第三个参数：Toast.LENGTH_LONG，是你指你提示消息，显示的时间，这个是稍微长点儿，
         * 对应的另一个是ToastLENGTH_SHORT，这个时间短点儿，大概2秒钟。
         *
         * show()，表示显示这个Toast消息提醒，当程序运行到这里的时候，就会显示出来，
         * 如果不调用show()方法，这个Toast对象存在，但是并不会显示，所以一定不要忘记。
         * */
        Toast.makeText(this,"name：" + name + "sex：" + sex ,Toast.LENGTH_SHORT).show();
    }
}