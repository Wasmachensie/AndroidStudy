package com.example.myanimation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ImageView imageView = findViewById(R.id.ani);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过加载XML文件来创建一个animation对象
//                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
//                imageView.startAnimation(animation);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                imageView.startAnimation(animation);
                Log.e("TAG", "onClick: 启动了动画");

            }
        });*/

        //
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        //加载时间
        valueAnimator.setDuration(3000);
        //设置更新监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                float value = (float) animator.getAnimatedValue();
                Log.e("Arno", "onAnimationUpdate: " + value);

            }
        });
        //启动动画
        valueAnimator.start();

    }
}