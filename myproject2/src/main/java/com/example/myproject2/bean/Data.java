package com.example.myproject2.bean;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/10/17:46
 * @Description:
 */
public class Data {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Data{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
