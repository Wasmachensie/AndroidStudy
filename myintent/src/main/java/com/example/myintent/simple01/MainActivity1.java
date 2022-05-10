package com.example.myintent.simple01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myintent.R;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }
    //此函数目的是为了跳转到下一个界面
    public void startAction(View view) {
        //创建一个Intent对象,从这个(this),跳转到指定的(MainActivity3)
        Intent intent = new Intent(this, MainActivity3.class);
        //跳转到MainActivity2时携带数据
        //intent.putExtra()用来传参数
        intent.putExtra("name", "张三");
        intent.putExtra("sex", '男');
        //startActivity方法
        startActivity(intent);
    }
}