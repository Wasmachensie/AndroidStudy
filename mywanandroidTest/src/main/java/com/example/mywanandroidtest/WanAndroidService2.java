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
public interface WanAndroidService2 {

    //@POST("/user/login")
    //@FormUrlEncoded
    //Call<BaseResponse> login(@Field("phone") String username, @Field("password") String password) throws IOException;

    @POST("/user/register")
    //@HTTP(method = "POST", path = "/user/register", hasBody = true)
    @FormUrlEncoded
    Call<BaseResponse> register(@Field("username") String username,
                                @Field("password") String password,
                                @Field("repassword") String repassword);
    //
    //@GET("/user/logout")
    //Call<BaseResponse> logout() throws IOException;




}

