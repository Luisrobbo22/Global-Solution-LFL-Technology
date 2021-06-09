package br.com.fiap.gs.lflTechnology.model;

import br.com.fiap.gs.lflTechnology.model.enums.TipoPessoa;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "T_LFL_USUARIO", schema = "globalsolution")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_usuario")
    private Integer id;

    @Column(name = "nm_usuario", nullable = false)
    private String nome;

    @Column(name = "ds_email", nullable = false)
    private String email;

    @Column(name = "ds_senha", nullable = false)
    private String senha;

    @Temporal(TemporalType.DATE)
    @Column(name= "dt_nascimento", nullable = false)
    private Calendar dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_tipo_pessoa", nullable = false)
    private TipoPessoa tipoPessoa;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, Calendar dataNascimento, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.tipoPessoa = tipoPessoa;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
