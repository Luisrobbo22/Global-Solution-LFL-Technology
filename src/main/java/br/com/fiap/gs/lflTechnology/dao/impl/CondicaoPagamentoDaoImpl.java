package br.com.fiap.gs.lflTechnology.dao.impl;

import br.com.fiap.gs.lflTechnology.dao.CondicaoPagamentoDAO;
import br.com.fiap.gs.lflTechnology.model.CondicaoPagamento;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

public class CondicaoPagamentoDaoImpl extends GenericDaoImpl<CondicaoPagamento, Integer> implements CondicaoPagamentoDAO {

    public CondicaoPagamentoDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
