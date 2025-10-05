package com.ftn.sbnz.service.dto;

public class BedsheetRequest {
    private String type; // FITTED or FLAT
    private int length;
    private int width;
    private int height;
    private int overhang;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getOverhang() {
        return overhang;
    }

    public void setOverhang(int overhang) {
        this.overhang = overhang;
    }
}
