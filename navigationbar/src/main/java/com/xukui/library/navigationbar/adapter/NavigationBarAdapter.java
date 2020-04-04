package com.xukui.library.navigationbar.adapter;

import android.support.annotation.NonNull;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xukui.library.navigationbar.R;

import java.util.List;

public class NavigationBarAdapter extends RecyclerView.Adapter<NavigationBarAdapter.TabHolder> {

    private List<Integer> mTabIcons;

    private LayoutInflater mInflater;

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
    public void onBindViewHolder(@NonNull TabHolder tabHolder, int position) {
        int tabIcon = mTabIcons.get(position);

        tabHolder.iv_tab.setImageResource(tabIcon);
    }

    public void setNewData(List<Integer> icons) {
        mTabIcons = icons;

        notifyDataSetChanged();
    }

    static class TabHolder extends RecyclerView.ViewHolder {

        AppCompatImageView iv_tab;

        public TabHolder(View view) {
            super(view);
            iv_tab = view.findViewById(R.id.iv_tab);
        }

    }

}
