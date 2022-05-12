package com.example.mywanandroid;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/10/17:24
 * @Description:
 */
public interface WanAndroidService {

    @POST("/user/login")
    @FormUrlEncoded
    Call<ResponseBody> login(@Field("username") String username,@Field("password") String password);



}
