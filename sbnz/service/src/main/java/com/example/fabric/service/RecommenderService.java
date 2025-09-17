package com.example.fabric.service;

import com.example.fabric.dtos.ShirtRequest;
import com.example.fabric.model.Evaluation;
import com.example.fabric.model.Fabric;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommenderService {

    private final KieContainer kieContainer;

    public RecommenderService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Evaluation recommend(ShirtRequest req, List<Fabric> fabrics) {
        KieSession ksession = kieContainer.newKieSession("ksession-rules");

        Evaluation eval = new Evaluation();
        ksession.setGlobal("eval", eval);
        ksession.setGlobal("fabrics", fabrics);

        ksession.insert(req);
        fabrics.forEach(ksession::insert);

        ksession.fireAllRules();
        ksession.dispose();

        return eval;
    }
}

