package com.xukui.library.navigationbar.bean;

import java.io.Serializable;

public class TabItem implements Serializable {

    private int icon;
    private boolean selectEnabled;

    public TabItem(int icon, boolean selectEnabled) {
        this.icon = icon;
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

    public boolean isSelectEnabled() {
        return selectEnabled;
    }

    public void setSelectEnabled(boolean selectEnabled) {
        this.selectEnabled = selectEnabled;
    }

}