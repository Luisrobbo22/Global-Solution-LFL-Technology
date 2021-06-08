package br.com.fiap.gs.lflTechnology.dao.impl;

import br.com.fiap.gs.lflTechnology.dao.UsuarioDAO;
import br.com.fiap.gs.lflTechnology.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDAO {

    public UsuarioDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean exist(Usuario usuario) {
        TypedQuery<Usuario> query =
                em.createQuery("SELECT u FROM Usuario u WHERE u.email = :pEmail and u.senha =:pSenha", Usuario.class)
                        .setParameter("pEmail", usuario.getEmail())
                        .setParameter("pSenha", usuario.getSenha());

        try {
            query.getSingleResult();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public List<Usuario> getAll() {
        return em.createQuery("SELECT u FROM Usuario u").getResultList();
    }
}
