package com.ftn.sbnz.model.models;

public class DressFabric {
    private Dress dress;
    private Fabric fabric;

    public DressFabric() {}

    public DressFabric(Dress dress, Fabric fabric) {
        this.dress = dress;
        this.fabric = fabric;
    }

    public Dress getDress() {
        return dress;
    }

    public void setDress(Dress dress) {
        this.dress = dress;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public String getDressType() {
        return dress != null ? dress.getType() : null;
    }

    // 👉 Pomoćni getter za length
    public int getDressLength() {
        return dress != null ? dress.getLength() : 0;
    }

    @Override
    public String toString() {
        return "DressFabric{" +
                "dress=" + dress +
                ", fabric=" + fabric +
                '}';
    }
}
