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

    @
    private CondicaoPagamento condicaoPagamento;


}
