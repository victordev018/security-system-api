package com.victordev.security_moitor.mappers;

import com.victordev.security_moitor.model.Sensor;
import com.victordev.security_moitor.model.dto.sensor.SensorRequestDTO;
import com.victordev.security_moitor.model.dto.sensor.SensorResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {

    public Sensor toEntity(SensorRequestDTO dto) {
        Sensor sensor = new Sensor(dto.identifier(), dto.location());
        return sensor;
    }
    public SensorResponseDTO toResponseDTO(Sensor sensor) {
        return new SensorResponseDTO(sensor.getIdentifier(), sensor.getLocation(), sensor.getStatus());
    }
}
