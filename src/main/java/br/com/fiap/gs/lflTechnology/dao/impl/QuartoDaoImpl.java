package br.com.fiap.gs.lflTechnology.dao.impl;

import br.com.fiap.gs.lflTechnology.dao.QuartoDAO;
import br.com.fiap.gs.lflTechnology.model.Quarto;

import javax.persistence.EntityManager;

public class QuartoDaoImpl extends GenericDaoImpl<Quarto, Integer> implements QuartoDAO {

    public QuartoDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
