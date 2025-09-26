package com.ftn.sbnz.model.models;

public class Dress extends Garment {
    private int bust;
    private int waist;
    private int hips;
    private int length;
    private String sleeveType;
    private int shoulder;
    private String type; // A-line, Circle, Bodycon, Shift
    private int height;
    private boolean wrap;

    public Dress() {}

    public Dress(int bust, int waist, int hips, int length, String sleeveType, int shoulder, String type, int height, boolean wrap) {
        this.bust = bust;
        this.waist = waist;
        this.hips = hips;
        this.length = length;
        this.sleeveType = sleeveType;
        this.shoulder = shoulder;
        this.type = type;
        this.height = height;
        this.wrap = wrap;
    }

    public int getBust() {
        return bust;
    }

    public void setBust(int bust) {
        this.bust = bust;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHips() {
        return hips;
    }

    public void setHips(int hips) {
        this.hips = hips;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }

    public int getShoulder() {
        return shoulder;
    }

    public void setShoulder(int shoulder) {
        this.shoulder = shoulder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isWrap() {
        return wrap;
    }

    public void setWrap(boolean wrap) {
        this.wrap = wrap;
    }

    @Override
    public String toString() {
        return "Dress{" +
                "bust=" + bust +
                ", waist=" + waist +
                ", hips=" + hips +
                ", length=" + length +
                ", sleeveType='" + sleeveType + '\'' +
                ", shoulder=" + shoulder +
                ", type='" + type + '\'' +
                ", height=" + height +
                ", wrap=" + wrap +
                ", color='" + color + '\'' +
                ", fit='" + fit + '\'' +
                '}';
    }
}
