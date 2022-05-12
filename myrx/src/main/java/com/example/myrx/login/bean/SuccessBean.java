package com.example.myrx.login.bean;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/11/22:05
 * @Description:
 * 登录  注册 成功 Bean 信息
 */
public class SuccessBean {
    private int id;
    private String name;

    public SuccessBean() {
    }

    public SuccessBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SuccessBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
