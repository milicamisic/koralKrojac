package com.ftn.sbnz.model.models;

public class Tablecloth {
    private int length;
    private int width;
    private String shape; // rectangle, square, round
    private double diameter; // za okrugli sto
    private double overhang; // pad sa strane

    public Tablecloth(int length, int width, String shape, double diameter, double overhang) {
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

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getOverhang() {
        return overhang;
    }

    public void setOverhang(double overhang) {
        this.overhang = overhang;
    }

    @Override
    public String toString() {
        return "Tablecloth{" +
                "length=" + length +
                ", width=" + width +
                ", shape='" + shape + '\'' +
                ", diameter=" + diameter +
                ", overhang=" + overhang +
                '}';
    }
}
