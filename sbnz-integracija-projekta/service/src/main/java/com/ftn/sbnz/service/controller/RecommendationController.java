package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.models.*;

import com.ftn.sbnz.service.dto.*;
import com.ftn.sbnz.service.service.RecommendationService;
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

//    @PostMapping("/tshirt")
//    public List<RecommendationDTO> recommendTShirt(@RequestBody TShirtRequest request) {
//        // Pretvaranje requesta u modele
//        TShirt tshirt = new TShirt();
//        tshirt.setBust(request.getBust());
//        tshirt.setWaist(request.getWaist());
//        tshirt.setTorsoLength(request.getTorsoLength());
//        tshirt.setHasSleeves(request.isHasSleeves());
//        tshirt.setSleeveLength(request.getSleeveLength());
//        tshirt.setShoulder(request.getShoulder());
//        tshirt.setFit(request.getFit());
//
//        return recommendationService.recommendTShirt(tshirt);
//    }

    @PostMapping("/dress")
    public List<RecommendationDTO> recommendDress(@RequestBody DressRequest request) {
        System.out.println(request);
        Dress dress = new Dress();
        dress.setType(request.getType());
        dress.setBust(request.getBust());
        dress.setWaist(request.getWaist());
        dress.setHips(request.getHips());
        dress.setShoulder(request.getShoulder());
        dress.setHeight(request.getHeight());
        dress.setLength(request.getLength());
        dress.setWrap(request.isWrap());
        dress.setSleeveType(request.getSleeveType());
        System.out.println(dress);
        return recommendationService.recommendDress(dress);
    }

    // 👕 Shirt
    @PostMapping("/shirt")
    public List<RecommendationDTO> recommendShirt(@RequestBody ShirtRequest request) {
        Shirt shirt = new Shirt();
        shirt.setBust(request.getBust());
        shirt.setTorsoLength(request.getTorsoLength());
        shirt.setSleeveType(request.getSleeveType());
        shirt.setShoulder(request.getShoulderWidth());
        shirt.setFit(request.getFit());

        return recommendationService.recommendShirt(shirt);
    }

    // blouse
    @PostMapping("/blouse")
    public List<RecommendationDTO> recommendBlouse(@RequestBody BlouseRequest request) {
        Blouse blouse = new Blouse();
        blouse.setBust(request.getBust());
        blouse.setWaist(request.getWaist());
        blouse.setTorsoLength(request.getTorsoLength());
        blouse.setShoulder(request.getShoulder());
        blouse.setCollarType(request.getCollarType());
        blouse.setSleeveType(request.getSleeveType());
        blouse.setFit(request.getFit());

        return recommendationService.recommendBlouse(blouse);
    }

    // 👖 Pants
    @PostMapping("/pants")
    public List<RecommendationDTO> recommendPants(@RequestBody PantsRequest request) {
        Pants pants = new Pants();
        pants.setWaist(request.getWaist());
        pants.setHips(request.getHips());
        pants.setLength(request.getLength());
        pants.setFit(request.getFit());

        return recommendationService.recommendPants(pants);
    }

    // 👗 Skirt
    @PostMapping("/skirt")
    public List<RecommendationDTO> recommendSkirt(@RequestBody SkirtRequest request) {
        Skirt skirt = new Skirt();
        skirt.setType(request.getType());
        skirt.setWaist(request.getWaist());
        skirt.setHips(request.getHips());
        skirt.setLength(request.getLength());

        return recommendationService.recommendSkirt(skirt);
    }

    // 🧶 Sweater
    @PostMapping("/sweater")
    public List<RecommendationDTO> recommendSweater(@RequestBody SweaterRequest request) {
        Sweater sweater = new Sweater();
        sweater.setBust(request.getBust());
        sweater.setTorsoLength(request.getTorsoLength());
        sweater.setSleeveLength(request.getSleeveLength());
        sweater.setShoulder(request.getShoulderWidth());
        sweater.setFit(request.getFit());
        sweater.setYarnThickness(request.getYarnThickness());

        return recommendationService.recommendSweater(sweater);
    }

    // 🪟 Curtain
    @PostMapping("/curtain")
    public List<RecommendationDTO> recommendCurtain(@RequestBody CurtainRequest request) {
        Curtain curtain = new Curtain();
        curtain.setHeight(request.getHeight());
        curtain.setWidth(request.getWidth());
        curtain.setPleatFactor(request.getPleatFactor());
        curtain.setHangingType(request.getHangingType());

        return recommendationService.recommendCurtain(curtain);
    }

    // 🍽️ Tablecloth
    @PostMapping("/tablecloth")
    public List<RecommendationDTO> recommendTablecloth(@RequestBody TableclothRequest request) {
        Tablecloth tablecloth = new Tablecloth();
        tablecloth.setShape(request.getShape());
        tablecloth.setLength(request.getLength());
        tablecloth.setWidth(request.getWidth());
        tablecloth.setOverhang(request.getOverhang());

        return recommendationService.recommendTablecloth(tablecloth);
    }

    // 🛏️ Bedsheet
    @PostMapping("/bedsheet")
    public List<RecommendationDTO> recommendBedsheet(@RequestBody BedsheetRequest request) {
        BedSheet bedsheet = new BedSheet();
        bedsheet.setType(request.getType());
        bedsheet.setLength(request.getLength());
        bedsheet.setWidth(request.getWidth());
        bedsheet.setHeight(request.getHeight());
        bedsheet.setOverhang(request.getOverhang());

        return recommendationService.recommendBedsheet(bedsheet);
    }

    // 🛋️ Pillowcase
    @PostMapping("/pillowcase")
    public List<RecommendationDTO> recommendPillowcase(@RequestBody PillowcaseRequest request) {
        Pillowcase pillowcase = new Pillowcase();
        pillowcase.setLength(request.getLength());
        pillowcase.setWidth(request.getWidth());

        return recommendationService.recommendPillowcase(pillowcase);
    }
}