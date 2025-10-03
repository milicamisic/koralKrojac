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

    public List<RecommendationDTO> recommendTShirt(TShirt tshirt) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        // 🔹 Nova sesija za svaki request (koristimo kopiju forwardKsession-a)
        KieSession kieSession = forwardKsession.getKieBase().newKieSession();

        fabrics.forEach(f -> kieSession.insert(new TShirtFabric(tshirt, f)));

        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof Recommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((Recommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }

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

        Collection<?> facts = kieSession.getObjects(o -> o instanceof Recommendation);
        for (Object o : facts) {
            recommendations.add(RecommendationMapper.toDTO((Recommendation) o));
        }

        kieSession.dispose();
        return recommendations;
    }
}
