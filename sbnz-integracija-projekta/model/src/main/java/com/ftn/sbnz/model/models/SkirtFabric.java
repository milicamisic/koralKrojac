package com.ftn.sbnz.model.models;

import java.io.Serializable;

public class SkirtFabric implements Serializable {
    private Skirt skirt;
    private Fabric fabric;

    public SkirtFabric() {}

    public SkirtFabric(Skirt skirt, Fabric fabric) {
        this.skirt = skirt;
        this.fabric = fabric;
    }

    public Skirt getSkirt() {
        return skirt;
    }

    public void setSkirt(Skirt skirt) {
        this.skirt = skirt;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "SkirtFabric{" +
                "skirt=" + skirt +
                ", fabric=" + fabric +
                '}';
    }
}
