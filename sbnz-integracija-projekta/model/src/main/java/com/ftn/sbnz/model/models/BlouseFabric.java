package com.ftn.sbnz.model.models;

import java.io.Serializable;

public class BlouseFabric implements Serializable {
    private Blouse blouse;
    private Fabric fabric;
    public BlouseFabric() {}

    public BlouseFabric(Blouse blouse, Fabric fabric) {
        this.blouse = blouse;
        this.fabric = fabric;
    }

    public Blouse getBlouse() {
        return blouse;
    }

    public void setBlouse(Blouse blouse) {
        this.blouse = blouse;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "BlouseFabric{" +
                "blouse=" + blouse +
                ", fabric=" + fabric +
                '}';
    }
}
