package com.ftn.sbnz.model.models;

import java.io.Serializable;

public class SweaterFabric implements Serializable {
    private Sweater sweater;
    private Fabric fabric;

    public SweaterFabric() {}

    public SweaterFabric(Sweater sweater, Fabric fabric) {
        this.sweater = sweater;
        this.fabric = fabric;
    }

    public Sweater getSweater() {
        return sweater;
    }

    public void setSweater(Sweater sweater) {
        this.sweater = sweater;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "SweaterFabric{" +
                "sweater=" + sweater +
                ", fabric=" + fabric +
                '}';
    }
}
