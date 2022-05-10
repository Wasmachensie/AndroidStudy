package com.example.myfragment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.btn1);
        Button button2 = findViewById(R.id.btn2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                Bundle bundle = new Bundle();
                bundle.putString("msg", "张三");
                BlankFragment1 bf1 = new BlankFragment1();
                bf1.setArguments(bundle);
                //匿名内部类
                bf1.setFragmentCallBack(new IFragmentCallBack() {
                    @Override
                    public void sendMsgToActivity(String msg) {
                    }
                    @Override
                    public String getMsgFromActivity() {
                        return null;
                    }
                } );
                replaceFragment(bf1);
                //replaceFragment(new BlankFragment1());
                break;
            case R.id.btn2:
                replaceFragment(new ItemFragment());
        }
    }

    //动态切换fragment
    private void replaceFragment(Fragment fragment) {
        // 获取FragmentManager对象
        FragmentManager fM = getSupportFragmentManager();
        // 获取FragmentManager事务对象
        FragmentTransaction transaction = fM.beginTransaction();
        transaction.replace(R.id.fragment1, fragment);
        //通过添加（事务处理的方式）将fragment加到对应的布局中
        transaction.addToBackStack(null);
        transaction.commit();//提交事务

        /*
         *事务：事务具有一致性，即，一般情况下，
         * 有十行代码依次执行，到第九行代码时出现错误，
         * 则前八行代码已执行并实现效果，如果这十行代码放入一个事务中，
         * 如果其中任意一行代码出现错误，则所有代码均不会执行或有实现效果
         * */
        /**
         * Fragment对象的add和replace的区别
         * 区别在于：是否先清空容器再添加新的Fragment对象。
         * add方法不会清空容器，直接在原Fragment对象上添加，所以常配合hide或remove一起使用，否则会出现Fragment重影。
         * remove方法先清空容器里的原来的Fragment对象，一般单独使用。
         *
         * 注意：
         * 1，在add时，同一个对象不允许重复添加，否则报错如下：
         *  Caused by: java.lang.IllegalStateException: Fragment already added: Title2Fragment{f90c487 #0 id=0x7f07003d}
         * 2，add和replace都会走一遍Fragment的生命周期。一般是使用add配合hide和show使用，减少内存消耗。
         */
    }
}
