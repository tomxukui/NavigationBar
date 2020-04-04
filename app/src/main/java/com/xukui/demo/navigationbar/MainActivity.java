package com.xukui.demo.navigationbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xukui.library.navigationbar.NavigationBar;
import com.xukui.library.navigationbar.adapter.NavigationBarAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NavigationBar bar_tabs;

    private List<Integer> mTabIcons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
        setView();
    }

    private void initData() {
        mTabIcons = new ArrayList<>();
        mTabIcons.add(R.drawable.btn_explore);
        mTabIcons.add(R.drawable.btn_explore);
        mTabIcons.add(R.drawable.btn_explore);
        mTabIcons.add(R.drawable.btn_explore);
        mTabIcons.add(R.drawable.btn_explore);
    }

    private void initView() {
        bar_tabs = findViewById(R.id.bar_tabs);
    }

    private void setView() {
        bar_tabs.setOnTabSelectedListener(new NavigationBarAdapter.OnTabSelectedListener() {

            @Override
            public void onTabSelected(NavigationBarAdapter.TabHolder holder, int position, int prePosition) {
                Log.e("ddd", "onTabSelected: " + position + ", " + prePosition);
            }

            @Override
            public void onTabReselected(NavigationBarAdapter.TabHolder holder, int position) {
                Log.e("ddd", "onTabReselected:" + position);
            }

        });
        bar_tabs.setNewIcons(mTabIcons);
    }

}