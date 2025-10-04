package com.ftn.sbnz.model.models;

import java.io.Serializable;

public class PantsFabric implements Serializable {
    private Pants pants;
    private Fabric fabric;

    public PantsFabric() {}

    public PantsFabric(Pants pants, Fabric fabric) {
        this.pants = pants;
        this.fabric = fabric;
    }

    public Pants getPants() {
        return pants;
    }

    public void setPants(Pants pants) {
        this.pants = pants;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "PantsFabric{" +
                "pants=" + pants +
                ", fabric=" + fabric +
                '}';
    }
}
