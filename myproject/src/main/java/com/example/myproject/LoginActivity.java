package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/09/11:06
 * @Description:
 * //跳转到注册界面
 *         //tv_toRegister = findViewById(R.id.tv_toRegister);
 *         //tv_toRegister.setOnClickListener(new View.OnClickListener() {
 *         //    @Override
 *         //    public void onClick(View v) {
 *         //        Intent intent = new Intent();
 *         //        intent.setClass(LoginActivity.this, RegisterActivity.class);
 *         //        startActivity(intent);
 *         //        finish();
 *         //    }
 *         //});
 *         ////登录按钮实现
 *         //btn_login = findViewById(R.id.btn_login);
 *         //btn_login.setOnClickListener(new View.OnClickListener() {
 *         //    @Override
 *         //    public void onClick(View view) {
 *         //        Intent intent = new Intent();
 *         //        intent.setClass(LoginActivity.this, MainActivity.class);
 *         //    }
 *         //});
 */
public class LoginActivity extends AppCompatActivity {
    private TextView tv_toRegister;
    private Button btn_login;
    private EditText et_phone_login,et_pwd_login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        et_phone_login = findViewById(R.id.et_phone_login);
        et_pwd_login = findViewById(R.id.et_pwd_login);
        tv_toRegister = findViewById(R.id.tv_toRegister);
        tv_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = et_phone_login.getText().toString();
                String pwd = et_pwd_login.getText().toString();

                if (TextUtils.equals(phone, "12345678909") && TextUtils.equals(pwd, "123")) {
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "手机号或密码输入错误", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


}
