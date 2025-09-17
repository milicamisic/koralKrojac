package com.example.fabric.service;

import com.example.fabric.dtos.ShirtRequest;
import com.example.fabric.model.Evaluation;
import com.example.fabric.model.Fabric;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    private final KieContainer kieContainer;

    @Autowired
    public RecommendationService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Evaluation evaluate(ShirtRequest req, List<Fabric> fabrics) {
        Evaluation eval = new Evaluation();
        KieSession session = kieContainer.newKieSession();

        session.insert(req);
        session.insert(eval);
        fabrics.forEach(session::insert);

        session.fireAllRules();
        session.dispose();

        return eval;
    }


}

