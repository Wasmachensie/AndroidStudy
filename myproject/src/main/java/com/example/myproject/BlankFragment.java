package com.example.myproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

//定义一个空的Fragment
public class BlankFragment extends Fragment {

    private static final String ARG_TEXT = "param1";
    private String mTextString;
    View rootView;

    public BlankFragment() {
    }

    //newInstance是专门用来构建BlankFragment的
    public static BlankFragment newInstance(String param1) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTextString = getArguments().getString(ARG_TEXT);
        }
    }

    @Override
    //onCreateView解析xml文件
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            /*
             * 如果想保证item的视图中的参数不被改变,要使用
             * rootView = inflater.inflate(R.layout.fragment_blank, parent,false);
             * 这种方式进行视图的填充
             */
            rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        }
        //找一下布局文件中的控件
        initView();
        return rootView;
    }

    //创建initView方法
    private void initView() {
        TextView textView = rootView.findViewById(R.id.textView);
        textView.setText(mTextString);
    }
}