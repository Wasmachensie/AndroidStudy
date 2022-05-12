package com.example.myrx.login.bean;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/11/22:03
 * @Description:
 * 请求服务器的  结果Bean  总Bean
 */
public class ResponseResult {

    private SuccessBean data;
    private int code;
    private String message;

    public ResponseResult() {
    }

    public ResponseResult(SuccessBean data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public SuccessBean getData() {
        return data;
    }

    public void setData(SuccessBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
