package com.ftn.sbnz.service.repo;

import com.ftn.sbnz.service.model.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
}
