package br.com.fiap.gs.lflTechnology.model;

import javax.persistence.*;

@Entity
@Table(name = "T_LFL_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_endereco")
    private Integer id;

    @Column(name = "nm_logradouro", nullable = false, length = 255)
    private String logradouro;

    @Column(name = "nm_cidade", nullable = false, length = 150)
    private String cidade;

    @Column(name = "nm_estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "nr_cep", nullable = false, length = 9)
    private String cep;

    @Column(name = "nm_pais", nullable = false, length = 80)
    private String pais;

    @OneToOne(mappedBy = "endereco")
    private Hotel hotel;

    public Endereco() {
    }

    public Endereco(String logradouro, String cidade, String estado, String cep, String pais, Hotel hotel) {
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.pais = pais;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
