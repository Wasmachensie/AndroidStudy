package com.example.myrx.login;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myrx.R;
import com.example.myrx.login.bean.SuccessBean;
import com.example.myrx.login.core.DiyObserver;
import com.example.myrx.login.core.LoginEngine;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*
        * 需求
        * 登录成功，需要成功Bean
        * 登录失败，需要message
        * */
        //这一步返回的是起点
        LoginEngine.login("admin", "123456")
                .subscribe(new DiyObserver() {
                    @Override
                    public void success(SuccessBean successBean) {
                        Log.d("AAAO", "成功Bean:" + successBean.toString());
                    }
                    @Override
                    public void error(String message) {
                        Log.d("AAAB", "失败message:" + message);
                    }
                });
    }
}