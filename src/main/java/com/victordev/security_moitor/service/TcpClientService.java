package com.victordev.security_moitor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.victordev.security_moitor.model.dto.device.DeviceConfigDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

@Service
public class TcpClientService {

    @Value("${raspberry.server.ip}")
    private String RASPBERRY_IP;

    @Value("${raspberry.server.port}")
    private int RASPBERRY_PORT;

    private final ObjectMapper objectMapper;

    public TcpClientService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void sendDeviceConfig(DeviceConfigDTO config) {
        try (Socket socket = new Socket(RASPBERRY_IP, RASPBERRY_PORT);
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true)) {

            // Convertendo o objeto para JSON e enviando para o raspberry
            String json = objectMapper.writeValueAsString(config);
            writer.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

