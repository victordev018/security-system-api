package com.victordev.security_moitor.model.dto.sensor;

import com.victordev.security_moitor.model.enums.SensorStatus;

public record SensorResponseDTO(String identifier, String location, SensorStatus status) {
}
