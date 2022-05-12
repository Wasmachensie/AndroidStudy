package com.example.myproject2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject2.bean.ResponseResult;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 注册界面
 */

/**
 * implements View.OnClickListener是实现界面上点击事件监听之意
 * <p>
 * implements View.OnClickListener作用：
 * implements View.OnClickListener能够不用为每个界面上的点击控件都编写一个点击事件监听代码，
 * 简化了界面上点击控件的点击事件监听代码量。
 * <p>
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化控件
        initView();
    }

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
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
            WanAndroidService2 service = retrofit.create(WanAndroidService2.class);
            Observable<ResponseResult> obv = service.register(username, password, repassword);

                    obv.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<ResponseResult>() {

                                @Override
                                public void onSubscribe(@NonNull Disposable d) {

                                }

                                @Override
                                public void onNext(@NonNull ResponseResult responseResult) {
                                    Log.d(TGA, "onNext: " + responseResult.getData());
                                    if (responseResult.getCode() == 0) {
                                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {

                                }

                                @Override
                                public void onComplete() {

                                }
                            });
        }
    }
}


