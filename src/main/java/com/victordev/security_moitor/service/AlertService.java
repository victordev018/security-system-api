package com.victordev.security_moitor.service;

import com.victordev.security_moitor.mappers.AlertMapper;
import com.victordev.security_moitor.model.Alert;
import com.victordev.security_moitor.model.dto.alert.AlertRequestDTO;
import com.victordev.security_moitor.model.dto.alert.AlertResponseDTO;
import com.victordev.security_moitor.repository.AlertRepository;
import com.victordev.security_moitor.repository.SensorRepository;
import com.victordev.security_moitor.service.exception.NotFoundError;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private final AlertRepository alertRepository;
    private final SensorRepository sensorRepository;
    private final AlertMapper alertMapper;

    public AlertService(AlertRepository alertRepository, SensorRepository sensorRepository, AlertMapper alertMapper) {
        this.alertRepository = alertRepository;
        this.sensorRepository = sensorRepository;
        this.alertMapper = alertMapper;
    }

    @Transactional
    public AlertResponseDTO save(AlertRequestDTO dto) {
        this.sensorRepository.findByIdentifier(dto.sensorIdentifier())
                .orElseThrow(() -> new NotFoundError("Sensor " + dto.sensorIdentifier() + " not found"));
        Alert savedAlert = this.alertRepository.save(alertMapper.toEntity(dto));
        return alertMapper.toResponse(savedAlert);
    }

    @Transactional
    public List<AlertResponseDTO> findAll() {
        return this.alertRepository.findAll().stream()
                .map(alertMapper::toResponse)
                .toList();
    }
}
