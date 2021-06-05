package br.com.fiap.gs.lflTechnology.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

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

    @Column(name = "nr_dias_reservados")
    @Min(1)
    @Max(350)
    private Integer diasReservados;

    @ManyToOne
    @JoinColumn(name = "quartos", nullable = false)
    private Hotel hotel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getTamanhoMetrosQuadrados() {
        return tamanhoMetrosQuadrados;
    }

    public void setTamanhoMetrosQuadrados(double tamanhoMetrosQuadrados) {
        this.tamanhoMetrosQuadrados = tamanhoMetrosQuadrados;
    }

    public String getDescricaoComodidades() {
        return descricaoComodidades;
    }

    public void setDescricaoComodidades(String descricaoComodidades) {
        this.descricaoComodidades = descricaoComodidades;
    }

    public Integer getDiasReservados() {
        return diasReservados;
    }

    public void setDiasReservados(Integer diasReservados) {
        this.diasReservados = diasReservados;
    }
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
