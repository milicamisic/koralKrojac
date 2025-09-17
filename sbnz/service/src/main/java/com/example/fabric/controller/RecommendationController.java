package com.example.fabric.controller;

import com.example.fabric.dtos.ShirtRequest;
import com.example.fabric.model.BodyMeasurements;
import com.example.fabric.model.Evaluation;
import com.example.fabric.model.Fabric;
import com.example.fabric.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommend")
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

//    @PostMapping
//    public Evaluation recommend(@RequestBody ShirtRequest request) {
//        return recommendationService.evaluate(request);
//    }

    @GetMapping("/test-rules")
    public Evaluation testRules() {
        // create a dummy request with your real fields
        ShirtRequest request = new ShirtRequest(
                95.0,   // chestCircumference
                65.0,   // torsoLength
                true,   // hasSleeves
                60.0,   // sleeveLength
                45.0,   // shoulderWidth
                "regular" // fit
        );

        // one test fabric
        Fabric fabric = new Fabric(1L, "Cotton", 12.0, 5.0, 140, false, "high", 120);

        // pass both to service where Drools is executed
        return recommendationService.evaluate(request, List.of(fabric));
    }


}


