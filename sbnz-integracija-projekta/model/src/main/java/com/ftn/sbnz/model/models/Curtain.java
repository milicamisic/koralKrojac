package com.ftn.sbnz.model.models;

public class Curtain {
    private int height;
    private int width;
    private int pleatFactor; // 1.5, 2, ...
    private String hangingType; // kukice, kanal, karike
    private int marginTop;
    private int marginBottom;

    public Curtain() {}

    public Curtain(int height, int width, int pleatFactor, String hangingType, int marginTop, int marginBottom) {
        this.height = height;
        this.width = width;
        this.pleatFactor = pleatFactor;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPleatFactor() {
        return pleatFactor;
    }

    public void setPleatFactor(int pleatFactor) {
        this.pleatFactor = pleatFactor;
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

    @Override
    public String toString() {
        return "Curtain{" +
                "height=" + height +
                ", width=" + width +
                ", pleatFactor=" + pleatFactor +
                ", hangingType='" + hangingType + '\'' +
                ", marginTop=" + marginTop +
                ", marginBottom=" + marginBottom +
                '}';
    }
}
