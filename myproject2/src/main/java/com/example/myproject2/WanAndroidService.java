package com.example.myproject2;

import com.example.myproject2.bean.ResponseResult;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/11/11:59
 * @Description:
 */
public interface WanAndroidService {


    //登录
    @POST("/user/login")
    Observable<ResponseResult> login(@Query("username") String username,
                                     @Query("password") String password);


}

