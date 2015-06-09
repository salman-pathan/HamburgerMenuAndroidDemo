package com.codiodes.hamburgerdemo;

/**
 * Created by Salman on 6/8/2015.
 */
public class NavigationItem {

    private String title;
    private String subTitle;

    public NavigationItem(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
