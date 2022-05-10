package com.example.myproject;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 8Nuyoah
 * @Date: 2022/04/29/9:53
 * @Description:
 * MyFragmentAdapter目的是适配Fragment
 */
public class MyFragmentAdapter extends FragmentStateAdapter {
    List<Fragment> fragmentList = new ArrayList<Fragment>();

    public MyFragmentAdapter(@NonNull FragmentManager fragmentManager,
                             @NonNull Lifecycle lifecycle,
                             List<Fragment> fragmentList) {
        super(fragmentManager, lifecycle);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    //返回Fragment
    //position是第几个Fragment
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    //返回Fragment的数量
    public int getItemCount() {
        return fragmentList.size();
    }
}
