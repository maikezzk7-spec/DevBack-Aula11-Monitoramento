package com.senai.monitoramento_maquinas.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.monitoramento_maquinas.models.Maquina;
import com.senai.monitoramento_maquinas.models.Producao;
import com.senai.monitoramento_maquinas.repository.ProducaoRepository;

@Service
public class ProducaoService {

    private final ProducaoRepository repository;
    private final MaquinaService maquinaService;

    // Injeção de dependências
    public ProducaoService(
            ProducaoRepository repository,
            MaquinaService maquinaService) {

        this.repository = repository;
        this.maquinaService = maquinaService;
    }

    // RF02 - Registrar dados de produção
    public Producao registrar(
            Long maquinaId,
            Producao producao) {

        // Verifica se a máquina existe
        Maquina maquina = maquinaService.buscarPorId(maquinaId);

        // Valida o consumo
        if (producao.getConsumoKw() == null ||
                producao.getConsumoKw() < 0 ||
                !Double.isFinite(producao.getConsumoKw())) {

            throw new IllegalArgumentException(
                    "O consumo deve ser um número válido e não negativo."
            );
        }

        // Valida o horário
        if (producao.getHorarioAcionamento() == null) {
            throw new IllegalArgumentException(
                    "O horário de acionamento é obrigatório."
            );
        }

        // Valida a quantidade de peças
        if (producao.getPecasProduzidas() == null ||
                producao.getPecasProduzidas() < 0) {

            throw new IllegalArgumentException(
                    "A quantidade de peças não pode ser negativa."
            );
        }

        // Associa o registro à máquina
        producao.setMaquina(maquina);

        // Define a data do registro
        producao.setDataRegistro(LocalDate.now());

        // Salva no banco de dados
        return repository.save(producao);
    }

    // RF04 - Consultar todos os registros de produção
    public List<Producao> listarTodas() {
        return repository.findAll();
    }

    // Consultar histórico de uma máquina
    public List<Producao> buscarPorMaquina(Long maquinaId) {

        // Verifica se a máquina existe
        maquinaService.buscarPorId(maquinaId);

        return repository.findByMaquinaId(maquinaId);
    }
}