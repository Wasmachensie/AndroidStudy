package com.example.myokhttp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TGA = "ARNO";
    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        okHttpClient = new OkHttpClient();
    }

    //get同步请求
    public void getSync(View view) {
        new Thread() {
            @Override
            public void run() {
                //创建一个Request对象
                Request request = new Request
                        .Builder()
                        .url("https://www.httpbin.org/get?a=1&b=2")
                        .build();
                //OkHttpClient提供获取Call的方法：newCall(Request)，用来发送请求。
                Call call = okHttpClient.newCall(request);
                try {
                    Response response = call.execute();
                    Log.i(TGA,"getSyc:" +  response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    //get异步请求
    public void getAsync(View view) {
        //创建一个Request对象
        Request request = new Request
                .Builder()
                .url("https://www.httpbin.org/get?a=1&b=2")
                .build();
        //OkHttpClient提供获取Call的方法：newCall(Request)，用来发送请求。
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            //请求失败的回调
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
            }
            @Override
            //请求结果的回调
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                //如果请求成功，就输出响应体
                if (response.isSuccessful()) {
                    Log.i(TGA,"getAsync:" + response.body().string());
                }
            }
        });
    }


    //post同步请求
    public void postSync(View view) {
        new Thread() {
            @Override
            public void run() {
                //添加一个请求体
                FormBody formBody = new FormBody.Builder().add("a", "9").add("b", "10").build();
                //创建一个Request对象
                Request request = new Request.Builder()
                        .url("https://www.httpbin.org/post")
                        .post(formBody)
                        .build();
                Call call = okHttpClient.newCall(request);
                try {
                    Response response = call.execute();
                    Log.i(TGA,"postSync:" + response.body().string());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void postAsync(View view) {
        FormBody formBody = new FormBody.Builder().add("a", "9").add("b", "10").build();
        Request request = new Request.Builder()
                .url("https://www.httpbin.org/post")
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                //如果请求成功，就输出响应体
                if (response.isSuccessful()) {
                    Log.i(TGA,"postAsync:" + response.body().string());
                }
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
            }

        });
    }






}