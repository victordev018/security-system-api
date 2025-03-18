package com.victordev.security_moitor.model;

import com.victordev.security_moitor.model.enums.AlertStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "alert")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private AlertStatus status;

    @ManyToOne
    private Sensor sensor;

    public Alert(AlertStatus status, Sensor sensor) {
        this.status = status;
        this.sensor = sensor;
        this.timestamp = LocalDateTime.now();
    }

    public Alert() {

    }
}
