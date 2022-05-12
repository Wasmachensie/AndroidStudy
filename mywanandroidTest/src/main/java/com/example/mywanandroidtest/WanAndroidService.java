package com.example.mywanandroidtest;

import com.example.mywanandroidtest.bean.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/11/11:59
 * @Description:
 */
public interface WanAndroidService {


    //登录
    @POST("/user/login")
    //@HTTP(method = "POST", path = "/user/login", hasBody = true)
    @FormUrlEncoded
    Call<BaseResponse> login(@Field("username") String username,
                             @Field("password") String password);

    ////注册
    //@POST("/user/register")
    //@FormUrlEncoded
    //Call<BaseResponse> register(@Field("phone") String username,
    //                            @Field("password") String password,
    //                            @Field("repassword") String repassword) throws IOException;
    //
    //@GET("/user/logout")
    //Call<BaseResponse> logout() throws IOException;




}

