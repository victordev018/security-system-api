package com.victordev.security_moitor.repository;

import com.victordev.security_moitor.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Optional<Sensor> findByIdentifier(String identifier);
}
