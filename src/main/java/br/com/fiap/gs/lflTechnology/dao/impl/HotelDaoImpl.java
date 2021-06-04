package br.com.fiap.gs.lflTechnology.dao.impl;

import br.com.fiap.gs.lflTechnology.dao.HotelDAO;
import br.com.fiap.gs.lflTechnology.model.Hotel;

import javax.persistence.EntityManager;

public class HotelDaoImpl extends GenericDaoImpl<Hotel, Integer> implements HotelDAO {

    public HotelDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
