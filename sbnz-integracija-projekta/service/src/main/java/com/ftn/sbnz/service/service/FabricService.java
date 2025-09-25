package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.models.Fabric;
import com.ftn.sbnz.service.mapper.FabricMapper;
import com.ftn.sbnz.service.model.FabricEntity;
import com.ftn.sbnz.service.repo.FabricRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FabricService {

    private final FabricRepository fabricRepository;

    public FabricService(FabricRepository fabricRepository) {
        this.fabricRepository = fabricRepository;
    }

    public List<Fabric> findAll() {
        return fabricRepository.findAll()
                .stream()
                .map(FabricMapper::toModel)
                .collect(Collectors.toList());
    }

    public Optional<Fabric> findById(Long id) {
        return fabricRepository.findById(id)
                .map(FabricMapper::toModel);
    }

    public Fabric save(Fabric fabric) {
        FabricEntity entity = FabricMapper.toEntity(fabric);
        return FabricMapper.toModel(fabricRepository.save(entity));
    }

    public void delete(Long id) {
        fabricRepository.deleteById(id);
    }
}
