package com.ftn.sbnz.model.events;

public class StockAlert {
    private String fabric;
    private String type;   // npr. "DEMAND_SPIKE", "SALES_OVER_PURCHASES", "STAGNATION"
    private String message;

    public StockAlert() {}

    public StockAlert(String fabric, String type, String message) {
        this.fabric = fabric;
        this.type = type;
        this.message = message;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + fabric + " → " + message;
    }
}