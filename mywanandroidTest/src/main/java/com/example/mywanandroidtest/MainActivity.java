package com.example.mywanandroidtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mywanandroidtest.bean.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {

    private EditText etPhone, etPassword;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录 获取账号密码
                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();
                if (phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.wanandroid.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                WanAndroidService service = retrofit.create(WanAndroidService.class);
                Call<BaseResponse> call = service.login(phone, password);
                call.enqueue(new Callback<BaseResponse>() {
                    @Override
                    public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                        if (response.body().getErrorCode() == 0) {
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<BaseResponse> call, Throwable t) {
                        Log.d("YYYY",t.getMessage());
                        Toast.makeText(MainActivity.this, "登录111失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到注册页面
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }

    //@Override
    //public Call<BaseResponse> login(String username, String password) throws IOException {
    //    Retrofit retrofit = new Retrofit.Builder()
    //            .baseUrl("http://www.wanandroid.com/")
    //            .addConverterFactory(GsonConverterFactory.create())
    //            .build();
    //    WanAndroidService service = retrofit.create(WanAndroidService.class);
    //    Call<BaseResponse> call = service.login(username, password);
    //    Response<BaseResponse> response = call.execute();
    //    BaseResponse baseResponse = response.body();
    //    return call;
    //}
}




