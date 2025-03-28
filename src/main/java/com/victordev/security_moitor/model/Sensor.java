package com.victordev.security_moitor.model;

import com.victordev.security_moitor.model.enums.SensorStatus;
import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SensorStatus getStatus() {
        return status;
    }

    public void setStatus(SensorStatus status) {
        this.status = status;
    }
}
