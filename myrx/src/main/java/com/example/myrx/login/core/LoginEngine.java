package com.example.myrx.login.core;

import com.example.myrx.login.bean.ResponseResult;
import com.example.myrx.login.bean.SuccessBean;

import io.reactivex.rxjava3.core.Observable;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/11/22:09
 * @Description:
 * 登录引擎
 */
public class LoginEngine {
    //传入用户名，密码   返回  起点
    public static Observable<ResponseResult> login(String username, String password) {

        //最终返回总Bean
        ResponseResult responseResult = new ResponseResult();
        if (username.equals("admin") && password.equals("123456")) {//登录成功
            SuccessBean successBean = new SuccessBean();
            successBean.setId(4567456);
            successBean.setName("ARNO");
            /*
            * 登陆成功会返回这样的信息：
            * {
            *   data:{}
            *   code:200
            *   message:登录成功
            * }
            * */
            responseResult.setData(successBean);
            responseResult.setCode(200);
            responseResult.setMessage("登录成功");

        } else {
            /*
             * 登陆失败会返回这样的信息：
             * {
             *   data:null
             *   code:404
             *   message:登录失败
             * }
             * */
            responseResult.setData(null);
            responseResult.setCode(404);
            responseResult.setMessage("登录失败");
        }
        //返回起点 并且传入最终返回总Bean
        return Observable.just(responseResult);
    }

}
