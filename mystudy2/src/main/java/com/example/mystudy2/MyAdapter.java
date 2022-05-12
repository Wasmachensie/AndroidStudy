package com.example.mystudy2;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyAdapter extends PagerAdapter {

    private List<View> listView;

    public MyAdapter(List<View> listView) {
        this.listView = listView;
    }

    /**
     * @param container
     * @param position
     * @return 1、将指定位置的View添加到ViewGroup(容器)中，创建并显示出来
     * 2、返回一个代表新增页面的Object(key)，通常都是直接返回view本身，
     * 当然你也可以自定义自己的key，但是key和每个view一一对应
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(listView.get(position), 0);
        return listView.get(position);
    }

    //获得viewPage中view的个数
    @Override
    public int getCount() {
        return listView.size();
    }

    /**
     * @param view
     * @param object
     * @return 判断instantiateItem(ViewGroup, int)方法返回的key与一个页面视图是否是代表的同一个
     * 视图(所代表的是否是否是view本身)，通常写return object==view;
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    /**
     * @param container
     * @param position
     * @param object    1、删除一个页面
     *                  2、销毁页面中的视图
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(listView.get(position));
    }


}
