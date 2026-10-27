package com.senai.monitoramento_maquinas.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senai.monitoramento_maquinas.models.Producao;
import com.senai.monitoramento_maquinas.service.ProducaoService;

@RestController
@RequestMapping("/producao")
public class ProducaoController {

    private final ProducaoService service;

    public ProducaoController(ProducaoService service) {
        this.service = service;
    }

    // RF02 - Registrar dados de produção
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producao registrar(@RequestBody ProducaoRequest request) {

        Producao producao = new Producao();

        producao.setConsumoKw(request.consumoKw());
        producao.setHorarioAcionamento(request.horarioAcionamento());
        producao.setPecasProduzidas(request.pecasProduzidas());

        return service.registrar(request.maquinaId(), producao);
    }

    // RF04 - Consultar produção e consumo
    @GetMapping
    public List<Producao> listar(
            @RequestParam(required = false) Long maquinaId) {

        if (maquinaId != null) {
            return service.buscarPorMaquina(maquinaId);
        }

        return service.listarTodas();
    }
}

// DTO para receber os dados enviados pelo cliente
record ProducaoRequest(
        Long maquinaId,
        Double consumoKw,
        LocalTime horarioAcionamento,
        Integer pecasProduzidas
) {
}