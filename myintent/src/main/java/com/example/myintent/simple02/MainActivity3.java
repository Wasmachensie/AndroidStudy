package com.example.myintent.simple02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myintent.R;

import java.io.Serializable;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/06/17:09
 * @Description:
 */
public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        Serializable student = intent.getSerializableExtra("Student");
        Toast.makeText(this, student.toString(), Toast.LENGTH_SHORT).show();
    }
}
