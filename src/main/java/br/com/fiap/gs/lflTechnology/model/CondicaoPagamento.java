package br.com.fiap.gs.lflTechnology.model;

import br.com.fiap.gs.lflTechnology.model.enums.TipoPagamento;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "condPagamento", sequenceName = "SQ_LFL_CONDICAO_PAGAMENTO", allocationSize = 1)
@Table(name = "T_LFL_CONDICAO_PAGAMENTO")
public class CondicaoPagamento {

    @Id
    @GeneratedValue(generator = "condPagamento", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_condicao_pagamento")
    private Integer id;

    @Column(name = "ds_condicao_pagamento")
    private String descricao;

    @Column(name = "nr_qntd_parcelas", nullable = false)
    private Integer quantidadeParcelas;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_tipo_pagamento", nullable = false)
    private TipoPagamento tipoPagamento;

    @OneToOne(mappedBy = "cd_condicao_pagamento")
    private Preco preco;

    public CondicaoPagamento() {
    }

    public CondicaoPagamento(String descricao, Integer quantidadeParcelas, TipoPagamento tipoPagamento, Preco preco) {
        this.descricao = descricao;
        this.quantidadeParcelas = quantidadeParcelas;
        this.tipoPagamento = tipoPagamento;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Preco getPreco() {
        return preco;
    }

    public void setPreco(Preco preco) {
        this.preco = preco;
    }
}
