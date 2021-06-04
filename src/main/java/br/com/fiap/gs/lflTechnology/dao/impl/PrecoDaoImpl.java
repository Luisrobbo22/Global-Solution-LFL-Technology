package br.com.fiap.gs.lflTechnology.dao.impl;

import br.com.fiap.gs.lflTechnology.dao.PrecoDAO;
import br.com.fiap.gs.lflTechnology.model.Preco;

import javax.persistence.EntityManager;

public class PrecoDaoImpl extends GenericDaoImpl<Preco, Integer> implements PrecoDAO {

    public PrecoDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
