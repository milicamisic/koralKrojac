package com.ftn.sbnz.model.models;

import java.io.Serializable;

public class PillowcaseFabric implements Serializable {
    private Pillowcase pillowcase;
    private Fabric fabric;

    public PillowcaseFabric() {}

    public PillowcaseFabric(Pillowcase pillowcase, Fabric fabric) {
        this.pillowcase = pillowcase;
        this.fabric = fabric;
    }

    public Pillowcase getPillowcase() {
        return pillowcase;
    }

    public void setPillowcase(Pillowcase pillowcase) {
        this.pillowcase = pillowcase;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    // pomoćni getteri
    public int getLength() { return pillowcase != null ? pillowcase.getLength() : 0; }
    public int getWidth() { return pillowcase != null ? pillowcase.getWidth() : 0; }
    public int getFabricWidth() { return fabric != null ? fabric.getWidth() : 0; }
    public String getFabricCategory() { return fabric != null ? fabric.getCategory() : null; }

    @Override
    public String toString() {
        return "PillowcaseFabric{" +
                "pillowcase=" + pillowcase +
                ", fabric=" + fabric +
                '}';
    }
}
