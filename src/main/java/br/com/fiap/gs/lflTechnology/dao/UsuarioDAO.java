package br.com.fiap.gs.lflTechnology.dao;

import br.com.fiap.gs.lflTechnology.model.Usuario;

import java.util.List;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

    public boolean exist(Usuario usuario);

    public List<Usuario> getAll();
}
