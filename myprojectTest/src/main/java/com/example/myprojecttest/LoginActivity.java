package com.example.myprojecttest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    //常量来保存  手机号  密码
    private final String SP_FILENAME = "data";//sp文件名
    private final String SP_ACCOUNT = "account";
    private final String SP_PASSWORD = "password";

    private TextView tv_toRegister;
    private Button btn_login;
    private EditText et_phone_login,et_pwd_login;


    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化控件
        initView();

    }

    private void initView() {
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        et_phone_login = findViewById(R.id.et_phone_login);
        et_pwd_login = findViewById(R.id.et_pwd_login);
        tv_toRegister = findViewById(R.id.tv_toRegister);
        tv_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }


    @Override
    public void onClick(View view) {
        //获取输入的账号和密码
        String phone = et_phone_login.getText().toString();
        String pwd = et_pwd_login.getText().toString();
        sp = getSharedPreferences(SP_FILENAME,MODE_PRIVATE);
        String account = sp.getString(SP_ACCOUNT,"");
        String password = sp.getString(SP_PASSWORD,"");

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!phone.equals(account) && !pwd.equals(password)){
            Log.i("LoginActivity","phone:"+phone+ "account:"+account);
            Toast.makeText(LoginActivity.this, "手机号或密码输入错误", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        //跳转到主界面
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        LoginActivity.this.finish();

    }
}



