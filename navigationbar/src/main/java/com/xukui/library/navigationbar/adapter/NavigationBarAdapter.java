package com.xukui.library.navigationbar.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.xukui.library.navigationbar.R;

import java.util.List;

public class NavigationBarAdapter extends RecyclerView.Adapter<NavigationBarAdapter.TabHolder> {

    private List<Integer> mTabIcons;

    private LayoutInflater mInflater;

    private int mIconSize;
    private int mSelectedPosition;

    @Nullable
    private OnItemSelectListener mOnItemSelectListener;

    public NavigationBarAdapter(int iconSize) {
        mIconSize = iconSize;
    }

    public NavigationBarAdapter() {
    }

    @Override
    public int getItemCount() {
        return mTabIcons == null ? 0 : mTabIcons.size();
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
        int tabIcon = mTabIcons.get(position);

        tabHolder.frame_tab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int prePosition = mSelectedPosition;
                mSelectedPosition = position;

                notifyItemChanged(prePosition);
                notifyItemChanged(position);

                if (mOnItemSelectListener != null) {
                    mOnItemSelectListener.onItemSelected(tabHolder, position, prePosition);
                }
            }

        });

        tabHolder.iv_tab.setImageResource(tabIcon);
        ViewGroup.LayoutParams iconLayoutParams = tabHolder.iv_tab.getLayoutParams();
        iconLayoutParams.width = mIconSize;

        int[] stateSet = {android.R.attr.state_checked * (mSelectedPosition == position ? 1 : -1)};
        tabHolder.iv_tab.setImageState(stateSet, false);
    }

    public void setNewData(List<Integer> icons) {
        mTabIcons = icons;

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

    public void setOnItemSelectListener(@Nullable OnItemSelectListener listener) {
        mOnItemSelectListener = listener;
    }

    public interface OnItemSelectListener {

        void onItemSelected(TabHolder holder, int position, int prePosition);

    }

}
