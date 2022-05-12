package com.example.myrx.login.core;

import com.example.myrx.login.bean.ResponseResult;
import com.example.myrx.login.bean.SuccessBean;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/11/23:04
 * @Description:
 */
public abstract class DiyObserver implements Observer<ResponseResult> {

    //登录成功 提取成功Bean
    public abstract void success(SuccessBean successBean);
    //登录失败 提取message
    public abstract void error(String message);


    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(ResponseResult responseResult) {
        if (responseResult.getData() == null) {
            error(responseResult.getMessage() + "请求失败");
        } else {
            success(responseResult.getData());
        }

    }

    @Override
    public void onError(@NonNull Throwable e) {
        error(e.getMessage() + "请检查错误" );

    }

    @Override
    public void onComplete() {

    }
}
