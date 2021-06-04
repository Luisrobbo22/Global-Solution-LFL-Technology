package br.com.fiap.gs.lflTechnology.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "quarto", sequenceName = "SQ_LFL_QUARTO", allocationSize = 1)
@Table(name = "T_LFL_QUARTO")
public class Quarto {

    @Id
    @GeneratedValue(generator = "quarto", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_quarto")
    private Integer id;

    @Column(name = "nm_quarto", nullable = false, length = 100)
    private String nome;

    @Column(name = "ds_quarto", nullable = false, length = 500)
    private String descricao;

    @Column(name = "md_metros_quadrados")
    private double tamanhoMetrosQuadrados;

    @Column(name = "ds_comodidades", length = 1000)
    private String descricaoComodidades;


    private Preco preco;

}
