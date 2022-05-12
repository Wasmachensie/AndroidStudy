package com.example.myprojecttest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myprojecttest.bean.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity  {

    ////常量来保存  手机号  密码
    //private final String SP_FILENAME = "data";//sp文件名
    //private final String SP_ACCOUNT = "account";
    //private final String SP_PASSWORD = "password";
    //private SharedPreferences sp;

    private TextView tv_toRegister;
    private Button btn_login;
    private EditText et_phone_login, et_pwd_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化控件
        initView();
    }

    private void initView() {
        et_phone_login = findViewById(R.id.et_phone_login);
        et_pwd_login = findViewById(R.id.et_pwd_login);
        tv_toRegister = findViewById(R.id.tv_toRegister);
        tv_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录 获取账号密码
                String phone = et_phone_login.getText().toString();
                String password = et_pwd_login.getText().toString();

                if (phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
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
                    public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                        if (response.body().getErrorCode() == 0) {
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Log.d("QQQQ", response.body().toString());
                            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                        Log.d("YYYY", t.getMessage());
                        Toast.makeText(LoginActivity.this, "登录111失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}




    //@Override
    //public void onClick(View view) {
    //    //获取输入的账号和密码
    //    String phone = et_phone_login.getText().toString();
    //    String pwd = et_pwd_login.getText().toString();
    //    sp = getSharedPreferences(SP_FILENAME,MODE_PRIVATE);
    //    String account = sp.getString(SP_ACCOUNT,"");
    //    String password = sp.getString(SP_PASSWORD,"");
    //
    //    if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)) {
    //        Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
    //        return;
    //    }
    //    if(!phone.equals(account) && !pwd.equals(password)){
    //        Log.i("LoginActivity","phone:"+phone+ "account:"+account);
    //        Toast.makeText(LoginActivity.this, "手机号或密码输入错误", Toast.LENGTH_SHORT).show();
    //        return;
    //    }
    //    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
    //    //跳转到主界面
    //    startActivity(new Intent(LoginActivity.this,MainActivity.class));
    //    LoginActivity.this.finish();
    //
    //}




