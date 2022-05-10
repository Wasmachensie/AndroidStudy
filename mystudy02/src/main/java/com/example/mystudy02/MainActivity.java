package com.example.mystudy02;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> data = new ArrayList<Bean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //模拟数据
        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean();
            bean.setName("name" + i);
            data.add(bean);
        }

        RecyclerView recyclerView = findViewById(R.id.rv);
        //设置LayoutManager，以LinearLayoutManager为例子进行线性布局
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //创建适配器
        MyAdapterRe adapterRe = new MyAdapterRe(data, this);
        //设置适配器
        recyclerView.setAdapter(adapterRe);
        //设置监听
        adapterRe.setRecyclerItemClickListener(new MyAdapterRe.onRecyclerItemClickListener() {
            @Override
            public void onRecyclerItemClick(int position) {
                Log.e("Arno", "onRecyclerItemClick: " + position);
            }
        });
    }







}