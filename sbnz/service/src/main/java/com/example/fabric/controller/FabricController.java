package com.example.fabric.controller;

import com.example.fabric.model.Fabric;
import com.example.fabric.repo.FabricRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/fabrics")
public class FabricController {
    private final FabricRepository fabricRepository;

    public FabricController(FabricRepository fabricRepository) {
        this.fabricRepository = fabricRepository;
    }

    @GetMapping
    public List<Fabric> getAllFabrics() {
        return fabricRepository.findAll();
    }
}
