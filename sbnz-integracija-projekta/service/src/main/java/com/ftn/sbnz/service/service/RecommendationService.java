package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.models.*;
import com.ftn.sbnz.service.dto.RecommendationDTO;
import com.ftn.sbnz.service.mapper.RecommendationMapper;
import org.kie.api.command.Command;
import org.kie.api.definition.KiePackage;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.kie.api.definition.rule.Rule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    private final FabricService fabricService;
    private final KieSession forwardKsession;

    @Autowired
    public RecommendationService(FabricService fabricService, KieSession forwardKsession) {
        this.fabricService = fabricService;
        this.forwardKsession = forwardKsession;
    }

//    public List<RecommendationDTO> recommendTShirt(TShirt tshirt) {
//        List<Fabric> fabrics = fabricService.findAll();
//        List<RecommendationDTO> recommendations = new ArrayList<>();
//
//        // 🔹 Nova sesija za svaki request (koristimo kopiju forwardKsession-a)
//        KieSession kieSession = forwardKsession.getKieBase().newKieSession();
//
//        fabrics.forEach(f -> kieSession.insert(new TShirtFabric(tshirt, f)));
//
//        int fired = kieSession.fireAllRules();
//        System.out.println("Pokrenuto pravila: " + fired);
//
//        Collection<?> facts = kieSession.getObjects(o -> o instanceof Recommendation);
//        for (Object o : facts) {
//            recommendations.add(RecommendationMapper.toDTO((Recommendation) o));
//        }
//
//        kieSession.dispose();
//        return recommendations;
//    }

    public List<RecommendationDTO> recommendDress(Dress dress) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        // 🔹 Ponovo koristimo novu instancu sesije
        KieSession kieSession = forwardKsession.getKieBase().newKieSession();

        // Debug – ispiši sva pravila
        for (KiePackage kp : kieSession.getKieBase().getKiePackages()) {
            for (Rule r : kp.getRules()) {
                System.out.println("Loaded rule: " + r.getName());
            }
        }

        fabrics.forEach(f -> kieSession.insert(new DressFabric(dress, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila za dress: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof FabricRecommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((FabricRecommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }

    public List<RecommendationDTO> recommendBlouse(Blouse blouse) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        // 🔹 Create a new KieSession instance for each request
        KieSession kieSession = forwardKsession.getKieBase().newKieSession();

        // 🔍 Debug – print all loaded rules
        for (KiePackage kp : kieSession.getKieBase().getKiePackages()) {
            for (Rule r : kp.getRules()) {
                System.out.println("Loaded rule: " + r.getName());
            }
        }

        // 🧵 Insert all blouse–fabric pairs
        fabrics.forEach(f -> kieSession.insert(new BlouseFabric(blouse, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("✅ Fired rules for blouse: " + fired);

        // 🪡 Collect all FabricRecommendation results
        Collection<?> facts = kieSession.getObjects(o -> o instanceof FabricRecommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((FabricRecommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }


    // 👕 Shirt
    public List<RecommendationDTO> recommendShirt(Shirt shirt) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        KieSession kieSession = forwardKsession.getKieBase().newKieSession();
        fabrics.forEach(f -> kieSession.insert(new ShirtFabric(shirt, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila za shirt: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof FabricRecommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((FabricRecommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }

    // 👖 Pants
    public List<RecommendationDTO> recommendPants(Pants pants) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        KieSession kieSession = forwardKsession.getKieBase().newKieSession();
        fabrics.forEach(f -> kieSession.insert(new PantsFabric(pants, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila za pants: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof FabricRecommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((FabricRecommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }

    // 👗 Skirt
    public List<RecommendationDTO> recommendSkirt(Skirt skirt) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        KieSession kieSession = forwardKsession.getKieBase().newKieSession();
        fabrics.forEach(f -> kieSession.insert(new SkirtFabric(skirt, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila za skirt: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof FabricRecommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((FabricRecommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }

    // 🧶 Sweater
    public List<RecommendationDTO> recommendSweater(Sweater sweater) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        KieSession kieSession = forwardKsession.getKieBase().newKieSession();
        fabrics.forEach(f -> kieSession.insert(new SweaterFabric(sweater, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila za sweater: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof FabricRecommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((FabricRecommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }

    // 🪟 Curtain
    public List<RecommendationDTO> recommendCurtain(Curtain curtain) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        KieSession kieSession = forwardKsession.getKieBase().newKieSession();
        fabrics.forEach(f -> kieSession.insert(new CurtainFabric(curtain, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila za curtain: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof FabricRecommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((FabricRecommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }

    // 🍽️ Tablecloth
    public List<RecommendationDTO> recommendTablecloth(Tablecloth tablecloth) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        KieSession kieSession = forwardKsession.getKieBase().newKieSession();
        fabrics.forEach(f -> kieSession.insert(new TableclothFabric(tablecloth, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila za tablecloth: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof FabricRecommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((FabricRecommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }

    // 🛏️ Bedsheet
    public List<RecommendationDTO> recommendBedsheet(BedSheet bedsheet) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        KieSession kieSession = forwardKsession.getKieBase().newKieSession();
        fabrics.forEach(f -> kieSession.insert(new BedSheetFabric(bedsheet, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila za bedsheet: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof FabricRecommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((FabricRecommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }

    // 🛋️ Pillowcase
    public List<RecommendationDTO> recommendPillowcase(Pillowcase pillowcase) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        KieSession kieSession = forwardKsession.getKieBase().newKieSession();
        fabrics.forEach(f -> kieSession.insert(new PillowcaseFabric(pillowcase, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila za pillowcase: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof FabricRecommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((FabricRecommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }
}
