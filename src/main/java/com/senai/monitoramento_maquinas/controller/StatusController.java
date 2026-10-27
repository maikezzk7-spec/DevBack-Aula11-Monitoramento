package com.senai.monitoramento_maquinas.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    // RF05 - Verificar status da aplicação
    @GetMapping("/status")
    public Map<String, String> verificarStatus() {

        return Map.of(
                "status", "online",
                "mensagem", "Aplicação de monitoramento em execução"
        );
    }
}