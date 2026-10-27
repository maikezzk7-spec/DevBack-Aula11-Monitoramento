package com.senai.monitoramento_maquinas.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producoes")
public class Producao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maquina_id", nullable = false)
    private Maquina maquina;

    @Column(nullable = false)
    private Double consumoKw;

    @Column(nullable = false)
    private LocalTime horarioAcionamento;

    @Column(nullable = false)
    private Integer pecasProduzidas;

    @Column(nullable = false)
    private LocalDate dataRegistro;

    // Construtor vazio exigido pelo JPA
    public Producao() {
    }

    // Construtor com os dados de produção
    public Producao(
            Maquina maquina,
            Double consumoKw,
            LocalTime horarioAcionamento,
            Integer pecasProduzidas) {

        this.maquina = maquina;
        this.consumoKw = consumoKw;
        this.horarioAcionamento = horarioAcionamento;
        this.pecasProduzidas = pecasProduzidas;
        this.dataRegistro = LocalDate.now();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Double getConsumoKw() {
        return consumoKw;
    }

    public void setConsumoKw(Double consumoKw) {
        this.consumoKw = consumoKw;
    }

    public LocalTime getHorarioAcionamento() {
        return horarioAcionamento;
    }

    public void setHorarioAcionamento(LocalTime horarioAcionamento) {
        this.horarioAcionamento = horarioAcionamento;
    }

    public Integer getPecasProduzidas() {
        return pecasProduzidas;
    }

    public void setPecasProduzidas(Integer pecasProduzidas) {
        this.pecasProduzidas = pecasProduzidas;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}