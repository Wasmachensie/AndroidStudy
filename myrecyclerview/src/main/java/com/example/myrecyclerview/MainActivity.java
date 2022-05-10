package com.example.myrecyclerview;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
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


        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean();
            bean.setName("name" + i);
            data.add(bean);
        }

            RecyclerView recyclerView = findViewById(R.id.rv);
            //设置RecyclerView的布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            //网格布局，一行显示3个
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//            recyclerView.setLayoutManager(gridLayoutManager);

            //瀑布流布局，一行显示3个
//            StaggeredGridLayoutManager staggeredGridLayoutManager =
//                    new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
//            recyclerView.setLayoutManager(staggeredGridLayoutManager);

            MyAdapter myAdapter = new MyAdapter(data,this);
            recyclerView.setAdapter(myAdapter);

            myAdapter.setRecyclerItemClickListener(new MyAdapter.onRecyclerItemClickListener() {

                @Override
                public void onRecyclerItemClick(int position) {
                    Log.e("Arno", "onRecyclerItemClick: " + position);
                }
            });
    }
}