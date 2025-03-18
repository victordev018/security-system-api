package com.victordev.security_moitor.mappers;

import com.victordev.security_moitor.model.Alert;
import com.victordev.security_moitor.model.Sensor;
import com.victordev.security_moitor.model.dto.alert.AlertRequestDTO;
import com.victordev.security_moitor.model.dto.alert.AlertResponseDTO;
import com.victordev.security_moitor.repository.SensorRepository;
import com.victordev.security_moitor.service.exception.NotFoundError;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@Component
@RequiredArgsConstructor
public class AlertMapper {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    public Alert toEntity(AlertRequestDTO dto) {
        Sensor sensor = sensorRepository.findByIdentifier(dto.sensorIdentifier())
                .orElseThrow(() -> new NotFoundError("Sensor" + dto.sensorIdentifier() + " not found"));
        return new Alert(dto.status(), sensor);
    };
    public AlertResponseDTO toResponse(Alert alert) {
        return new AlertResponseDTO(alert.getId(), alert.getTimestamp(), alert.getStatus(), sensorMapper.toResponseDTO(alert.getSensor()));
    }

}
