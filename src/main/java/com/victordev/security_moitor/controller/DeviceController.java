package com.victordev.security_moitor.controller;

import com.victordev.security_moitor.model.dto.device.DeviceConfigDTO;
import com.victordev.security_moitor.service.TcpClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private final TcpClientService tcpClientService;

    public DeviceController(TcpClientService tcpClientService) {
        this.tcpClientService = tcpClientService;
    }

    @PostMapping("/config")
    public ResponseEntity<String> sendConfig(@RequestBody DeviceConfigDTO config) {
        tcpClientService.sendDeviceConfig(config);
        return ResponseEntity.ok("Configuração enviada: " + config);
    }
}
