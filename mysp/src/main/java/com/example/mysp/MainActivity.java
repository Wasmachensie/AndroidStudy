package com.example.mysp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    private EditText et_name;
    private EditText et_pwd;
    private CheckBox cb_Rpwd;
    private CheckBox cb_Rplogin;
    private Button btn_register;
    private Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取首选项sp
        //参数1：sp的名字  参数2：sp保存的模式： 常规(每次保存会更新) Context.MODE_PRIVATE / 追加Context.MODE_APPEND
        sp = getSharedPreferences("config", MODE_PRIVATE);
        initViews();

        //回显数据
        //第二次打开的时候，从sp中读取数据，进行画面同步
        boolean isRpwd = sp.getBoolean("isRpwd", false);//如果获取是空，就会返回默认值
        boolean autologin = sp.getBoolean("autologin", false);

        //记住密码  之前勾选了才会进到下面的判断
        if (isRpwd) {
            //获取sp中的用户名和密码，并保存到EditText中
            cb_Rpwd.setChecked(true);
            String name = sp.getString("name", "");
            String pwd = sp.getString("pwd", "");
            et_name.setText(name);
            et_pwd.setText(pwd);
            //还要打上勾
            cb_Rpwd.setChecked(true);
        }
        //自动登录  之前勾选了才会进到下面的判断
        if (autologin) {
            cb_Rplogin.setChecked(true);//打上勾
        }
    }

    //初始化
    private void initViews() {
        //找到控件
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
        cb_Rpwd = findViewById(R.id.cb_Rpwd);
        cb_Rplogin = findViewById(R.id.cb_Rplogin);
        btn_register = findViewById(R.id.btn_register);
        btn_login = findViewById(R.id.btn_login);

        //设置监听
        MyOnClickListener l = new MyOnClickListener();
        btn_register.setOnClickListener(l);
        btn_login.setOnClickListener(l);
    }

    public class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_register:
                    break;
                //登录按钮
                case R.id.btn_login:
                    //登陆操作
                    //获取用户名和密码
                    String name = et_name.getText().toString().trim();
                    String pwd = et_pwd.getText().toString().trim();

                    if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
                        //提示用户输入用户名和密码
                        Toast.makeText(MainActivity.this,
                                "用户名和密码不能为空",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        //记住密码  打勾没有
                        if (cb_Rpwd.isChecked()) {
                            //用户名和密码都要保存到sp中 同时记住密码的状态也要保存到sp中
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("name", name);
                            editor.putString("pwd", pwd);
                            editor.putBoolean("isRpwd", true);
                            editor.apply();
                        }
                        //自动登录  打勾没有
                        if (cb_Rplogin.isChecked()) {
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putBoolean("autologin", true);
                            editor.apply();
                        }
                    }
                    break;
            }
        }
    }
}