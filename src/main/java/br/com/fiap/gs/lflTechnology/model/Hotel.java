package br.com.fiap.gs.lflTechnology.model;

import jakarta.validation.constraints.Email;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name = "hotel", sequenceName = "SQ_LFL_HOTEL", allocationSize = 1)
@Table(name = "T_LFL_HOTEL")
public class Hotel {

    @Id
    @GeneratedValue(generator = "hotel", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_hotel")
    private Integer id;

    @Column(name = "nm_hotel", nullable = false, length = 100)
    private String nome;

    @Column(name = "ds_hotel", nullable = false, length = 500)
    private String descricao;

    @Column(name = "nr_telefone", nullable = false, length = 25)
    private String telefone;

    @Column(name = "ds_email", length = 60)
    @Email
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Quarto> quartos;

    public void AddQuartos(Quarto quarto) {
        if (quartos == null)
            quartos = new ArrayList<>();

        // Adicionar o quarto na lista de quartos
        quartos.add(quarto);
        quarto.setHotel(this);
    }

    public Hotel() {
    }

    public Hotel(String nome, String descricao, String telefone, String email, Endereco endereco) {
        this.nome = nome;
        this.descricao = descricao;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
