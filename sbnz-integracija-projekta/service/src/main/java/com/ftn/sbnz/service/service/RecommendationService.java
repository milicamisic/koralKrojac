package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.models.Fabric;
import com.ftn.sbnz.model.models.Recommendation;
import com.ftn.sbnz.model.models.TShirt;
import com.ftn.sbnz.service.dto.RecommendationDTO;
import com.ftn.sbnz.service.mapper.RecommendationMapper;
import com.ftn.sbnz.model.models.TShirtFabric;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RecommendationService {

    private final KieContainer kieContainer;
    private final FabricService fabricService;

    public RecommendationService(KieContainer kieContainer, FabricService fabricService) {
        this.kieContainer = kieContainer;
        this.fabricService = fabricService;
    }

    public List<RecommendationDTO> recommendTShirt(TShirt tshirt) {
        List<Fabric> fabrics = fabricService.findAll();
        List<RecommendationDTO> recommendations = new ArrayList<>();

        // Kreiramo sesiju forwardKsession iz kmodule.xml
        KieSession kieSession = kieContainer.newKieSession("forwardKsession");

        List<TShirtFabric> data = new ArrayList<>();
        for (Fabric fabric : fabrics) {
            data.add(new TShirtFabric(tshirt, fabric));
        }

        for(TShirtFabric tshirtFabric : data) {
            kieSession.insert(tshirtFabric);
//            System.out.println(tshirtFabric);
        }

        // Pokrenemo pravila
        int fired = kieSession.fireAllRules();
        System.out.println("Pokrenuto pravila: " + fired);

        Collection<?> facts = kieSession.getObjects(o -> o instanceof Recommendation);
        for (Object o : facts) {
            Recommendation rec = (Recommendation) o;
            recommendations.add(RecommendationMapper.toDTO(rec));
        }

        kieSession.dispose(); // cleanup
        return recommendations;
    }
}
