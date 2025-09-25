package com.ftn.sbnz.model.models;

public class Tablecloth {
    private int length;
    private int width;
    private String shape; // rectangle, square, round
    private int diameter; // za okrugli sto
    private int overhang; // pad sa strane

    public Tablecloth(int length, int width, String shape, int diameter, int overhang) {
        this.length = length;
        this.width = width;
        this.shape = shape;
        this.diameter = diameter;
        this.overhang = overhang;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getOverhang() {
        return overhang;
    }

    public void setOverhang(int overhang) {
        this.overhang = overhang;
    }
}
