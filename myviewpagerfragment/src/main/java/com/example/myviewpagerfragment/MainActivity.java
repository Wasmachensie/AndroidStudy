package com.example.myviewpagerfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    //创建ViewPage
    ViewPager2 viewPager2;
    private LinearLayout llchat,llcontact,llfind,llmy;
    //要加一个ivCurrent用于保存当前的画面
    private ImageView ivchat,ivcontact,ivfind,ivmy,ivCurrent;
    //通用的ToolBar标题
    private TextView title;
    //通用的ToolBar
    private Toolbar toolBar;
    //内容区域
    private RelativeLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //定义一个专门的方法，专门用于初始化ViewPage
        initViewPager();
        initTableView();
        //toolVBar
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    //初始化ViewPage
    private void initViewPager() {
        title = findViewById(R.id.title);
        toolBar = findViewById(R.id.toolbar);

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //获取ViewPage
        viewPager2 = findViewById(R.id.id_viewPager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("微信"));
        fragments.add(BlankFragment.newInstance("通讯录"));
        fragments.add(BlankFragment.newInstance("发现"));
        fragments.add(BlankFragment.newInstance("我"));
        MyFragmentAdapter pagerAdapter = new MyFragmentAdapter(getSupportFragmentManager(),
                getLifecycle(),fragments);
        //设置Adapter
        viewPager2.setAdapter(pagerAdapter);
        //设置ViewPage的切换监听
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeNavigation(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }


    private void changeNavigation(int position) {
        ivCurrent.setSelected(false);
        switch (position){
            case R.id.id_tab_weixin:
                viewPager2.setCurrentItem(0);
                title.setText("微信");

            case 0:
                ivchat.setSelected(true);
                ivCurrent = ivchat;
                title.setText("微信");
                toolBar.setVisibility(View.VISIBLE);
                break;
            case R.id.id_tab_contact:
                viewPager2.setCurrentItem(1);
                title.setText("通讯录");
            case 1:
                ivcontact.setSelected(true);
                ivCurrent = ivcontact;
                title.setText("通讯录");
                toolBar.setVisibility(View.VISIBLE);
                break;
            case R.id.id_tab_find:
                viewPager2.setCurrentItem(2);
                title.setText("发现");
            case 2:
                ivfind.setSelected(true);
                ivCurrent = ivfind;
                title.setText("发现");
                toolBar.setVisibility(View.VISIBLE);
                break;
            case R.id.id_tab_my:
                toolBar.setVisibility(View.GONE);
                    viewPager2.setCurrentItem(3);
            case 3:
                ivmy.setSelected(true);
                toolBar.setVisibility(View.GONE);
                ivCurrent = ivmy;
                break;
        }
    }

    private void initTableView() {
        llchat = findViewById(R.id.id_tab_weixin);
        llcontact = findViewById(R.id.id_tab_contact);
        llfind = findViewById(R.id.id_tab_find);
        llmy = findViewById(R.id.id_tab_my);

        ivchat = findViewById(R.id.id_iv_weixin);
        ivcontact = findViewById(R.id.id_iv_contact);
        ivfind = findViewById(R.id.id_iv_find);
        ivmy = findViewById(R.id.id_iv_my);

        llchat.setOnClickListener(this);
        llcontact.setOnClickListener(this);
        llfind.setOnClickListener(this);
        llmy.setOnClickListener(this);

        ivchat.setSelected(true);//刚进微信时图标是绿色的
        ivCurrent = ivchat;
    }

    //设置点击事件
    @Override
    public void onClick(View view) {
        changeNavigation(view.getId());
    }
}