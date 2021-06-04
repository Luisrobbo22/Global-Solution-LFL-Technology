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
}
