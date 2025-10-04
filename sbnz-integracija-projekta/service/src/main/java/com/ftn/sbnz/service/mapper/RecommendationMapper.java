package com.ftn.sbnz.service.mapper;

import com.ftn.sbnz.model.models.FabricRecommendation;
import com.ftn.sbnz.model.models.Recommendation;
import com.ftn.sbnz.service.dto.RecommendationDTO;

public class RecommendationMapper {

    public static RecommendationDTO toDTO(Recommendation rec) {
        if (rec == null) return null;

        return new RecommendationDTO(
                rec.getFabric() != null ? rec.getFabric().getName() : null,
                rec.getFabric() != null ? rec.getFabric().getType() : null,
                rec.getFabric() != null ? rec.getFabric().getPricePerMeter() : 0.0,
                rec.getRequiredLength(),
                rec.getNote()
        );
    }


    public static RecommendationDTO toDTO(FabricRecommendation rec) {
        if (rec == null) return null;

        return new RecommendationDTO(
                rec.getFabric() != null ? rec.getFabric().getName() : null,
                rec.getFabric() != null ? rec.getFabric().getType() : null,
                rec.getFabric() != null ? rec.getFabric().getPricePerMeter() : 0.0,
                rec.getRequiredLength(),
                rec.getNote()
        );
    }
}
