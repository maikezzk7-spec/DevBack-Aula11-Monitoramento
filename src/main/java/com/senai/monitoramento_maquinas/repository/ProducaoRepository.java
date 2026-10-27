package com.senai.monitoramento_maquinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.monitoramento_maquinas.models.Producao;

public interface ProducaoRepository extends JpaRepository<Producao, Long> {

    List<Producao> findByMaquinaId(Long maquinaId);

}