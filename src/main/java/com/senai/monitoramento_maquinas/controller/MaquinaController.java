package com.senai.monitoramento_maquinas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senai.monitoramento_maquinas.models.Maquina;
import com.senai.monitoramento_maquinas.service.MaquinaService;

@RestController
@RequestMapping("/maquinas")
public class MaquinaController {

    private final MaquinaService service;

    public MaquinaController(MaquinaService service) {
        this.service = service;
    }

    // RF01 - Cadastrar máquina
    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public Maquina cadastrar(@RequestBody Maquina maquina) {
        return service.cadastrar(maquina);
    }

    // RF03 - Listar máquinas cadastradas
    @GetMapping
    public List<Maquina> listar() {
        return service.listarTodas();
    }

    // Consultar máquina por ID
    @GetMapping("/{id}")
    public Maquina buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}