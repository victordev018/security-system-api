package com.victordev.security_moitor.model;

import com.victordev.security_moitor.model.enums.SensorStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String identifier;

    private String location;

    @Enumerated(EnumType.STRING)
    private SensorStatus status;

    public Sensor(String identifier, String location) {
        this.location = location;
        this.identifier = identifier;
        this.status = SensorStatus.ACTIVATED;
    }

    public Sensor() {

    }
}
