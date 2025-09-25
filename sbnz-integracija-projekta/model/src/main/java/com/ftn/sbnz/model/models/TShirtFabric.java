package com.ftn.sbnz.model.models;

public class TShirtFabric {
    private TShirt tshirt;
    private Fabric fabric;

    public TShirtFabric() {}

    public TShirtFabric(TShirt tshirt, Fabric fabric) {
        this.tshirt = tshirt;
        this.fabric = fabric;
    }

    public TShirt getTshirt() {
        return tshirt;
    }

    public void setTshirt(TShirt tshirt) {
        this.tshirt = tshirt;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "TShirtFabric{" +
                "tshirt=" + tshirt +
                ", fabric=" + fabric +
                '}';
    }
}
