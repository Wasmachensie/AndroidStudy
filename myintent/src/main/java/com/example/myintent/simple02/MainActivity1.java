package com.example.myintent.simple02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myintent.R;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/06/17:09
 * @Description:
 */
public class MainActivity1 extends AppCompatActivity {
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    //创建一个按钮，点击按钮后跳转到MainActivity3
    public void startAction(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        //传递对象到MainActivity3
        Student student = new Student();
        student.name = "张三";
        student.age = 18;

        intent.putExtra("Student",student);
        startActivity(intent);
    }
}
