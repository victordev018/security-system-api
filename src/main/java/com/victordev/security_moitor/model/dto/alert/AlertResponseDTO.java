package com.victordev.security_moitor.model.dto.alert;

import com.victordev.security_moitor.model.dto.sensor.SensorResponseDTO;
import com.victordev.security_moitor.model.enums.AlertStatus;

import java.time.LocalDateTime;

public record AlertResponseDTO(Long id, LocalDateTime timestamp, AlertStatus status, SensorResponseDTO sensor) {
}
