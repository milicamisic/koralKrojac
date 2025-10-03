package com.ftn.sbnz.service.service;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void sale(@RequestParam String fabric, @RequestParam double qty) {
        eventService.insertSale(fabric, qty);
    }

    @PostMapping("/purchase")
    public void purchase(@RequestParam String fabric, @RequestParam double qty) {
        eventService.insertPurchase(fabric, qty);
    }
}
