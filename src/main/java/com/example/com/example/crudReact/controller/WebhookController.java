package com.example.com.example.crudReact.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @PostMapping("/github")
    public ResponseEntity<String> receiveWebhook(@RequestBody String payload) {
        // Aquí puedes procesar el JSON recibido
        System.out.println("Webhook recibido: " + payload);
        return ResponseEntity.ok("Webhook recibido");
    }
}
