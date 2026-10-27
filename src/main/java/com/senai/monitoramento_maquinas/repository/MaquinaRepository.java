package com.senai.monitoramento_maquinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.monitoramento_maquinas.models.Maquina;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {

}