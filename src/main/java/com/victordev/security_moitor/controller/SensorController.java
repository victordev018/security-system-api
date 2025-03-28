package com.victordev.security_moitor.controller;

import com.victordev.security_moitor.model.dto.sensor.SensorRequestDTO;
import com.victordev.security_moitor.model.dto.sensor.SensorResponseDTO;
import com.victordev.security_moitor.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public ResponseEntity<SensorResponseDTO> save(@RequestBody SensorRequestDTO dto) {
        return ResponseEntity.status(201).body(this.sensorService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<SensorResponseDTO>> findAll() {
        return ResponseEntity.status(200).body(this.sensorService.findAll());
    }
}
