package com.ftn.sbnz.model.events;

import java.time.LocalDateTime;

public class SaleEvent {
    private String fabricName;
    private double quantity; // u metrima
    private LocalDateTime timestamp;

    public SaleEvent(String fabricName, double quantity, LocalDateTime timestamp) {
        this.fabricName = fabricName;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public String getFabricName() {
        return fabricName;
    }

    public void setFabricName(String fabricName) {
        this.fabricName = fabricName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

