package com.ftn.sbnz.service.dto;

public class CurtainRequest {
    private int height;
    private int width;
    private int pleatFactor;
    private String hangingType; // HOOKS, RINGS, CHANNEL
    private int marginTop;
    private int marginBottom;

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
}
