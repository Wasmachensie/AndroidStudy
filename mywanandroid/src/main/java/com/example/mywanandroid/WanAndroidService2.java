package com.example.mywanandroid;

import com.example.mywanandroid.bean.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/11/11:36
 * @Description:
 */
public interface WanAndroidService2 {

    @POST("/user/login")
    @FormUrlEncoded
    Call<BaseResponse> login(@Field("username") String username, @Field("password") String password);

}
