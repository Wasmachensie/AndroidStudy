package com.example.myretrofit;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/09/17:19
 * @Description:
 *
 */
public interface HttpbinService {

    //http://httpbin.org/post  xxx = value

    @POST("post")
    @FormUrlEncoded
    Call<ResponseBody> post(@Field("userName") String username, @Field("pwd") String password);

    //@GET("get")
    //Call<ResponseBody> get(@Query("userName") String username,@Query("pwd") String password);
}
