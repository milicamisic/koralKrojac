package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.models.Fabric;
import com.ftn.sbnz.service.model.FabricEntity;
import com.ftn.sbnz.service.service.FabricService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fabrics")
public class FabricController {

    private final FabricService fabricService;

    public FabricController(FabricService fabricService) {
        this.fabricService = fabricService;
    }

    @GetMapping
    public List<Fabric> getAllFabrics() {
        return fabricService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabric> getFabricById(@PathVariable Long id) {
        return fabricService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fabric createFabric(@RequestBody Fabric fabric) {
        return fabricService.save(fabric);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabric> updateFabric(@PathVariable Long id, @RequestBody Fabric fabric) {
        return fabricService.findById(id)
                .map(existing -> {
                    fabric.setId(id);
                    return ResponseEntity.ok(fabricService.save(fabric));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabric(@PathVariable Long id) {
        if (fabricService.findById(id).isPresent()) {
            fabricService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
