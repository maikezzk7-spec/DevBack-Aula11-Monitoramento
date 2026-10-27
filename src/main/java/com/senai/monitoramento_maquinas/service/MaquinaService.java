package com.senai.monitoramento_maquinas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.monitoramento_maquinas.models.Maquina;
import com.senai.monitoramento_maquinas.repository.MaquinaRepository;

@Service
public class MaquinaService {

    // Repositório responsável pelo acesso ao banco
    private final MaquinaRepository repository;

    // Injeção de dependência pelo construtor
    public MaquinaService(MaquinaRepository repository) {
        this.repository = repository;
    }

    // RF01 - Cadastrar máquina
    public Maquina cadastrar(Maquina maquina) {

        if (maquina.getNome() == null || maquina.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome da máquina é obrigatório.");
        }

        if (maquina.getTipo() == null || maquina.getTipo().isBlank()) {
            throw new IllegalArgumentException("O tipo da máquina é obrigatório.");
        }

        if (maquina.getSetor() == null || maquina.getSetor().isBlank()) {
            throw new IllegalArgumentException("O setor da máquina é obrigatório.");
        }

        if (maquina.getStatus() == null || maquina.getStatus().isBlank()) {
            throw new IllegalArgumentException("O status da máquina é obrigatório.");
        }

        return repository.save(maquina);
    }

    // RF03 - Consultar máquinas cadastradas
    public List<Maquina> listarTodas() {
        return repository.findAll();
    }

    // Consultar uma máquina pelo ID
    public Maquina buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Máquina não encontrada com ID: " + id
                        )
                );
    }
}