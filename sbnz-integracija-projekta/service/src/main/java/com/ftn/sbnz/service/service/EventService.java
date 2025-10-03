package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.events.PurchaseEvent;
import com.ftn.sbnz.model.events.SaleEvent;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventService {
    private final KieSession cepKsession;

    @Autowired
    public EventService(KieSession cepKsession) {
        this.cepKsession = cepKsession;
    }

    public void insertSale(String fabric, double qty) {
        SaleEvent event = new SaleEvent(fabric, qty);
        cepKsession.insert(event);
        cepKsession.fireAllRules();
    }

    public void insertPurchase(String fabric, double qty) {
        PurchaseEvent event = new PurchaseEvent(fabric, qty);
        cepKsession.insert(event);
        cepKsession.fireAllRules();
    }
}
