package com.example.mywanandroid;

import com.example.mywanandroid.bean.BaseResponse;
import com.google.gson.Gson;

import org.junit.Test;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/10/17:32
 * @Description:
 */
public class WanAndroidUnitText {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.wanandroid.com/").build();
    WanAndroidService wanAndroidService = retrofit.create(WanAndroidService.class);

    @Test
    public void loginTest() throws IOException {
        Call<ResponseBody> call = wanAndroidService.login("Arno", "123456");
        Response<ResponseBody> response = call.execute();
        String result = response.body().string();
        System.out.println(result);
        //手动进行数据转换
        BaseResponse baseResponse = new Gson().fromJson(result, BaseResponse.class);
        System.out.println(baseResponse.toString());
    }


    Retrofit retrofit2 = new Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            //添加转换器
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    WanAndroidService2 wanAndroidService2 = retrofit2.create(WanAndroidService2.class);

    @Test
    public void loginTest2() throws IOException {
        Call<BaseResponse> call = wanAndroidService2.login("Arno", "123456");
        Response<BaseResponse> response = call.execute();
        BaseResponse baseResponse = response.body();
        //利用转换器进行数据转换
        System.out.println(baseResponse);
    }


}
