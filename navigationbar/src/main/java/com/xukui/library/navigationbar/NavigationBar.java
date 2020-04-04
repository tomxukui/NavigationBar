package com.xukui.library.navigationbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.xukui.library.navigationbar.adapter.NavigationBarAdapter;
import com.xukui.library.navigationbar.util.DensityUtil;

import java.util.List;

public class NavigationBar extends FrameLayout {

    private RecyclerView recycler_tabs;

    private GridLayoutManager mLayoutManager;
    private NavigationBarAdapter mNavigationBarAdapter;

    private int mSpanCount;
    private int mElevation;
    private int mIconSize;

    public NavigationBar(@NonNull Context context) {
        super(context);
        initData(context, null, 0);
        initView(context);
        setView(context);
    }

    public NavigationBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context, attrs, 0);
        initView(context);
        setView(context);
    }

    public NavigationBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context, attrs, defStyleAttr);
        initView(context);
        setView(context);
    }

    private void initData(Context context, AttributeSet attrs, int defStyleAttr) {
        mSpanCount = 4;
        mElevation = DensityUtil.dp2px(6);
        mIconSize = DensityUtil.dp2px(30);

        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NavigationBar, defStyleAttr, 0);

            mElevation = ta.getDimensionPixelSize(R.styleable.NavigationBar_android_elevation, mElevation);
            mIconSize = ta.getDimensionPixelSize(R.styleable.NavigationBar_nb_icon_size, mIconSize);

            ta.recycle();
        }

        mLayoutManager = new GridLayoutManager(context, mSpanCount);
        mNavigationBarAdapter = new NavigationBarAdapter(mIconSize);
    }

    private void initView(Context context) {
        recycler_tabs = new RecyclerView(context);
        recycler_tabs.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        recycler_tabs.setClipChildren(false);
        recycler_tabs.setItemAnimator(null);
        addView(recycler_tabs);
    }

    private void setView(Context context) {
        ViewCompat.setElevation(this, mElevation);

        recycler_tabs.setLayoutManager(mLayoutManager);
        recycler_tabs.setAdapter(mNavigationBarAdapter);
    }

    public void setNewIcons(List<Integer> icons) {
        if (icons != null && icons.size() > 0) {
            mSpanCount = icons.size();
        }

        mLayoutManager.setSpanCount(mSpanCount);
        mNavigationBarAdapter.setNewData(icons);
    }

    public void setOnTabSelectedListener(@Nullable NavigationBarAdapter.OnTabSelectedListener listener) {
        mNavigationBarAdapter.setOnTabSelectedListener(listener);
    }

}
