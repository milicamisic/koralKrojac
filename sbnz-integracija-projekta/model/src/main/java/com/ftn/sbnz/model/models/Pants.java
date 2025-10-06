package com.ftn.sbnz.model.models;

public class Pants extends Garment {
    private int waist;
    private int hips;
    private int length;
    private String fit; // slim, loose, standard

    public Pants() {}

    public Pants(int waist, int hips, int length, String fit) {
        this.waist = waist;
        this.hips = hips;
        this.fit = fit;
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

    @Override
    public String getFit() {
        return fit;
    }

    @Override
    public void setFit(String fit) {
        this.fit = fit;
    }
}
