package com.example.mystudy2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> data = new ArrayList<Bean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater If = getLayoutInflater().from(this);
        //进行渲染
        View view1 = If.inflate(R.layout.layout1, null);
        View view2 = If.inflate(R.layout.layout2, null);
        View view3 = If.inflate(R.layout.layout3, null);
        View view4 = If.inflate(R.layout.layout4, null);
        //添加到集合中
        List<View> viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        //获取viewPage
        ViewPager viewPage = findViewById(R.id.vp);
        //获取适配器，布局填充
        MyAdapter myAdapter = new MyAdapter(viewList);
        //设置适配器
        viewPage.setAdapter(myAdapter);


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