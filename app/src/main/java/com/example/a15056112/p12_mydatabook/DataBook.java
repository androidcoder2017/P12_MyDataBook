package com.example.a15056112.p12_mydatabook;

import java.io.Serializable;

/**
 * Created by 15056112 on 10/8/2017.
 */

public class DataBook implements Serializable {
    private String title;
    private int icons;

    public DataBook(String title, int icons) {
        this.title = title;
        this.icons = icons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcons() {
        return icons;
    }

    public void setIcons(int icons) {
        this.icons = icons;
    }
}
