package br.com.fiap.gs.lflTechnology.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Entity
@SequenceGenerator(name = "preco", sequenceName = "SQ_LFL_PRECO", allocationSize = 1)
@Table(name = "T_LFL_PRECO")
public class Preco {

    @Id
    @GeneratedValue(generator = "preco", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_preco")
    private Integer id;

    @Column(name = "vl_preco_diaria", nullable = false)
    private BigDecimal precoDiaria;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_atualizacao")
    private Calendar dataAtualizacao;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cd_condicao_pagamento")
    private CondicaoPagamento condicaoPagamento;


    public BigDecimal getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(BigDecimal precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public Calendar getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Calendar dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public CondicaoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

    public BigDecimal calculaPrecoTotal(Quarto quarto) {
        Integer qtDiasReservados = quarto.getDiasReservados();
        BigDecimal precoDiaria = this.getPrecoDiaria();

        return BigDecimal.valueOf(precoDiaria.doubleValue() * qtDiasReservados);
    }
}
