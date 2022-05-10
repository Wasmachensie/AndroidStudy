package com.example.mytoolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tb);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Arno", "onClick: toolbar被点击了");
            }
        });

        //在java中设置ToolBar
        Toolbar toolbar2 = findViewById(R.id.tb2);
        toolbar2.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24);
        toolbar2.setTitle("Toolbar2的标题");
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Arno", "onClick: toolbar2被点击了");
            }
        });
    }
}