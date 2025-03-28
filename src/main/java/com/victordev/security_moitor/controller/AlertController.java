package com.victordev.security_moitor.controller;

import com.victordev.security_moitor.model.dto.alert.AlertRequestDTO;
import com.victordev.security_moitor.model.dto.alert.AlertResponseDTO;
import com.victordev.security_moitor.service.AlertService;
import com.victordev.security_moitor.service.TelegramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alert")
public class AlertController {

    private final AlertService alertService;
    private final TelegramService telegramService;

    public AlertController(AlertService alertService, TelegramService telegramService) {
        this.alertService = alertService;
        this.telegramService = telegramService;
    }

    @PostMapping
    public ResponseEntity<AlertResponseDTO> save(@RequestBody AlertRequestDTO dto) {
        AlertResponseDTO response = this.alertService.save(dto);
        telegramService.sendAlertToBot(response);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AlertResponseDTO>> findAll() {
        return ResponseEntity.status(200).body(this.alertService.findAll());
    }
}
