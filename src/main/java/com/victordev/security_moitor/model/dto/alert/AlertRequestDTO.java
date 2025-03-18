package com.victordev.security_moitor.model.dto.alert;

import com.victordev.security_moitor.model.enums.AlertStatus;

public record AlertRequestDTO(AlertStatus status, String sensorIdentifier) {
}
