package com.example.myreceiver;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/05/10:06
 * @Description:
 */


public interface ActionUtils {
    //广播注册时 与 广播发送时 的 唯一标识，必须保持一致（给动态注册用）
    String ACTION_EQUES_UPDATE_IP = "com.example.receiver_study_";
    //广播注册时 与 广播发送时 的 唯一标识，必须保持一致（给静态注册用）
    String ACTION_FLAG = "com.example.receiver_flag_";
}



