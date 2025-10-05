package com.ftn.sbnz.service.dto;

public class CurtainRequest {
    private double height;
    private double width;
    private double pleatFactor;
    private String hangingType; // HOOKS, RINGS, CHANNEL
    private double marginTop;
    private double marginBottom;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getPleatFactor() {
        return pleatFactor;
    }

    public void setPleatFactor(double pleatFactor) {
        this.pleatFactor = pleatFactor;
    }

    public String getHangingType() {
        return hangingType;
    }

    public void setHangingType(String hangingType) {
        this.hangingType = hangingType;
    }

    public double getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(double marginTop) {
        this.marginTop = marginTop;
    }

    public double getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(double marginBottom) {
        this.marginBottom = marginBottom;
    }
}
