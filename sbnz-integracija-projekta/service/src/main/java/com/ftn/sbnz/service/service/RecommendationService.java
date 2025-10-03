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
    private final KieContainer kieContainer;

    public RecommendationService(FabricService fabricService, KieContainer kieContainer) {
        this.fabricService = fabricService;
        this.kieContainer = kieContainer;
    }

    public List<RecommendationDTO> recommendTShirt(TShirt tshirt) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        // 1. Nova sesija za svaki request
        KieSession kieSession = kieContainer.newKieSession();

        // 2. Insert facts
        fabrics.forEach(f -> kieSession.insert(new TShirtFabric(tshirt, f)));

        // 3. Pokreni pravila
        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila: " + fired);

        // 4. Pokupi rezultate iz sesije
        Collection<?> facts = kieSession.getObjects(o -> o instanceof Recommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((Recommendation) o));
        }

        // 5. Očisti sesiju
        kieSession.dispose();

        return recommendations;
    }

    public List<RecommendationDTO> recommendDress(Dress dress) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        KieSession kieSession = kieContainer.newKieSession();

        for (KiePackage kp : kieSession.getKieBase().getKiePackages()) {
            for (Rule r : kp.getRules()) {
                System.out.println("Loaded rule: " + r.getName());
            }
        }

        List<DressFabric> data = new ArrayList<>();
        for(Fabric f : fabrics) {
            data.add(new DressFabric(dress, f));
        }
        for(DressFabric d : data) {
            kieSession.insert(d);
            System.out.println(d);
        }
//        fabrics.forEach(f -> kieSession.insert(new DressFabric(dress, f)));

        kieSession.getAgenda().getAgendaGroup("dress-base").setFocus();
        kieSession.fireAllRules();

        kieSession.getAgenda().getAgendaGroup("dress-corrections").setFocus();
        kieSession.fireAllRules();

        Collection<?> facts = kieSession.getObjects(o -> o instanceof Recommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((Recommendation) o));
        }

        kieSession.dispose();

        return recommendations;
    }


}
