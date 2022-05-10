package com.example.myintent.simple03;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/05/06/17:14
 * @Description:
 */
// 必须实现Parcelable接口，该对象才有传递的资格
public class Student implements Parcelable {

    public Student() {
    }

    //定义属性
    public String name;
    public int age;

    // Todo：读取属性的顺序必须和写入时的顺序一致，否则会报错
    //构造方法
    protected Student(Parcel in) {
        //从Parcel读取属性，赋值给 name，age
        name = in.readString();
        age = in.readInt();
    }
    //把属性写入到Parcel 对象中
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
    }

    //CREATOR内部调用用的，一定要有  自动生成
    public static final Creator<Student> CREATOR = new Creator<Student>() {
        //创建一个Student对象，并且把Parcel对象构建好，
        //传递给Student(成员数据就可以从Parcel中读取了)
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }
        //创建一个Student对象数组，辅助用，不用管
        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    //系统扩展用，不用管
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
