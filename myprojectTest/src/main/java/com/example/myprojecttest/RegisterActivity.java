package com.example.myprojecttest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myprojecttest.bean.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 注册界面
 */

/**
 * implements View.OnClickListener是实现界面上点击事件监听之意
 *
 * implements View.OnClickListener作用：
 * implements View.OnClickListener能够不用为每个界面上的点击控件都编写一个点击事件监听代码，
 * 简化了界面上点击控件的点击事件监听代码量。
 *
 * 二、implements View.OnClickListener咋么用？
 * 1、不使用implements View.OnClickListener的情况 ，
 * 需要为界面上每个点击控件分别编写一个设置点击事件监听方法setOnClickListener(this)
 * 和点击方法onClick(View v)。
 * 2、使用implements View.OnClickListener的情况，
 * 只编写一个设置点击事件监听方法setOnClickListener(this)和点击方法onClick(View v)即可。
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TGA = "ARNO";
    private EditText etPhone, etPwd, etPwdConfirm;
    private Button btn_register;
    //private SharedPreferences sp;
    ////常量来保存  手机号  密码
    //private final String SP_FILENAME = "data";//sp文件名
    //private final String SP_ACCOUNT = "account";
    //private final String SP_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化控件
        initView();
        //initData();
    }

    //private void initData() {
    //    sp = getSharedPreferences(SP_FILENAME,MODE_PRIVATE);
    //    String phone = sp.getString(SP_ACCOUNT,"");
    //    String pwd = sp.getString(SP_PASSWORD,"");
    //    etPhone.setText(phone);
    //    etPwd.setText(pwd);
    //}

    private void initView() {
        etPhone = findViewById(R.id.et_phone);
        etPwd = findViewById(R.id.et_pwd);
        etPwdConfirm = findViewById(R.id.et_pwd_confirm);
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String username = etPhone.getText().toString();
        String password = etPwd.getText().toString();
        String repassword = etPwdConfirm.getText().toString();
        if (username.equals("") || password.equals("") || repassword.equals("")) {
            Toast.makeText(this, "请输入完整信息", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(repassword)) {
            Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
        } else {
            //注册成功
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.wanandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            WanAndroidService2 service = retrofit.create(WanAndroidService2.class);
            Call<BaseResponse> call = service.register(username, password, repassword);
            Log.e(TGA, "ARNO" + call);
            call.enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                    if (response.body().getErrorCode() == 0) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, HomeFragment.class);
                        startActivity(intent);
                    } else {
                        Log.d(TGA, "ARNO" + response.body().toString());
                        Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                    Log.d("TTTT", t.getMessage());
                    Toast.makeText(RegisterActivity.this, "注册111失败", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

    //@Override
    //public void onClick(View view) {
    //    String phone = etPhone.getText().toString();
    //    String pwd = etPwd.getText().toString();
    //    String pwdConfirm = etPwdConfirm.getText().toString();
    //    if (phone.equals("") || pwd.equals("") || pwdConfirm.equals("")){
    //        Toast.makeText(this,"请输入完整信息",Toast.LENGTH_SHORT).show();
    //    } else if (!pwd.equals(pwdConfirm)){
    //        Toast.makeText(this,"两次密码输入不一致",Toast.LENGTH_SHORT).show();
    //    } else {
    //
    //    }
    //}


    //@Override
    //public void onClick(View view) {
    //    //检查手机号位数
    //    if (etPhone.getText().toString().length() !=11) {
    //        Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
    //        return;
    //    }
    //    //检查密码
    //    if (etPwd.getText().toString().length() < 6 || etPwd.getText().toString().length() > 24) {
    //        Toast.makeText(this, "请输入6-24位的密码", Toast.LENGTH_SHORT).show();
    //        return;
    //    } else if (!etPwd.getText().toString().equals(etPwdConfirm.getText().toString())) {
    //        Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
    //        return;
    //    }
    //    //保存用户名和密码
    //    sp = getSharedPreferences(SP_FILENAME,MODE_PRIVATE);
    //    SharedPreferences.Editor editor = sp.edit();
    //    editor.putString(SP_ACCOUNT, etPhone.getText().toString());
    //    editor.putString(SP_FILENAME, etPwd.getText().toString());
    //    editor.apply();
    //    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    //    //跳转到登录界面
    //    startActivity(new Intent(this, MainActivity.class));
    //    this.finish();
    //
    //}
