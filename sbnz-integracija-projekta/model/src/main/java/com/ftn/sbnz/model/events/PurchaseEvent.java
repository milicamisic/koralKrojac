package com.ftn.sbnz.model.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Role(Role.Type.EVENT)
@Timestamp("timestamp")
@Expires("90d")
public class PurchaseEvent {
    private String fabricName;
    private double quantity;
    private long timestamp;

    public PurchaseEvent(String fabricName, double quantity) {
        this.fabricName = fabricName;
        this.quantity = quantity;
        this.timestamp = System.currentTimeMillis(); // default sada
    }

    public PurchaseEvent(String fabricName, double quantity, long timestamp) {
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime toLocalDateTime() {
        return Instant.ofEpochMilli(timestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    @Override
    public String toString() {
        return "PurchaseEvent{" +
                "fabricName='" + fabricName + '\'' +
                ", quantity=" + quantity +
                ", timestamp=" + toLocalDateTime() +
                '}';
    }
}
