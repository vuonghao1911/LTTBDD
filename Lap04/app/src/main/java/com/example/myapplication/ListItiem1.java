package com.example.myapplication;

public class ListItiem1 {
    private int img;
    private String title;
    private  String button;

    public ListItiem1(int img, String title, String button) {
        this.img = img;
        this.title = title;
        this.button = button;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
