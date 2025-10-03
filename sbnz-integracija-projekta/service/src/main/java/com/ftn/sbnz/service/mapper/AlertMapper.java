package com.ftn.sbnz.service.mapper;

import com.ftn.sbnz.model.events.StockAlert;
import com.ftn.sbnz.service.model.AlertEntity;

public class AlertMapper {
    public static AlertEntity toEntity(StockAlert alert) {
        return new AlertEntity(
                alert.getFabric(),
                alert.getType(),
                alert.getMessage()
        );
    }
}