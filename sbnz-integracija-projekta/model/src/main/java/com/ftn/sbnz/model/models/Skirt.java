package com.ftn.sbnz.model.models;

public class Skirt extends Garment {
    private int waist;
    private int hips;
    private int length;
    private String type; // A-line, Pencil, Circle

    public Skirt(int waist, int hips, int length, String type) {
        this.waist = waist;
        this.hips = hips;
        this.length = length;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
