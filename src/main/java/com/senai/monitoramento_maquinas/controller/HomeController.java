package com.senai.monitoramento_maquinas.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // Página inicial
    @GetMapping("/")
    public Map<String, String> home() {

        return Map.of(
                "mensagem", "Bem-vindo ao Sistema de Monitoramento de Máquinas",
                "aplicacao", "CloudTech Solutions"
        );
    }

    // Versão da aplicação
    @GetMapping("/versao")
    public Map<String, String> versao() {

        return Map.of(
                "aplicacao", "Monitoramento de Máquinas",
                "versao", "1.0.0"
        );
    }
}