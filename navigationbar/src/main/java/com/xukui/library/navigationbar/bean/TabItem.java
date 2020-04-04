package com.xukui.library.navigationbar.bean;

import android.support.annotation.Nullable;

import java.io.Serializable;

public class TabItem implements Serializable {

    private int icon;
    @Nullable
    private Integer iconSize;//图标的尺寸. 如果大于0, 则按图标尺寸来, 如果为空或小于0, 则按图片原始尺寸来
    private boolean selectEnabled;

    public TabItem(int icon, @Nullable Integer iconSize, boolean selectEnabled) {
        this.icon = icon;
        this.iconSize = iconSize;
        this.selectEnabled = selectEnabled;
    }

    public TabItem() {
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Integer getIconSize() {
        return iconSize;
    }

    public void setIconSize(Integer iconSize) {
        this.iconSize = iconSize;
    }

    public boolean isSelectEnabled() {
        return selectEnabled;
    }

    public void setSelectEnabled(boolean selectEnabled) {
        this.selectEnabled = selectEnabled;
    }

}