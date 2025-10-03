package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.events.PurchaseEvent;
import com.ftn.sbnz.model.events.SaleEvent;
import com.ftn.sbnz.model.events.StockAlert;
import com.ftn.sbnz.service.mapper.AlertMapper;
import com.ftn.sbnz.service.repo.AlertRepository;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final KieSession cepKsession;
    private final List<StockAlert> alerts = new CopyOnWriteArrayList<>();
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    public EventService(KieSession cepKsession, SimpMessagingTemplate messagingTemplate) {
        this.cepKsession = cepKsession;
        this.messagingTemplate = messagingTemplate;

        cepKsession.addEventListener(new org.kie.api.event.rule.DefaultAgendaEventListener() {
            @Override
            public void afterMatchFired(org.kie.api.event.rule.AfterMatchFiredEvent event) {
                System.out.println("🎯 [EventListener] Pravilo aktivirano: " + event.getMatch().getRule().getName());

            }
        });

        cepKsession.addEventListener(new org.kie.api.event.rule.DefaultRuleRuntimeEventListener() {
            @Override
            public void objectInserted(org.kie.api.event.rule.ObjectInsertedEvent event) {
                if (event.getObject() instanceof StockAlert) {
                    StockAlert alert = (StockAlert) event.getObject();
                    System.out.println("🚨 [RuleRuntimeListener] StockAlert insertovan: " + alert);
                    alerts.add(alert);
                    alertRepository.save(AlertMapper.toEntity(alert));
                    messagingTemplate.convertAndSend("/topic/alerts", alert);
                }
            }
        });


    }

    public void insertSale(String fabric, double qty) {
        SaleEvent event = new SaleEvent(fabric, qty);
        System.out.println("🟢 [Service] Ubacujem SaleEvent: " + event);
        cepKsession.insert(event);
        int fired = cepKsession.fireAllRules();
        System.out.println("🔥 [Service] Pravila pokrenuta, count=" + fired);
    }

    public void insertPurchase(String fabric, double qty) {
        PurchaseEvent event = new PurchaseEvent(fabric, qty);
        cepKsession.insert(event);
        cepKsession.fireAllRules();
    }

    public List<StockAlert> getAlerts() {
        return alerts;
    }
}
