package com.ftn.sbnz.model.models;

import java.io.Serializable;

public class CurtainFabric implements Serializable {

    private Curtain curtain;
    private Fabric fabric;

    public CurtainFabric() {
    }

    public CurtainFabric(Curtain curtain, Fabric fabric) {
        this.curtain = curtain;
        this.fabric = fabric;
    }

    public Curtain getCurtain() {
        return curtain;
    }

    public void setCurtain(Curtain curtain) {
        this.curtain = curtain;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public String toString() {
        return "CurtainFabric{" +
                "curtain=" + (curtain != null ? curtain.toString() : "null") +
                ", fabric=" + (fabric != null ? fabric.getName() : "null") +
                '}';
    }
}
