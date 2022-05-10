package com.example.mypopupwindow;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TGA = "Arno";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ArnoClick(View view) {
        View popupView = getLayoutInflater().inflate(R.layout.popup_view, null);

        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,//设置宽高
                true);//点击空白处退出popupWindow
        //设置popupWindow的背景
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.ceshi));

        /*popupWindow.showAsDropDown(view,view.getWidth(),-view.getHeight());
         * 通过这个方法可以设置popupWindow的偏移*/
        popupWindow.showAsDropDown(view);//显示popupWindow

        //设置按钮的点击事件
        Button btn1 = popupView.findViewById(R.id.btn1);
        Button btn2 = popupView.findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TGA,"你是住在上海吗？");
                //点击完成后退出popupWindow
                popupWindow.dismiss();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TGA,"你是住在北京吗？");
                //点击完成后退出popupWindow
                popupWindow.dismiss();
            }
        });
    }
}