package com.example.mystudy3wechat;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/04/28/16:13
 * @Description:
 * 定义一个类专门用来适配ViewPager
 */
public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {
    private List<String> titles = new ArrayList<>();
    //来保存界面要改变颜色的值
    private List<Integer> bgColor = new ArrayList<>();

    //ViewPagerAdapter初始化的时候初始化ArrayList
    public ViewPagerAdapter() {
        titles.add("第一页");
        titles.add("第二页");
        titles.add("第三页");
        titles.add("第四页");
        bgColor.add(R.color.wechatbg);
        bgColor.add(R.color.purple_200);
        bgColor.add(R.color.teal_200);
        bgColor.add(R.color.black);
    }


    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerViewHolder((ViewGroup) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_page, parent, false));
    }

    @Override
    //通过这个方法把数据传进来，给页面展示不同的数据
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        //position显示的是第几页
        holder.mTv.setText(titles.get(position));
        holder.mContainer.setBackgroundResource(bgColor.get(position));
        //设置背景颜色，注意要用setBackgroundResource，不能用setBackgroundColor
    }

    @Override
    //页面数
    public int getItemCount() {
        return 4;
    }

    // 创建一个内部类，这个ViewHold是来解析item_page的
    class ViewPagerViewHolder extends RecyclerView.ViewHolder {

        //item_page包含的控件：TextView，根部局RelativeLayout
        TextView mTv;
        RelativeLayout mContainer;

        public ViewPagerViewHolder(@NonNull ViewGroup itemView) {
            super(itemView);
            mContainer = itemView.findViewById(R.id.container);
            mTv = itemView.findViewById(R.id.tvTitle);
        }
    }
}
