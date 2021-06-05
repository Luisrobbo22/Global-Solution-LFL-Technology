package br.com.fiap.gs.lflTechnology.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "T_LFL_PRECO")
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_preco")
    private Integer id;

    @Column(name = "vl_preco_diaria", nullable = false)
    private BigDecimal precoDiaria;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_atualizacao")
    private Calendar dataAtualizacao;


    @OneToOne(mappedBy = "preco")
    private Quarto quarto;

    @ManyToMany
    @JoinTable(name = "T_LFL_PRECO_CONDICAO_PAGAMENTO",
            joinColumns = @JoinColumn(name = "cd_preco"),
            inverseJoinColumns = @JoinColumn(name = "cd_condicao_pagamento"))
    private List<CondicaoPagamento> condicoesPagamentos;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public List<CondicaoPagamento> getCondicoesPagamentos() {
        return condicoesPagamentos;
    }

    public void setCondicoesPagamentos(List<CondicaoPagamento> condicoesPagamentos) {
        this.condicoesPagamentos = condicoesPagamentos;
    }


    public BigDecimal calculaPrecoTotal(Quarto quarto) {
        Integer qtDiasReservados = quarto.getDiasReservados();
        BigDecimal precoDiaria = this.getPrecoDiaria();

        return BigDecimal.valueOf(precoDiaria.doubleValue() * qtDiasReservados);
    }
}
