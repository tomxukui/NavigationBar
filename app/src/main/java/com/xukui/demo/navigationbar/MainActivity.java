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
        mTabIcons.add(R.mipmap.ic_launcher_round);
        mTabIcons.add(R.mipmap.ic_launcher_round);
        mTabIcons.add(R.mipmap.ic_launcher_round);
        mTabIcons.add(R.mipmap.ic_launcher_round);
        mTabIcons.add(R.mipmap.ic_launcher_round);
        mTabIcons.add(R.mipmap.ic_launcher_round);
        mTabIcons.add(R.mipmap.ic_launcher_round);
    }

    private void initView() {
        bar_tabs = findViewById(R.id.bar_tabs);
    }

    private void setView() {
        bar_tabs.setOnItemSelectListener(new NavigationBarAdapter.OnItemSelectListener() {

            @Override
            public void onItemSelected(NavigationBarAdapter.TabHolder holder, int position, int prePosition) {
                Log.e("ddd", position + ", " + prePosition);
            }

        });
        bar_tabs.setNewIcons(mTabIcons);
    }

}
