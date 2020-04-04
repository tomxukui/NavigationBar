package com.xukui.library.navigationbar.adapter;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.xukui.library.navigationbar.R;
import com.xukui.library.navigationbar.bean.TabItem;

import java.util.List;

public class NavigationBarAdapter extends RecyclerView.Adapter<NavigationBarAdapter.TabHolder> {

    private List<TabItem> mTabItems;

    private LayoutInflater mInflater;

    private int mIconSize;
    private int mSelectedPosition;

    @Nullable
    private OnTabSelectedListener mOnTabSelectedListener;

    public NavigationBarAdapter(int iconSize) {
        mIconSize = iconSize;
    }

    public NavigationBarAdapter() {
    }

    @Override
    public int getItemCount() {
        return mTabItems == null ? 0 : mTabItems.size();
    }

    @NonNull
    @Override
    public TabHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(viewGroup.getContext());
        }

        View view = mInflater.inflate(R.layout.nb_item_recycler_tab, viewGroup, false);
        return new TabHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TabHolder tabHolder, final int position) {
        final TabItem tabItem = mTabItems.get(position);
        boolean isSelected = (mSelectedPosition == position);

        tabHolder.frame_tab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (tabItem.isSelectEnabled()) {
                    int prePosition = mSelectedPosition;
                    mSelectedPosition = position;

                    notifyItemChanged(prePosition);
                    notifyItemChanged(position);

                    if (mOnTabSelectedListener != null) {
                        if (prePosition == mSelectedPosition) {
                            mOnTabSelectedListener.onTabReselected(tabHolder, position);

                        } else {
                            mOnTabSelectedListener.onTabSelected(tabHolder, position, prePosition);
                        }
                    }

                } else {
                    if (mOnTabSelectedListener != null) {
                        mOnTabSelectedListener.onTabClicked(tabHolder, position);
                    }
                }
            }

        });

        tabHolder.iv_tab.setImageResource(tabItem.getIcon());
        ViewGroup.LayoutParams iconLayoutParams = tabHolder.iv_tab.getLayoutParams();
        iconLayoutParams.width = mIconSize;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int[] stateSet = {android.R.attr.state_checked * (isSelected ? 1 : -1)};
            tabHolder.iv_tab.setImageState(stateSet, true);

        } else {
            tabHolder.iv_tab.setSelected(isSelected);
        }
    }

    public void setNewData(List<TabItem> tabItems) {
        mTabItems = tabItems;

        notifyDataSetChanged();
    }

    public void setIconSize(int iconSize) {
        mIconSize = iconSize;

        notifyItemRangeChanged(0, getItemCount());
    }

    public static class TabHolder extends RecyclerView.ViewHolder {

        public FrameLayout frame_tab;
        public AppCompatImageView iv_tab;

        public TabHolder(View view) {
            super(view);
            frame_tab = view.findViewById(R.id.frame_tab);
            iv_tab = view.findViewById(R.id.iv_tab);
        }

    }

    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener listener) {
        mOnTabSelectedListener = listener;
    }

    public interface OnTabSelectedListener {

        void onTabClicked(TabHolder holder, int position);

        void onTabSelected(TabHolder holder, int position, int prePosition);

        void onTabReselected(TabHolder holder, int position);

    }

}
