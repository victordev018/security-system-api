package com.victordev.security_moitor.service;

import com.victordev.security_moitor.mappers.SensorMapper;
import com.victordev.security_moitor.model.Sensor;

import com.victordev.security_moitor.model.dto.sensor.SensorRequestDTO;
import com.victordev.security_moitor.model.dto.sensor.SensorResponseDTO;
import com.victordev.security_moitor.repository.SensorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    public SensorService(SensorRepository sensorRepository, SensorMapper sensorMapper) {
        this.sensorRepository = sensorRepository;
        this.sensorMapper = sensorMapper;
    }

    @Transactional
    public SensorResponseDTO save(SensorRequestDTO dto) {
        Sensor savedSensor = this.sensorRepository.save(sensorMapper.toEntity(dto));
        return sensorMapper.toResponseDTO(savedSensor);
    }

    public List<SensorResponseDTO> findAll() {
        return this.sensorRepository.findAll().stream()
                .map(sensorMapper::toResponseDTO)
                .toList();
    }
}
