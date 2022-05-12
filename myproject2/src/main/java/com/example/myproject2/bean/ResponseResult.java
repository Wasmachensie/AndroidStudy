package com.example.myproject2.bean;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/11/22:03
 * @Description: 请求服务器的  结果Bean  总Bean
 */
public class ResponseResult {

    private Data data;
    private int code;
    private String message;

    public ResponseResult() {
    }

    public ResponseResult(Data data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
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
