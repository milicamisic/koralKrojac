package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.models.TShirt;
import com.ftn.sbnz.service.dto.RecommendationDTO;
import com.ftn.sbnz.service.service.RecommendationService;
import com.ftn.sbnz.service.dto.TShirtRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/tshirt")
    public List<RecommendationDTO> recommendTShirt(@RequestBody TShirtRequest request) {
        // Pretvaranje requesta u modele
        TShirt tshirt = new TShirt();
        tshirt.setBust(request.getBust());
        tshirt.setWaist(request.getWaist());
        tshirt.setTorsoLength(request.getTorsoLength());
        tshirt.setHasSleeves(request.isHasSleeves());
        tshirt.setSleeveLength(request.getSleeveLength());
        tshirt.setShoulder(request.getShoulder());
        tshirt.setFit(request.getFit());

        return recommendationService.recommendTShirt(tshirt);
    }
}
