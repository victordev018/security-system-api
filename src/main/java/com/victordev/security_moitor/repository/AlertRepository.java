package com.victordev.security_moitor.repository;

import com.victordev.security_moitor.model.Alert;
import com.victordev.security_moitor.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {
}
