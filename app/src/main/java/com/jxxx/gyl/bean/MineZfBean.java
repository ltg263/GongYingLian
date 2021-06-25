package com.jxxx.gyl.bean;

public class MineZfBean {
    String str;
    boolean isSelect;

    public MineZfBean(String str, boolean isSelect) {
        this.str = str;
        this.isSelect = isSelect;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
