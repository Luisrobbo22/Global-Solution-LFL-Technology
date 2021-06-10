package br.com.fiap.gs.lflTechnology.dao.impl;

import br.com.fiap.gs.lflTechnology.dao.QuartoDAO;
import br.com.fiap.gs.lflTechnology.model.Quarto;

import javax.persistence.EntityManager;
import java.util.List;

public class QuartoDaoImpl extends GenericDaoImpl<Quarto, Integer> implements QuartoDAO {

    public QuartoDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Quarto> buscarTodosOsQuartosEOrdernarPorMenorPreco(Quarto quarto) {
        return em.createQuery("FROM Quarto q order by q.preco desc", Quarto.class)
                .getResultList();
    }
}
