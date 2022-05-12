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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TGA = "ARNO";
    private Button btn_re_register;
    private EditText et_re_phone, et_re_password, et_re_repassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        et_re_phone = findViewById(R.id.et_re_phone);
        et_re_password = findViewById(R.id.et_re_password);
        et_re_repassword = findViewById(R.id.et_re_repassword);
        btn_re_register = findViewById(R.id.btn_re_register);
        btn_re_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String username = et_re_phone.getText().toString();
        String password = et_re_password.getText().toString();
        String repassword = et_re_repassword.getText().toString();
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
            Log.e(TGA,"ARNO" + call);
            call.enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                    if (response.body().getErrorCode() == 0) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<BaseResponse> call, Throwable t) {
                    Log.d("TTTT", t.getMessage());
                    Toast.makeText(RegisterActivity.this, "注册111失败", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}


    //@Override
    //public Call<BaseResponse> register(String username, String password, String repassword) throws IOException {
    //    //String account = et_re_phone.getText().toString();
    //    //String pwd = et_re_password.getText().toString();
    //    //String repwd = et_re_repassword.getText().toString();
    //
    //    Retrofit retrofit = new Retrofit.Builder()
    //            .baseUrl("http://www.wanandroid.com/")
    //            .addConverterFactory(GsonConverterFactory.create())
    //            .build();
    //    WanAndroidService2 service = retrofit.create(WanAndroidService2.class);
    //    Call<BaseResponse> call = service.register(username, password, repassword);
    //    Response<BaseResponse> response = call.execute();
    //    BaseResponse baseResponse = response.body();
    //
    //    return call;
    //}



