package com.ftn.sbnz.service.mapper;

import com.ftn.sbnz.model.models.Fabric;
import com.ftn.sbnz.service.model.FabricEntity;

public class FabricMapper {
    public static Fabric toModel(FabricEntity entity) {
        return new Fabric(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getWidth(),
                entity.getStretchPercentage(),
                entity.getShrinkagePercentage(),
                entity.isHasNap(),
                entity.getDrape(),
                entity.getGsm(),
                entity.getCategory(),
                entity.getPricePerMeter(),
                entity.getInStock()
        );
    }

    public static FabricEntity toEntity(Fabric model) {
        FabricEntity entity = new FabricEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setType(model.getType());
        entity.setWidth(model.getWidth());
        entity.setStretchPercentage(model.getStretchPercentage());
        entity.setShrinkagePercentage(model.getShrinkagePercentage());
        entity.setHasNap(model.isHasNap());
        entity.setDrape(model.getDrape());
        entity.setGsm(model.getGsm());
        entity.setCategory(model.getCategory());
        entity.setPricePerMeter(model.getPricePerMeter());
        entity.setInStock(model.getInStock());
        return entity;
    }
}