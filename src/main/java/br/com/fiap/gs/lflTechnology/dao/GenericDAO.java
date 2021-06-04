package br.com.fiap.gs.lflTechnology.dao;

import br.com.fiap.gs.lflTechnology.exception.CommitException;
import br.com.fiap.gs.lflTechnology.exception.EntityNotFoundException;

public interface GenericDAO<E, K> {

    void create(E entity);

    E read(K id) throws EntityNotFoundException;

    void update(E entity);

    void delete(K id) throws EntityNotFoundException;

    void commit() throws CommitException;

}
