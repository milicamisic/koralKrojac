package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.service.model.AlertEntity;
import com.ftn.sbnz.service.repo.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/alerts")
public class AlertController {

    @Autowired
    private AlertRepository alertRepository;

    public AlertController() {
    }

    @GetMapping
    public ResponseEntity<List<AlertEntity>> getAlerts() {
        List<AlertEntity> alerts = alertRepository.findAll();
        return ResponseEntity.ok(alerts);
    }
}