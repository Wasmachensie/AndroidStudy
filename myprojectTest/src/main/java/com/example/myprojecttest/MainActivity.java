package com.example.myprojecttest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout lhome, lexhibition,lranking,lmine;
    private ImageView ivhome, ivexhibition, ivranking, ivmine;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }


    private void initEvent() {
        //添加Fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        TestNavFragment textNavFragment = TestNavFragment.newInstance("首页","");
        fragmentTransaction.replace(R.id.fg_container,textNavFragment).commit();
        //每点击一个按钮就要更换Fragment
        lhome.setOnClickListener(this);
        lexhibition.setOnClickListener(this);
        lranking.setOnClickListener(this);
        lmine.setOnClickListener(this);

    }
    private void initView() {
        lhome = findViewById(R.id.id_tab_home);
        lexhibition = findViewById(R.id.id_tab_exhibition);
        lranking = findViewById(R.id.id_tab_rank);
        lmine = findViewById(R.id.id_tab_my);

        ivhome = findViewById(R.id.id_iv_home);
        ivexhibition = findViewById(R.id.id_iv_exhibition);
        ivranking = findViewById(R.id.id_iv_rank);
        ivmine = findViewById(R.id.id_iv_my);
    }

    private void resetNavigation() {
        ivhome.setSelected(false);
        ivexhibition.setSelected(false);
        ivranking.setSelected(false);
        ivmine.setSelected(false);
    }

    @Override
    public void onClick(View view) {
        //通过id来判断点击的是哪个按钮
        int id = view.getId();
        //重置导航栏颜色
        resetNavigation();
        switch (id) {
            case R.id.id_tab_home:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fg_container,homeFragment).commit();
                ivhome.setSelected(true);
                break;

            case R.id.id_tab_exhibition:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ExhibitionFragment exhibitionFragment = new ExhibitionFragment();
                fragmentTransaction.replace(R.id.fg_container,exhibitionFragment).commit();
                ivexhibition.setSelected(true);
                break;

            case R.id.id_tab_rank:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                RankFragment rankFragment = new RankFragment();
                fragmentTransaction.replace(R.id.fg_container,rankFragment).commit();
                ivranking.setSelected(true);
                break;

            case R.id.id_tab_my:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                MyFragment myFragment = new MyFragment();
                fragmentTransaction.replace(R.id.fg_container,myFragment).commit();
                ivmine.setSelected(true);
                break;
            default:
                break;
        }

    }
}
