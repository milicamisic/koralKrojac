package com.ftn.sbnz.model.models;

public class BedSheet {
    private int length;
    private int width;
    private int height; // dušeka
    private String type; // sa lastišem, bez lastiša, navlaka za jorgan
    private int overhang;

    public BedSheet(int length, int width, int height, String type, int overhang) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.type = type;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOverhang() {
        return overhang;
    }

    public void setOverhang(int overhang) {
        this.overhang = overhang;
    }
}
