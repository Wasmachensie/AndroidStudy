package com.example.myproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager2 viewPager2;

    private Button btn_tologin;
    private Button btn_toreg;
    private List<Fragment> fragments;
    //加一个ivCurrent用于保存当前的画面
    private ImageView ivCurrent;
    private LinearLayout lhome, lexhibition,lranking,lmine;
    private ImageView ivhome, ivexhibition, ivranking, ivmine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //btn_tologin = findViewById(R.id.btn_tologin);
        //btn_tologin.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        //        startActivity(intent);
        //
        //    }
        //});
        //
        //btn_toreg = findViewById(R.id.btn_toreg);
        //btn_toreg.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        //        startActivity(intent);
        //    }
        //});

        initTableView();
        //定义一个专门的方法，专门用于初始化ViewPage
        initViewPager();

    }

    private void initViewPager() {
        //获取ViewPage
        viewPager2 = findViewById(R.id.id_viewPager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ExhibitionFragment());
        fragments.add(new RankFragment());
        fragments.add(new MyFragment());
        MyFragmentAdapter pagerAdapter = new MyFragmentAdapter(getSupportFragmentManager(),
                getLifecycle(),fragments);

        //设置Adapter
        viewPager2.setAdapter(pagerAdapter);
        //设置ViewPage的切换监听
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixeli) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixeli);
            }
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                //changeNavigation(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void initTableView() {
        lhome = findViewById(R.id.id_tab_home);
        lexhibition = findViewById(R.id.id_tab_exhibition);
        lranking = findViewById(R.id.id_tab_rank);
        lmine = findViewById(R.id.id_tab_my);
        lhome.setOnClickListener(this);
        lexhibition.setOnClickListener(this);
        lranking.setOnClickListener(this);
        lmine.setOnClickListener(this);

        ivhome = findViewById(R.id.id_iv_home);
        ivexhibition = findViewById(R.id.id_iv_exhibition);
        ivranking = findViewById(R.id.id_iv_rank);
        ivmine = findViewById(R.id.id_iv_my);
        ivhome.setOnClickListener(this);
        ivexhibition.setOnClickListener(this);
        ivranking.setOnClickListener(this);
        ivmine.setOnClickListener(this);

        //刚进主页时图标是红色的
        ivmine.setSelected(true);
        ivCurrent = ivmine;
    }



    //设置点击事件
    @Override
    public void onClick(View view) {
        changeNavigation(view.getId());
    }

    private void changeNavigation(int position) {
        ivCurrent.setSelected(false);
        switch (position){

            case R.id.id_tab_home:
                viewPager2.setCurrentItem(0);
            case 0:
                ivhome.setSelected(true);
                ivCurrent = ivhome;
                break;

            case R.id.id_tab_exhibition:
                viewPager2.setCurrentItem(1);
            case 1:
                ivexhibition.setSelected(true);
                ivCurrent = ivexhibition;
                break;

            case R.id.id_tab_rank:
                viewPager2.setCurrentItem(2);
            case 2:
                ivranking.setSelected(true);
                ivCurrent = ivranking;
                break;

            case R.id.id_tab_my:
                viewPager2.setCurrentItem(3);
            case 3:
                ivmine.setSelected(true);
                ivCurrent = ivmine;
                break;
        }
    }


}