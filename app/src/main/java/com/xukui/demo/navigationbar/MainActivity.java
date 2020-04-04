package com.xukui.demo.navigationbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xukui.library.navigationbar.NavigationBar;
import com.xukui.library.navigationbar.adapter.NavigationBarAdapter;
import com.xukui.library.navigationbar.bean.TabItem;
import com.xukui.library.navigationbar.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NavigationBar bar_tabs;

    private List<TabItem> mTabItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
        setView();
    }

    private void initData() {
        mTabItems = new ArrayList<>();
        mTabItems.add(new TabItem(R.drawable.btn_explore, DensityUtil.dp2px(30), true));
        mTabItems.add(new TabItem(R.drawable.btn_explore, DensityUtil.dp2px(30), true));
        mTabItems.add(new TabItem(R.drawable.btn_explore, DensityUtil.dp2px(30), false));
        mTabItems.add(new TabItem(R.drawable.btn_explore, DensityUtil.dp2px(30), true));
        mTabItems.add(new TabItem(R.drawable.btn_explore, DensityUtil.dp2px(30), true));
    }

    private void initView() {
        bar_tabs = findViewById(R.id.bar_tabs);
    }

    private void setView() {
        bar_tabs.setOnTabSelectedListener(new NavigationBarAdapter.OnTabSelectedListener() {

            @Override
            public void onTabClicked(NavigationBarAdapter.TabHolder holder, int position) {
                Log.e("ddd", "onTabClicked: " + position);
            }

            @Override
            public void onTabSelected(NavigationBarAdapter.TabHolder holder, int position, int prePosition) {
                Log.e("ddd", "onTabSelected: " + position + ", " + prePosition);
            }

            @Override
            public void onTabReselected(NavigationBarAdapter.TabHolder holder, int position) {
                Log.e("ddd", "onTabReselected:" + position);
            }

        });
        bar_tabs.setTabItems(mTabItems);
    }

}