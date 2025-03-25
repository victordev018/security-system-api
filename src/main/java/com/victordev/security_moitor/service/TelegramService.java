package com.victordev.security_moitor.service;

import com.victordev.security_moitor.model.dto.alert.AlertResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class TelegramService {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final String TELEGRAM_BOT_TOKEN = "8123136481:AAHdSzUrwQ12KutvaQmoHYlTSA7B6tUMwU0";
    private static final String TELEGRAM_CHAT_ID = "-4614717645";
    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot" + TELEGRAM_BOT_TOKEN + "/sendMessage";

    public void sendAlertToBot(AlertResponseDTO dto) {
        String message = String.format(
                "🚨 *ALERTA: Movimento detectado!*\n" +
                "📅 *Data/Hora*: %s\n" +
                "📍 *Local*: %s\n" +
                "🔍 *Sensor*: %s\n",
                dto.timestamp().format(fmt),
                dto.sensor().location(),
                dto.sensor().identifier()
        );

        // creating JSON to send
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("chat_id", TELEGRAM_CHAT_ID);
        requestBody.put("text", message);
        requestBody.put("parse_mode", "Markdown");

        // Send HTTP request to Telegram API
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(TELEGRAM_API_URL, requestBody, String.class);
    }
}

