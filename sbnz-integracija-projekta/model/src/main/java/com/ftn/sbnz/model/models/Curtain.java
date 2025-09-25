package com.ftn.sbnz.model.models;

public class Curtain {
    private int height;
    private int windowWidth;
    private double pleatingFactor; // 1.5, 2, ...
    private String hangingType; // kukice, kanal, karike
    private int marginTop;
    private int marginBottom;

    public Curtain(int height, int windowWidth, double pleatingFactor, String hangingType, int marginTop, int marginBottom) {
        this.height = height;
        this.windowWidth = windowWidth;
        this.pleatingFactor = pleatingFactor;
        this.hangingType = hangingType;
        this.marginTop = marginTop;
        this.marginBottom = marginBottom;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public double getPleatingFactor() {
        return pleatingFactor;
    }

    public void setPleatingFactor(double pleatingFactor) {
        this.pleatingFactor = pleatingFactor;
    }

    public String getHangingType() {
        return hangingType;
    }

    public void setHangingType(String hangingType) {
        this.hangingType = hangingType;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }
}
