package com.ftn.sbnz.service.dto;

public class DressRequest {
    private String type;        // A-line, Circle, Bodycon, Shift
    private int bust;           // obim grudi
    private int hips;           // obim kukova
    private int shoulder;       // ramena
    private int height;         // visina korisnika
    private int length;    // dužina haljine
    private boolean wrap;       // wrap ili ne
    private String sleeveType;  // NONE, SHORT, LONG

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBust() {
        return bust;
    }

    public void setBust(int bust) {
        this.bust = bust;
    }

    public int getHips() {
        return hips;
    }

    public void setHips(int hips) {
        this.hips = hips;
    }

    public int getShoulder() {
        return shoulder;
    }

    public void setShoulder(int shoulder) {
        this.shoulder = shoulder;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isWrap() {
        return wrap;
    }

    public void setWrap(boolean wrap) {
        this.wrap = wrap;
    }

    public String getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }
}
