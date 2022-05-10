package com.example.myintent.simple02;

import java.io.Serializable;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/06/17:14
 * @Description:
 */
// 必须实现Serializable接口，该对象才有传递的资格
public class Student implements Serializable {
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
