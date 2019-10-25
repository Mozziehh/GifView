package com.example.wubagifview.model;

import java.io.Serializable;

public class ImageData implements Serializable {
    public String imageUrl;
    public String gifUrl;
    private float scale = 0;
    private int width = 0;
    private int height = 0;
    private int position = -1;


    public void setScale(float scale) {
        this.scale = scale;
    }

    public float getScale(){
        return this.scale;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
