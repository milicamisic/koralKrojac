package com.ftn.sbnz.service.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class AlertEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fabric;
    private String type;

    @Column(length = 2000)
    private String message;

    private LocalDateTime createdAt;

    public AlertEntity() {}

    public AlertEntity(String fabric, String type, String message) {
        this.fabric = fabric;
        this.type = type;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setMessage(String details) {
        this.message = details;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AlertEntity{" +
                "id=" + id +
                ", fabric='" + fabric + '\'' +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
