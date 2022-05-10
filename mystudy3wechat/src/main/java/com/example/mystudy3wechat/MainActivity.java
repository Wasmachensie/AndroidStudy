package com.example.mystudy3wechat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 vp = findViewById(R.id.viewpager);
        //Viewpager要使用，必须要设置adapter
        //创建一个适配器
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        vp.setAdapter(viewPagerAdapter);
    }
}