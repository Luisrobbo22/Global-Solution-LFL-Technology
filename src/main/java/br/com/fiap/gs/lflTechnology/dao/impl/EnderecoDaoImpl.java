package br.com.fiap.gs.lflTechnology.dao.impl;

import br.com.fiap.gs.lflTechnology.dao.EnderecoDAO;
import br.com.fiap.gs.lflTechnology.model.Endereco;

import javax.persistence.EntityManager;

public class EnderecoDaoImpl extends GenericDaoImpl<Endereco, Integer> implements EnderecoDAO {

    public EnderecoDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
