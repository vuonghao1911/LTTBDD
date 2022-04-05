package com.example.myapplication;

import android.media.Image;

public class Donut {
    private String title;
    private String subTitle;
    private int price;
    private int img;

    public Donut(String title, String subTitle, int price, int img) {
        this.title = title;
        this.subTitle = subTitle;
        this.price = price;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
