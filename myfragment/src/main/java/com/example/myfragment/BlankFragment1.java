package com.example.myfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BlankFragment1 extends Fragment {
    private View root;
    private TextView tv;
    private Button butn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    //onCreateView()是创建该fragment对应的视图，必须在这里创建自己的视图并返回给调用者。
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //如果root为空，解析xml
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_blank1, container, false);
        }
        //初始textview
        tv = (TextView) root.findViewById(R.id.textView);
        //初始化button
        butn = root.findViewById(R.id.btn);
        //设置button的点击事件
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button的点击事件设置为修改textView
                tv.setText("yes");
            }
        });
        return root;//到这里xml已经创建完成
    }
}