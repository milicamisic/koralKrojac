package com.ftn.sbnz.model.models;

public abstract class Garment {
    protected String color;
    protected String fit;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }
}
