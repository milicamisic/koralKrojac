package com.ftn.sbnz.model.models;

import java.io.Serializable;

public class ShirtFabric implements Serializable {
    private Shirt shirt;
    private Fabric fabric;

    public ShirtFabric() {}

    public ShirtFabric(Shirt shirt, Fabric fabric) {
        this.shirt = shirt;
        this.fabric = fabric;
    }

    public Shirt getShirt() {
        return shirt;
    }

    public void setShirt(Shirt shirt) {
        this.shirt = shirt;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "ShirtFabric{" +
                "shirt=" + shirt +
                ", fabric=" + fabric +
                '}';
    }
}
