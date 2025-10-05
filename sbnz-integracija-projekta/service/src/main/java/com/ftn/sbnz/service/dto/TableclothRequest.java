package com.ftn.sbnz.service.dto;

public class TableclothRequest {
    private String shape; // RECTANGULAR, SQUARE, ROUND
    private int length;
    private int width;
    private int overhang;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
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

    public int getOverhang() {
        return overhang;
    }

    public void setOverhang(int overhang) {
        this.overhang = overhang;
    }
}
