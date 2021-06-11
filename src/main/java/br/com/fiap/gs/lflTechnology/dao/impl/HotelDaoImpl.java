package br.com.fiap.gs.lflTechnology.dao.impl;

import br.com.fiap.gs.lflTechnology.dao.HotelDAO;
import br.com.fiap.gs.lflTechnology.model.Hotel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class HotelDaoImpl extends GenericDaoImpl<Hotel, Integer> implements HotelDAO {

    public HotelDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Hotel> buscarHotelPorCidadeEEstado(String cidade, String estado) {
        TypedQuery<Hotel> query =
                em.createQuery("SELECT h FROM Hotel h WHERE h.endereco.cidade like :pCidade and h.endereco.estado like :pEstado", Hotel.class)
                        .setParameter("pCidade", cidade)
                        .setParameter("pEstado", estado);

        return query.getResultList();
    }

    @Override
    public List<Hotel> getAll() {
        return em.createQuery("FROM Hotel", Hotel.class).getResultList();
    }

    @Override
    public Hotel findById(Integer id) {
        return em.createQuery("FROM Hotel h WHERE h.id =:pId", Hotel.class)
                .setParameter("pId", id)
                .getSingleResult();
    }

    @Override
    public List<Hotel> buscarHoteisPorAvaliacoes(int estrelas) {
        return em.createQuery("From Hotel h WHERE h.avaliacao =:pEstrelas", Hotel.class)
                .setParameter("pEstrelas", estrelas)
                .getResultList();
    }
}
