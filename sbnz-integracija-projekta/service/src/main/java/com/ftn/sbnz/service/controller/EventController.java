package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.service.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/sale")
    public ResponseEntity<Void> sale(@RequestParam String fabric, @RequestParam double qty) {
        System.out.println("📥 [Controller] Stigao sale request: fabric=" + fabric + ", qty=" + qty);
        eventService.insertSale(fabric, qty);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/purchase")
    public void purchase(@RequestParam String fabric, @RequestParam double qty) {
        eventService.insertPurchase(fabric, qty);
    }
}
