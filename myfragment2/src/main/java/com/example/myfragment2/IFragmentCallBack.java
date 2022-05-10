package com.example.myfragment2;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/04/28/14:19
 * @Description:
 */
public interface IFragmentCallBack {
    //发送信息给Activity
    void sendMsgToActivity(String msg);

    //从Activity获取数据
    String getMsgFromActivity();
}
